
//express 모듈
const express= require('express');

const app=express();
//get 경로 설정
app.get('/',(req,res)=>{
    res.send('hello express');
});

const PORT = process.env.PORT || 3065;
//지정 포트 실행, 서버실행
app.listen(PORT,()=>{
    console.log(`✅서버실행! http://localhost:${PORT}`);
});