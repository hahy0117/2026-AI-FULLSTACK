
import authReducer ,{
    signupRequest,signupSuccess,signupFailure,fetchUserRequest,fetchUserSuccess,fetchUserFailure,
    resetUserState
}from '../authReducer';

describe('user slice reducer',()=>{
    const initialState={
        user:null,
        loading:false,
        error:null,
        success:false,
    };



    it('signupRequest',()=>{
        const state=authReducer(initialState,signupRequest());
        expect(state.loading).toBe(true);
        expect(state.error).toBeNull();
        expect(state.success).toBe(false);
    });
    it('signupSuccess',()=>{ // {type:signupSuccess,payload:userData}
        const userData={id:1,email:'1@1'};
        const state=authReducer(initialState,signupSuccess(userData));
        //1. signupSuccess(userData) 실행화면 - {id:1,email:'1@1'};
        //2.리듀서툴킷에서 {type:signupSuccess,payload:userData} 객체만들기
        //3.리듀서의 signupSuccess:(state,action)=>{} 액션받아서 처리
        //action ={type:signupSuccess ,payload:userData}
        expect(state.loading).toBe(false);
        expect(state.user).toEqual(userData);
        expect(state.success).toBe(true);
    });
    it('signupFailure',()=>{
        const state =authReducer(initialState,signupFailure('회원가입 실패'));
         //1. signupSuccess(userData) 실행화면 - {id:1,email:'1@1'};
        //2.리듀서툴킷에서 {type:signupSuccess,payload:userData} 객체만들기
        //3.리듀서의 signupSuccess:(state,action)=>{} 액션받아서 처리
        //action ={type:signupFailure ,payload:'회원가입 실패'}
        expect(state.loading).toBe(false);
        expect(state.error).toBe('회원가입 실패');

    });



    ////////////////////////////////////
    it('fetchUserSuccess',()=>{
        const userData ={id:1,email:'1@1'};
        const state =authReducer(initialState,fetchUserSuccess(userData));

        expect(state.user).toEqual(userData);
        expect(state.loading).toBe(false);
    });

    it('resetUserState',()=>{
        const prev ={user:{id:1},loading:true,error:'err',success:true};
        const state=authReducer(prev,resetUserState());

        expect(state.loading).toBe(false);
        expect(state.error).toBe(null);
        expect(state.success).toBe(false);
    });


});
