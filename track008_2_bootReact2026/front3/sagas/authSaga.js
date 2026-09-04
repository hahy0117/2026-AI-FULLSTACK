// // sagas/authSaga.js
// import { all, call, put, takeLatest} from  'redux-saga/effects';
// import  axios  from  'axios';
// import {signupRequest , signupSuccess , signupFailure,
//      resetUserState,
//      loginRequest,
//     loginSuccess,
//     loginFailure,
//      logoutRequest,
//     logoutSuccess,
//     logoutFailure,

//     updateNicknameRequest,
//     updateNicknameSuccess,
//     updateNicknameFailure,

//     updateProfileImageRequest,
//     updateProfileImageSuccess,
//     updateProfileImageFailure,
// } from '../reducers/authReducer';

// const USER_API_BASE = 'http://localhost:8080/auth';

// // ---  회원가입  POST  /api/users ---
// //POST: http://localhost:8080/auth/signup
// export  const  signupApi = ( formData )=> axios.post(  `${USER_API_BASE}/signup`, formData,{
//     headers:{"Content-Type":"multipart/form-data"},
// }  ); // /api/users
// //■2.  signup(action) - action.payload 사용자가 입력한 값 (회원정보)
// export  function*   signup(action){
//     // action = { type: user/signupRequest, payload: { email:'1@1' , password:'1'} }
//     try{
//         const result = yield  call( signupApi,  action.payload  );  //■3.  result.data
//         yield  put(signupSuccess(result.data)); // 처리결과 put
//     }catch(err){
//         yield  put(signupFailure(err.response?.data?.message || err.message));
//     }
// }
// //■1.takeLatest( signupRequest.type , signup) :  takeLatest - 요청이 여러번, 가장마지막발생요청 처리



// // --- 로그인    ---
// //POST:    /auth/login
// export  const  loginApi = ( payload )=> axios.get( `${USER_API_BASE}/login` );
// //■2) 
// export function*  login( action ){
//     // action = {type:user/fetchUserRequest , payload:1}
//     try{
//         const result = yield call(loginApi , action.payload);  //■3) 
//         yield put(  loginSuccess( result.data ) );
//     }catch(err){
//         yield put(  loginFailure( err.response?.data?.message || err.message ) );
//     }
// }

// //로그아웃 POST : /auth/logout 넘겨줄 데이터 X ---
// export const logoutApi=()=>axios.post(`${USER_API_BASE}/logout`);
// export function*  logout(){
//     // action = {type:user/fetchUserRequest , payload:1}
//     try{
//         yield call(logoutApi);
//         yield put(  logoutSuccess() );
//     }catch(err){
//         yield put(  logoutFailure( err.response?.data?.message || err.message ) );
//     }
// }

// //업데이트 닉네임 PATCH : /auth/{userId}/nickname, params를 통해서 닉네임 넘기기
// export const updateNicknameApi=({userId,nickname})=>axios.patch(`${USER_API_BASE}/${userId}/nickname`,null,{});
// export function*  updateNickname(){
   
//     try{
//         const result=yield call(updateNicknameApi,action.payload);
//         yield put(updateNicknameSuccess());
//     }catch(err){
//         yield put(  updateNicknameFailure( err.response?.data?.message || err.message ) );
//     }
// }
// //업데이트 프로필이미지 PATCH: /auth/{userId}/profile-image
// export function updateProfileImageApi({userId,file}){
//     const formData =new FormData();
//     formData.append("ufile",file);
//     return axios.patch(`{USER_API_BASE}/${userId}/profile-image`,formData,{
//         headers:{"Content-Type":"multipart/form-data"}
//     });
// }
// export function * updateProfileImage(action){
   
//     try{
//         const result=yield call(updateProfileImageApi,action.payload);
//         yield put(updateNicknameSuccess(result.data));
//     }catch(err){
//         yield put(  upadateNicknameFailure( err.response?.data?.message || err.message ) );
//     }
// }
// //■1) takeLatest : 여러번요청와도 1번만
// function* watchSignup(){   yield  takeLatest( signupRequest.type , signup );   }
// function* watchLogin(){   yield  takeLatest( fetchUserRequest.type , login );   }
// function* watchLogout(){   yield  takeLatest( loginRequet.type, logout );   }
// function* watchUpdateNickname(){   yield  takeLatest( updateNicknameRequest.type , updateNickname );   }
// function* watchUpdateProfileImage(){   yield  takeLatest( updateProfileImage.type , updateProfileImage );   }


// export default  function * authSaga(){
//     yield all([
//         call(watchSignup),
//         call(watchLogin),
//         call(watchLogout),
//         call(watchUpdateNickname),
//         call(watchUpdateProfileImage),
//     ]);
// }
 
// sagas/authSaga.js
import { all, call, put, takeLatest} from  'redux-saga/effects';
import  api from  '../api/axios';
import {signupRequest , signupSuccess , signupFailure,  resetUserState,
    loginRequest,loginSuccess,loginFailure,
    logoutRequest,logoutSuccess,logoutFailure,
    updateNicknameRequest, updateNicknameSuccess ,  updateNicknameFailure,
    updateProfileImageRequest , updateProfileImageSuccess , updateProfileImageFailure,
    loadUserRequest,loadUserSuccess,loadUserFailure //###
} from '../reducers/authReducer';

import Cookies from 'js-cookie'; //###

const USER_API_BASE = '/auth'; //###

