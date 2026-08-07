import { useSelector, useDispatch } from 'react-redux';
import { useState, useEffect } from 'react';
import { useRouter } from 'next/router';
import axios from 'axios';

import {
    SIGN_UP_REQUEST,
} from '../reducers/user';

export default function JoinPage() {

    const dispatch = useDispatch();
    const router = useRouter();

    const { me, isLoading, error, signUpDone } =
        useSelector((state) => state.user);


    // 입력값
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [nickname, setNickname] = useState('');


    // 이메일 중복확인
    const [emailMessage, setEmailMessage] = useState('');
    const [emailAvailable, setEmailAvailable] = useState(false);

    // 중복확인 로딩
    const [checkEmailLoading, setCheckEmailLoading] = useState(false);



    // 이메일 중복확인
    const checkEmail = async () => {

        if (!email.trim()) {

            setEmailMessage('이메일을 입력해주세요.');
            setEmailAvailable(false);
            return;

        }


        try {

            setCheckEmailLoading(true);


            const result = await axios.get(
                'http://localhost:3065/user/check-email',
                {
                    params: {
                        email
                    },
                    withCredentials: true
                }
            );


            setEmailMessage(result.data.message);
            setEmailAvailable(result.data.isAvailable);



        } catch (err) {


            setEmailMessage(
                err.response?.data?.message || '중복확인 실패'
            );

            setEmailAvailable(false);



        } finally {

            setCheckEmailLoading(false);

        }

    };



    // 이메일 변경 시 중복확인 초기화
    const onChangeEmail = (e) => {

        setEmail(e.target.value);

        setEmailMessage('');

        setEmailAvailable(false);

    };



    // 회원가입
    const onSubmit = (e) => {

        e.preventDefault();


        if (!email.trim()) {

            alert('이메일을 입력해주세요.');
            return;

        }


        if (!password.trim()) {

            alert('비밀번호를 입력해주세요.');
            return;

        }


        if (!nickname.trim()) {

            alert('닉네임을 입력해주세요.');
            return;

        }


        if (!emailAvailable) {

            alert('이메일 중복확인을 해주세요.');
            return;

        }



        dispatch({

            type: SIGN_UP_REQUEST,

            data: {

                email,

                password,

                nickname,

            },

        });


    };



    // 회원가입 성공
    useEffect(() => {

        if (signUpDone) {

            router.push({

                pathname: '/login',

                query: {

                    signUpSuccess: 'true',

                },

            });

        }


    }, [signUpDone, router]);




    // 로그인되어 있으면 users 이동
    useEffect(() => {

        if (me) {

            router.push('/users');

        }

    }, [me, router]);




    return (

        <div className="container my-4">


            <h3 className="mb-3">
                회원가입
            </h3>



            <form
                className="w-50 mx-auto"
                onSubmit={onSubmit}
            >


                {/* 이메일 */}

                <div className="mb-3">


                    <div className="d-flex">


                        <input

                            type="email"

                            className="form-control me-2"

                            placeholder="이메일 입력"

                            value={email}

                            onChange={onChangeEmail}

                        />



                        <button

                            type="button"

                            className="btn btn-outline-primary text-nowrap"

                            onClick={checkEmail}

                            disabled={checkEmailLoading}

                        >

                            {
                                checkEmailLoading
                                    ? '확인중...'
                                    : '중복확인'
                            }


                        </button>



                    </div>



                    {emailMessage && (

                        <div

                            className={`mt-2 ${
                                emailAvailable
                                    ? 'text-success'
                                    : 'text-danger'
                            }`}

                        >

                            {emailMessage}


                        </div>

                    )}



                </div>




                {/* 비밀번호 */}

                <div className="mb-3">


                    <input

                        type="password"

                        className="form-control"

                        placeholder="비밀번호 입력"

                        value={password}

                        onChange={(e) =>
                            setPassword(e.target.value)
                        }

                    />


                </div>




                {/* 닉네임 */}

                <div className="mb-3">


                    <input

                        type="text"

                        className="form-control"

                        placeholder="닉네임 입력"

                        value={nickname}

                        onChange={(e) =>
                            setNickname(e.target.value)
                        }

                    />


                </div>




                {/* 회원가입 버튼 */}

                <div className="mb-3">


                    <button

                        type="submit"

                        className="btn btn-primary w-100"

                        disabled={isLoading}

                    >

                        회원가입


                    </button>


                </div>



            </form>




            {error && (

                <div className="alert alert-danger mt-3">

                    {error}

                </div>

            )}



        </div>

    );

}