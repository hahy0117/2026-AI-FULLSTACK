import {combineReducers} from '@reduxjs/toolkit'; //여러개의 리듀서를 합치는 Redux 함수
import authReducer              from './authReducer'; // 사용자 관련 상태를 관리하는 user 리듀서
import postReducer         from './postReducer'; // 사용자 관련 상태를 관리하는 post 리듀서

const rootReducer = combineReducers({
    auth:authReducer,
    post:postReducer,
});

export default rootReducer;