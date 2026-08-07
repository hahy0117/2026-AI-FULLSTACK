import { createSlice } from "@reduxjs/toolkit";

//초기화 상태(공용)
const initialState={
    user:null, //단건 조회된 사용자 정보
    loading:false,//로딩상태
    error:null,//에러메시지
    success:false, //성공여부
};

//상태 변화
const authReducer=createSlice({
    name:"user",
    initialState,
    reducers: {
        signupRequest: (state) => {
            state.loading=true;
            state.error=null;
            state.success=false;
        },
        signupSuccess: (state,action) => {
            state.loading=false;
            state.user=action.payload; // 가입된 회원정보저장
            state.success=true;
        },
        signupFailure: (state,action) => {
            state.loading=false;
            state.error=action.payload;
            state.success=false;
        },

        fetchUserRequest: (state)=>{
            state.loading=true;
            state.error=null;
            state.success=false;
        },
        fetchUserSuccess: (state,action)=>{
            state.loading=false;
            state.user=action.payload;
            state.success=true;
        },
        fetchUserFailure: (state,action)=>{
            state.loading=false;
            state.error=action.payload;
            state.success=false;
        },

        resetUserState: (state)=>{
            state.loading=false;
            state.error=null;
            state.success=false;
        },
    },
});
//action
export const {signupRequest,signupSuccess,signupFailure,
    fetchUserRequest,fetchUserSuccess,fetchUserFailure,
    resetUserState
} =authReducer.actions;
//4.export
export default authReducer.reducer;