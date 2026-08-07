// pages/index.js
import { useSelector, useDispatch } from "react-redux";
import { useState, useEffect } from "react";
import { useRouter } from "next/router";
import { deletePostRequest, fetchPostsRequest, updatePostRequest} from '../reducers/postReducer';
import { Spin } from "antd";
import PostList from "../components/PostList";
import EditPostModal from "../components/EditPostModal";

export default function Home(){
    const dispatch = useDispatch();
    const router = useRouter();
    //1. 유저 정보 가져오기 - state.user
    const { user } = useSelector((state) => state.auth);
    //2. 게시글 정보 가져오기 - state.post    
    const {posts, loading, error} = useSelector((state) => state.post);

    //수정 모달 :
    const [isEditModalVisible,setIsEditModalVisible]=useState(false);

    //수정할 글:
    const [editPost,setEditPost]=useState(null);

    const handleEdit=(post)=>{
        setEditPost(post); // 수정글 셋팅
        setIsEditModalVisible(true);
    };

    const handleEditSubmit=(values)=>{
        dispatch(
            updatePostRequest( {postId:editPost.id ,dto:{content:values.content}}));
     //수정 기능 후
        setIsEditModalVisible(false); //화면 안보이기
        setEditPost(null);
    };

    //페이지가 처음 뜰 때, 조회 액션 - dispatch
    useEffect(()=>{
        dispatch(fetchPostsRequest());
    },[dispatch]);

    //  ,삭제
    const handleDelete=(postId)=>{
        //console.log(postId)
        dispatch (deletePostRequest(postId)); //해당 글 번호
    }

    return (
        <>
            <PostList posts={posts} handleEdit={handleEdit} handleDelete={handleDelete}/>
            <EditPostModal
                        visible={isEditModalVisible}
                        onCancel={() => setIsEditModalVisible(false)}
                        editPost={editPost}
                        onSubmit={handleEditSubmit}     
                />
        </>
    );
}
{/* 수정 부품 */}