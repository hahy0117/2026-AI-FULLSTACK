import { all, call, put, takeLatest } from 'redux-saga/effects';
import axios from 'axios';

import {
    signupRequest,
    signupSuccess,
    signupFailure,
    fetchUserRequest,
    fetchUserSuccess,
    fetchUserFailure,
} from '../reducers/authReducer';

const USER_API_BASE = 'http://localhost:8080/api/users';

// 회원가입 API
export const signupApi = (userData) =>
    axios.post(USER_API_BASE, userData);

// 회원가입 Saga
export function* signup(action) {
    try {
        const result = yield call(signupApi, action.payload);
        yield put(signupSuccess(result.data));
    } catch (err) {
        yield put(signupFailure(err.response?.data?.message || err.message));
    }
}

// 단건조회 API
export const fetchUserApi = (userId) =>
    axios.get(`${USER_API_BASE}/${userId}`);

// 단건조회 Saga
export function* fetchUser(action) {
    try {
        const result = yield call(fetchUserApi, action.payload);
        yield put(fetchUserSuccess(result.data));
    } catch (err) {
        yield put(fetchUserFailure(err.response?.data?.message || err.message));
    }
}

// watcher
function* watchSignup() {
    yield takeLatest(signupRequest.type, signup);
}

function* watchFetchUser() {
    yield takeLatest(fetchUserRequest.type, fetchUser);
}

// root saga
export default function* authSaga() {
    yield all([
        call(watchSignup),
        call(watchFetchUser),
    ]);
}