//1.


import React from "react";
import {useSelector} from "react-redux";
import {Card,Descriptions,Button} from "antd";
import Router, { useRouter } from "next/router";

export default function MyPage(){
    //Redux에서 회원가입시 저장된 사용자 정보 가져오기 -user
    const {user}=useSelector( (state)=>state.auth);

    if(!user){
        return(
            <div style={{maxWidth:600 ,margin:"40px auto"}}>
                <p>로그인된 사용자 없습니다.</p>
                <Button type="primary" onClick={()=>Router.push("/signup")}>
                    회원가입 하러가기
                </Button>
            </div>
        );
    }

    ////////////////////
    return (
        <div style={{maxWidth:600,margin:"40px auto"}}>
            <Card title="마이페이지(회원정보)"> 
                <Descriptions title="User Info" bordered column={1}>
                <Descriptions.Item label="회원 번호">{user.id}</Descriptions.Item>
                <Descriptions.Item label="이메일">{user.email}</Descriptions.Item>
                <Descriptions.Item label="닉네임">{user.nickname}</Descriptions.Item>
                </Descriptions>
            </Card>

        </div>
    );
}
