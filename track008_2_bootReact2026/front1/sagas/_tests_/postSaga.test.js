
import{call,put} from 'redux-saga/effects';
import{  fetchPostsRequest , fetchPostsSuccess, fetchPostsFailure ,   //  전체글
                fetchPostDetailRequest  , fetchPostDetailSuccess  , fetchPostDetailFailure,  //상세글 
                createPostRequest , createPostSuccess , createPostFailure ,  // 글쓰기
                updatePostRequest ,  updatePostSuccess ,  updatePostFailure ,  // 글수정
                deletePostRequest ,  deletePostSuccess ,  deletePostFailure ,  // 글삭제
                resetUserState // 초기화
} from '../../reducers/postReducer';
import {fetchPosts,fetchPostDetail,
    createPost,updatePost,deletePost
}from '../postSaga';

jest.mock('axios');
describe('post saga',()=>{
    afterEach(()=>{jest.clearAllMocks()});

    //전체게시글 조회
    it('fetchUser',()=>{
        //화면요청
        const generator=fetchPosts(fetchPostsRequest());
        expect(generator.next().value.type).toBe('CALL');

        //결과물 받기
        const mockData=[{id:1,content:'post 1'}];
        const putStep=generator.next({data:mockData}).value;
        //결과물 확인
        expect(putStep).toEqual(put(fetchPostsSuccess(mockData)));
    });

        it('fetchPostDetail success', () => {
        const generator = fetchPostDetail(fetchPostDetailRequest(1));
        
        expect(generator.next().value.type).toBe('CALL');
        
        const mockData = { id: 1, content: 'detail' };
        const putStep = generator.next({ data: mockData }).value;
        
        expect(putStep).toEqual(put(fetchPostDetailSuccess(mockData)));
    });
 
    // it('fetchPostsPaged success', () => {
    //     const payload = { start: 0, end: 10 };
    //     const generator = fetchPostsPaged(fetchPostsPagedRequest(payload));
        
    //     expect(generator.next().value.type).toBe('CALL');
        
    //     const mockData = [{ id: 10 }, { id: 11 }];
    //     const putStep = generator.next({ data: mockData }).value;
        
    //     expect(putStep).toEqual(put(fetchPostsPagedSuccess(mockData)));
    // });
 
    it('createPost success', () => {
        const payload = { content: 'new' };
        const generator = createPost(createPostRequest(payload));
        
        expect(generator.next().value.type).toBe('CALL');
        
        const mockData = { id: 10, content: 'new' };
        const putStep = generator.next({ data: mockData }).value;
        
        expect(putStep).toEqual(put(createPostSuccess(mockData)));
    });
 
    it('updatePost success', () => {
        const payload = { id: 10, content: 'updated' };
        const generator = updatePost(updatePostRequest(payload));
        
        expect(generator.next().value.type).toBe('CALL');
        
        const putStep = generator.next({ data: payload }).value;
        
        expect(putStep).toEqual(put(updatePostSuccess(payload)));
    });
 
    it('deletePost success', () => {
        const generator = deletePost(deletePostRequest(1));
        
        expect(generator.next().value.type).toBe('CALL');
        
        const putStep = generator.next().value;
        
        expect(putStep).toEqual(put(deletePostSuccess(1)));
    });
    //단건조회
    //글쓰기
    //글수정
    //글삭제
})





