import { Card, Form, Input, Button, message } from "antd";
import { useSelector,useDispatch } from "react-redux";
import { useRouter } from "next/router";
import { createPostRequest } from "../../reducers/postReducer";

export default function MyPostPage() {
    //유저정보 가져오기(useSelector:전역정보)
    const router =useRouter();
    const dispatch=useDispatch();
    const{loading,error}=useSelector( (state)=>state.post); // 글정보
    const{user}=useSelector( (state)=>state.auth);//유저정보 user

    //게시글 작성 (dispatch(createPostRequest(dto)):이벤트발생알림)
    const onFinish=(values)=>{
        const dto={
            content:values.content,
            userId: user?.id || 43
        };
        dispatch(createPostRequest(dto));
        message.success("게시글 작성요청완료")
        router.push("/");
    };
    //////////////////// Q1. view

  return (
    <div style={{ maxWidth: 600, margin: "40px auto" }}>
      <Card title="게시글 작성" style={{maxWidth:600, margin:"0 auto"}}>
        <Form onFinish={onFinish} layout="vertical">
          <Form.Item
            label="내용"
            name="content"
            hasFeedback
            rules={[{required:true,message:'내용을 입력하세요'}]}
          >
             <Input.TextArea rows={4} placeholder="게시글 내용을 입력하세요."/>
          </Form.Item>
          <Button type="primary" htmlType="submit" >
            게시글 작성
          </Button>
          {error && <p style={{color:"red"}}>{error}</p>}
        </Form>
      </Card>
    </div>
  );
}
