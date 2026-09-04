// pages/index.js

import React, { useEffect, useState } from 'react';
import { useSelector, useDispatch } from 'react-redux';

import {
    fetchPostsRequest,
    updatePostRequest,
    deletePostRequest
} from '../reducers/postReducer';

import { Spin } from 'antd';

import PostList from '../components/PostList';
import EditPostModal from '../components/EditPostModal';


export default function Home() {

    // Redux
    const dispatch = useDispatch();

    const { user } = useSelector((state) => state.auth);

    const {
        posts,
        loading,
        error
    } = useSelector((state) => state.post);


    // ========================================
    // 수정 모달 관련 state
    // ========================================

    // 수정 모달 보이기 / 숨기기
    const [
        isEditModalVisible,
        setIsEditModalVisible
    ] = useState(false);

    // 현재 수정할 게시글
    const [
        editPost,
        setEditPost
    ] = useState(null);

    // 수정할 이미지 파일
    const [
        uploadFiles,
        setUploadFiles
    ] = useState([]);


    // ========================================
    // 게시글 수정 버튼 클릭
    // ========================================     
    // ========================================

    const handleEdit = (post) => {

        console.log('수정할 게시글:', post);

        // 게시글이 없으면 중단
        if (!post) {
            console.error('수정할 게시글이 없습니다.');
            return;
        }

        // 수정할 게시글 저장
        setEditPost(post);

        // 기존 업로드 파일 초기화
        setUploadFiles([]);

        // 수정 모달 열기
        setIsEditModalVisible(true);
    };


    // ========================================
    // 수정 모달에서 저장 버튼 클릭
    // ========================================

    const handleEditSubmit = (values) => {

        console.log('수정 데이터:', values);
        console.log('수정 게시글:', editPost);
        console.log('업로드 파일:', uploadFiles);


        // 수정할 게시글이 없으면 중단
        if (!editPost) {
            console.error('수정할 게시글이 없습니다.');
            return;
        }


        // ====================================
        // 게시글 수정 요청
        // ====================================

        dispatch(
            updatePostRequest({

                // 로그인한 사용자 ID
                userId: user?.id,

                // 수정할 게시글 ID
                postId: editPost.id,

                // 게시글 데이터
                dto: {
                    content: values.content,

                    hashtags: Array.isArray(values.hashtags)
                        ? values.hashtags.join(',')
                        : values.hashtags
                },

                // 이미지 파일
                files: uploadFiles
            })
        );


        // ====================================
        // 수정 모달 닫기
        // ====================================

        setIsEditModalVisible(false);

        // 수정 게시글 초기화
        setEditPost(null);

        // 업로드 파일 초기화
        setUploadFiles([]);
    };


    // ========================================
    // 게시글 조회
    // ========================================

    useEffect(() => {

        dispatch(fetchPostsRequest());

    }, [dispatch]);


    // ========================================
    // 게시글 삭제
    // ========================================

    const handleDelete = (postId) => {

        dispatch(
            deletePostRequest(postId)
        );

    };


    // ========================================
    // 수정 모달 취소
    // ========================================

    const handleEditCancel = () => {

        // 모달 닫기
        setIsEditModalVisible(false);

        // 수정 게시글 초기화
        setEditPost(null);

        // 업로드 파일 초기화
        setUploadFiles([]);
    };


    // ========================================
    // 화면
    // ========================================

    return (
        <>

            {/* 로딩 */}
            {loading && (
                <Spin />
            )}


            {/* 에러 */}
            {error && (
                <div>
                    오류가 발생했습니다: {error}
                </div>
            )}


            {/* 게시글 목록 */}
            <PostList
                posts={posts}
                handleEdit={handleEdit}
                handleDelete={handleDelete}
            />


            {/* 게시글 수정 모달 */}
            <EditPostModal

                // 모달 표시 여부
                visible={isEditModalVisible}

                // 취소 버튼
                onCancel={handleEditCancel}

                // 수정할 게시글
                editPost={editPost}

                // 수정 완료
                onSubmit={handleEditSubmit}

                // 업로드 파일
                uploadFiles={uploadFiles}

                // 업로드 파일 변경
                setUploadFiles={setUploadFiles}
            />

        </>
    );
}


// npm run dev