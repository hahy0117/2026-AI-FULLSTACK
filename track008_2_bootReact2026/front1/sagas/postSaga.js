import {all,call,put, takeLatest} from 'redux-saga/effects';
import axios from 'axios';
import   {fetchPostsRequest,fetchPostsSuccess,fetchPostsFailure,
    fetchPostDetailRequest,fetchPostDetailSuccess,fetchPostDetailFailure,
    createPostRequest,createPostSuccess,createPostFailure,
    updatePostRequest,updatePostSuccess,updatePostFailure,
    deletePostRequest,deletePostSuccess,deletePostFailure,
    resetPostState //초기화
} from '../reducers/postReducer';

const POST_API_BASE = 'http://localhost:8080/api/posts';

export const fetchPostApi =()=>axios.get(POST_API_BASE);
export function* fetchPosts() {
    try {
        const result = yield call(fetchPostApi);
        yield put(fetchPostsSuccess(result.data));
    } catch (err) {
        yield put(fetchPostsFailure(err.response?.data?.message || err.message));
    }
}

export const fetchPostDetailAPI=(id)=>axios.get(`${POST_API_BASE}/${id}`);
export function* fetchPostDetail(action){
     try{
        const result = yield call (fetchPostDetailAPI,action.payload) // 사용자가 넘겨준 값
        yield put(fetchPostDetailSuccess(result.data));
    }catch(err){
        yield put(fetchPostDetailFailure(err.response?.data?.message || err.message));
    }
}

export const createPostAPI=(postData)=>axios.post(POST_API_BASE,postData);
export function* createPost(action){
    try{
        const result = yield call (createPostAPI,action.payload) // 사용자가 넘겨준 값
        yield put(createPostSuccess(result.data));
    }catch(err){
        yield put(createPostFailure(err.response?.data?.message || err.message));
    }
}
//export const updatePostAPI =({postId,dto})=>axios.get(POST_API_BASE,postData);
export const updatePostAPI = ({postId, dto}) => axios.put(`${POST_API_BASE}/${postId}`, dto);
export function* updatePost(action){
    try{
        const result = yield call (updatePostAPI,action.payload) // 사용자가 넘겨준 값
        yield put(updatePostSuccess(result.data));
    }catch(err){
        yield put(updatePostFailure(err.response?.data?.message || err.message));
    }
}

//delete 게시글 삭제
export const deletePostAPI=(id)=> axios.delete(`${POST_API_BASE}/${id}`);
export function* deletePost(action){
    //action ={type: ,payload:{}}
    try{
        yield call (deletePostAPI,action.payload) // 사용자가 넘겨준 값
        yield put(deletePostSuccess(action.payload))
    }catch(err){
        yield put(deletePostFailure(err.response?.data?.message || err.message));
    }
    
}


function* watchFetchPosts(){
    yield takeLatest(fetchPostsRequest.type,fetchPosts);
}
function* watchFetchPostDetail(){
    yield takeLatest(fetchPostDetailRequest.type,fetchPostDetail);
}
function* watchCreatePost(){
    yield takeLatest(createPostRequest.type,createPost);
}
function* watchUpdatePost(){
    yield takeLatest(updatePostRequest.type,updatePost);
}
function* watchDeletePost(){
    yield takeLatest(deletePostRequest.type,deletePost);
}

export default function* postSaga(){
    yield all([
        call(watchFetchPosts),
        call(watchFetchPostDetail),
        call(watchCreatePost),
        call(watchUpdatePost),
        call(watchDeletePost),
    ]);
}