// ---  회원가입  POST  /api/users ---
// POST : http://localhost:8080/auth/signup
export  const  signupApi = ( formData )=> api.post(  `${USER_API_BASE}/signup` , formData , {
    headers: { "Content-Type": "multipart/form-data"  },
} ); // /api/users

//■2.  signup(action) - action.payload 사용자가 입력한 값 (회원정보)
export  function*   signup(action){
    // action = { type: auth/signupRequest, payload: { email:'1@1' , password:'1'} }
    try{
        const result = yield  call( signupApi,  action.payload  );  //■3.  result.data
        yield  put(signupSuccess(result.data)); // 처리결과 put
    }catch(err){
        yield  put(signupFailure(err.response?.data?.message || err.message));
    }
}  

// ---  로그인       ---
// POST :     /auth/login
export  const  loginApi = ( payload )=> api.post( `${USER_API_BASE}/login`, payload); 
export function*  login( action ){
    // {email:'1@1', password:'1', provider:'local'}
    // action = {type:user/fetchUserRequest , payload:1}
    try{
        const result = yield call(loginApi , action.payload);  //■3) 
        //result=ResponseEntity<Map<Stringf,Object>>
        const accessToken=result.data?.accessToken;
        const user=result.data?.user;

        if(user && accessToken){
            if(typeof window !="undefined"){
                localStorage.setItem("accessToken",accessToken);
                Cookies.set("accessToken",accessToken);
            }
            yield put(  loginSuccess( user,accessToken ) );
        }
      
    }catch(err){
        yield put(  loginFailure( err.response?.data?.message || err.message ) );
    }
} 

//토큰 재발급
export const refreshApi=()=>{ return api.post(`${USER_API_BASE}/refresh`);}
export function * refresh(){
    try{
        const result=yield call(refreshApi);
        const newAccessToken=result.data?.accessToken || null;
        if(typeof window !="undefined" && newAccessToken){
            localStorage.setItem("accessToken",newAccessToken);
            Cookies.set("accessToken",newAccessToken);
        }
        yield put(refreshTokenSuccess({accessToken:newAccessToken}));
    }catch(err){
        yield put(refreshFailure(err.response?.data?.message||err.message));
        yield put(logout());
    }
}
// ---  로그아웃  POST  :  /auth/logout  넘겨줄 데이터 x    ---
export  const  logoutApi = (  )=> api.post( `${USER_API_BASE}/logout`);

export function*  logout(){ 
    try{
        yield call(logoutApi);  

        if(typeof window !="undefined"){
            localStorage.removeItem("accessToken");
            Cookies.remove("accessToken");
        }

        yield put(  logoutSuccess() );
    }catch(err){
        yield put(  logoutFailure( err.response?.data?.message || err.message ) );
    }
}



// ---  업데이트 닉네임  PATCH :  /auth/{userId}/nickname  ,  params를 통해서 닉네임넘기기 ---
export const updateNicknameApi=({userId,nickname})=> api.patch( `${USER_API_BASE}/${userId}/nickname`, null ,{
    params:{nickname} ,
}); 
export function*  updateNickname( action ){ 
    try{
        const result = yield call(updateNicknameApi , action.payload);   
        yield put( updateNicknameSuccess( result.data ) );
    }catch(err){
        yield put(  updateNicknameFailure( err.response?.data?.message || err.message ) );
    }
}   
// ---  업데이트 프로필이미지  PATCH:  /auth/{userId}/profile-image  , formData  ---
export   function updateProfileImageApi({userId,file}){ 
    const formData = new FormData();
    formData.append("ufile" , file);
    return  api.patch( `${USER_API_BASE}/${userId}/profile-image`, formData ,{
          headers : {"Content-Type": "multipart/form-data" }
    });    
}
export function*  updateProfileImage( action ){ 
    try{
        const result = yield call(updateProfileImageApi , action.payload);   
        yield put( updateProfileImageSuccess( result.data ) );
    }catch(err){
        yield put(  updateProfileImageFailure( err.response?.data?.message || err.message ) );
    }
}   
//유저 정보 로드
const loadUserApi=(cookieHader)=>api.get(`${USER_API_BASE}/me`,{
    headers:{cookie:cookieHader||""},
    withCredentials:true,
});
function * loadUser(action){
    try{
        const resutl=yield call(loadUserApi,action.payload?.cookie);
        yield put(loadUserSuccess(result.data));
    }catch(err){
        yield put(loadUserFailure(err.response?.data?.message||err.message));
    }
}

//■1) takeLatest : 여러번요청와도 1번만 
function* watchSignup(){            yield  takeLatest( signupRequest.type              , signup);       } 
function* watchLogin(){             yield  takeLatest( loginRequest.type               , login );       }
function* watchLogout(){            yield  takeLatest( logoutRequest.type              , logout );      }
function* watchUpdateNickname(){    yield  takeLatest( updateNicknameRequest.type      , updateNickname );    }
function* watchUpdateProfileImage(){yield  takeLatest( updateProfileImageRequest.type  , updateProfileImage );   }
function * watchLoadUser(){yield takeLatest(loadUserRequest.type,loadUser);}


export default  function * authSaga(){
    yield all([
        call(watchSignup),
        call(watchLogin),
        call(watchLogout),
        call(watchUpdateNickname),
        call(watchUpdateProfileImage),
        watchLoadUser(),
    ]);
}
 
