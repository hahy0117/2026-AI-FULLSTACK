import React from 'react';
import { wrapper } from '../store/configureStore'; // 치킨집(전역상태+서버연동)
import AppLayout from '../components/AppLayout'; // 공통레이아웃
import 'antd/dist/antd.css'; // ant 디자인
import '../styles/global.css'; // 전역 css 
//부품
function MyApp({ Component,pageProps}) { // 부품,초기 설정값
  return (
    <AppLayout initialUser={pageProps.user}>
      <Component{...pageProps}  />
    </AppLayout>
  );
}
//export
export default wrapper.withRedux(MyApp); //스토어 전역사용
