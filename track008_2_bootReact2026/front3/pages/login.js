//import /require
import React, { useEffect } from "react";//이벤트변경감지,useState (변수)
import { Provider, useDispatch, useSelector } from "react-redux"; //스토어알림,전역상태
import { Row, Col, Form, Input, Button, Spin, message } from "antd";  
import { useRouter} from "next/router"; //경로
import { loginRequest } from "../reducers/authReducer";




export default function LoginPage() { 
    //Q1. useDispatch , useRouter 초기화
    const dispatch = useDispatch(); 
    const router=useRouter();
    //Q2. useSelect 이용해서 user 상태 가져오기- user,londing ,error
    const {user,loading,error} = useSelector((state) => state.auth);  
    //Q3.로그인 버튼을 누르고  나면-스토어 알림(dispatch)이용해서 loginRequest 처리
    const onFinish=(values)=>{
        console.log(values);
        dispatch(loginRequest({...values,Provider:'local'}) );
    };
    //Q4.로그인 성공시 oo님 환영합니다 메시지 띄우고 (message),mypage 로 이동(router.push)
    useEffect(() => {
    if (user && user.email) {
        message.success(`${user.nickname || user.email}님 환영합니다!`);
        router.push("/mypage");
    }
}, [user, router]);

 const handleSocialLogin=(provider)=>{ 
        window.location.href = `http://localhost:8080/oauth2/authorization/${provider}`;
    }; 
    ////////////////////////////////////////////////////////////////////////////////

    return (
        <Row justify="center" style={{marginTop:40}}>
            <Col xs={24} sm={16} md={8}>  
                    <Form  layout="vertical" onFinish={onFinish}> 
                        <Form.Item 
                            label="이메일"
                            name="email" 
                            rules={[{required:true,message:"이메일을 입력하세요"}]}
                        >
                            <Input placeholder="aaa@gmail.com" />
                        </Form.Item>

                        <Form.Item 
                            label="비밀번호"
                            name="password" 
                            rules={[{required:true,message:"이메일을 입력하세요"}]}
                        >
                            <Input.Password placeholder="****" />
                        </Form.Item>         

                        <div style={{ textAlign: 'center', marginTop: 20 }}>
                            <Button 
                                type="primary" 
                                htmlType="submit"   
                                style={{ width: '200px', height: '50px' }}
                            >
                                로그인
                            </Button>
                        </div>
                    </Form> 
                                    {/*   소셜  로그인 이미지 버튼 */}
                <div style={{ marginTop: 20, textAlign: "center" }}>
                    <img
                        src="/images/google.png"       alt="Google Login"
                        style={{ cursor: "pointer", width: "200px", marginBottom: "10px" }}
                        onClick={()=> handleSocialLogin("google")}
                    />
                </div> 
                <div style={{ marginTop: 20, textAlign: "center" }}>
                    <img
                        src="/images/kakao.png"      alt="Kakao Login"
                        style={{ cursor: "pointer", width: "200px", marginBottom: "10px" }}
                        onClick={()=> handleSocialLogin("kakao")}
                    />
                </div>
                <div style={{ marginTop: 20, textAlign: "center" }}>
                    <img
                        src="/images/naver.png"      alt="Naver Login"
                        style={{ cursor: "pointer", width: "200px", marginBottom: "10px" }}
                        onClick={()=> handleSocialLogin("naver")}
                    />
                </div>
            </Col>
        </Row>
    );
}
//단순 랜더: 서버에서 데이터 가져오기 가공하지 않고,
//그냥 페이지 컴포넌트를 서버에 그려서 내주기
export async function getServerSideProps() {
  return { props: {} };
}
/**
 * 이렇게 처리 하려면?
 Q.로그인한 상태 :글쓰기(posts/new)/마이페이지(mypage)/로그아웃(logout)
 Q2.로그인 안한상태:로그인(login)/회원가입 (signup)
 */