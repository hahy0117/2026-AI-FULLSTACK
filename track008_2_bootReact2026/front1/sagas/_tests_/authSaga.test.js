

import { put } from 'redux-saga/effects';

import {
    signupRequest,
    signupSuccess,
    fetchUserRequest,
    fetchUserSuccess
} from '../../reducers/authReducer';

import { signup, fetchUser } from '../authSaga';


jest.mock('axios');


describe('auth saga', () => {

    afterEach(() => {
        jest.clearAllMocks();
    });


    // -----------------------------
    // 회원가입 Saga 테스트
    // -----------------------------
    it('signup success', () => {

        const userData = {
            email: '1@1',
            password: '1'
        };

        // 화면에서 signupRequest 발생
        const action = signupRequest(userData);

        // saga 실행
        const generator = signup(action);


        // 1단계 : API 호출 확인
        const callStep = generator.next().value;

        expect(callStep.type).toBe('CALL');


        // API 응답 가정
        const mockResponse = {
            data: {
                id: 1,
                email: '1@1'
            }
        };


        // 2단계 : 성공 action 확인
        const putStep = generator.next(mockResponse).value;


        expect(putStep).toEqual(
            put(signupSuccess(mockResponse.data))
        );


        // saga 종료 확인
        expect(generator.next().done).toBe(true);

    });



    // -----------------------------
    // 사용자 단건 조회 Saga 테스트
    // -----------------------------
    it('fetchUser success', () => {


        const action = fetchUserRequest(1);

        const generator = fetchUser(action);



        // 1단계 : API 호출 확인
        const callStep = generator.next().value;

        expect(callStep.type).toBe('CALL');



        // API 응답 가정
        const mockResponse = {
            data: {
                id: 1,
                email: '1@1'
            }
        };



        // 2단계 : 성공 action 확인
        const putStep = generator.next(mockResponse).value;



        expect(putStep).toEqual(
            put(fetchUserSuccess(mockResponse.data))
        );



        // saga 종료 확인
        expect(generator.next().done).toBe(true);

    });

});