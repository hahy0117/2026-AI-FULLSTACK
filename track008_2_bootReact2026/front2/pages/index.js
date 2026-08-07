// pages/index.js
import React, {useEffect , useState} from 'react'; // 이벤트변경감지 , useState (변수변경)
import { useSelector, useDispatch }  from "react-redux";  // 전역상태, 스토어알림
import { fetchPostsRequest  , updatePostRequest , deletePostRequest}  from "../reducers/postReducer";
import { Spin, Upload}  from 'antd';
import PostList from '../components/PostList';
import EditPostModal from '../components/EditPostModal';

export   default function Home(){
    const   dispatch = useDispatch();  
    const {user} =useSelector((state)=>state.auth);
    const { posts , loading, error } = useSelector(  (state) => state.post );

    //수정모달 :  isEditModalVisible , setIsEditModalVisible
    const [isEditModalVisible , setIsEditModalVisible] = useState(false);
    //수정할글 :  editPost           , setEditPost
    const [editPost , setEditPost] = useState(null);
    const [uploadFiles, setUploadFiles] = useState([]);

    //수정기능 :  hadleEditSubmit
    const handleEdit = (post)=>{
        dispatch(updatePostRequest({
            userId:user?.id,
            postId:editPost.id,
                     dto:{
                content: values.content,
                hashtags: Array.isArray(values.hashtags)
                ? values.hashtags.join(",")
                : values.hashtags,
            } ,
            files:UploadFiles
        }       ));
  

        setEditPost(post);   // 수정글셋팅
        setIsEditModalVisible(true);  // 수정화면 보이기
    } 
    const hadleEditSubmit=(values)=>{
        dispatch(  updatePostRequest(   { 
             postId: editPost.id , dto:{ content:values.content }
        })  );   // 수정기능 후
        setIsEditModalVisible(false); // 화면안보이기 
        setEditPost(null);
    };

    // 페이지가 처음뜰때 게시글 조회 액션 - dispatch    
    useEffect( ()=> {
        dispatch(fetchPostsRequest());
    } , [dispatch]);

    // 삭제기능
    const handleDelete = ( postId )=>{
        dispatch( deletePostRequest( postId ) );  // 해당글번호
    }
    //////////
    return (
        <>
            <PostList 
                posts={posts} 
                handleEdit={handleEdit}
                handleDelete={handleDelete}
            />
            <EditPostModal 
                visible={isEditModalVisible}
                onCancel={()=> setIsEditModalVisible(false)}
                editPost={editPost}
                onSubmit={hadleEditSubmit}
                uploadFiles={uploadFiles}
                setUploadFiles={setUploadFiles}
            />
        </>
    );
}
//npm run dev  
// {/* 수정부품 */}    