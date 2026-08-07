import { configureStore} from  '@reduxjs/toolkit';  
import  createSagaMiddleware from 'redux-saga';     
import { createWrapper } from 'next-redux-wrapper'; 
import reducer  from '../reducers';                 
import rootSaga from '../sagas';                 

export const  makeStore = ()=> {
   const sagaMiddleware =  createSagaMiddleware();   
   const store = configureStore({
    reducer,                            
    middleware: (getDefaultMiddleware) =>  
      getDefaultMiddleware({ 
        thunk: false,                  // thunk (비동기 처리) 비활성화 (sage 사용)    
        serializableCheck: false,      //직렬화 검사 비활성화 (sage 처리)
      }).concat(sagaMiddleware),      
    devTools: process.env.NODE_ENV !== 'production',   
  });
  
   store.sagaTask = sagaMiddleware.run(rootSaga); //sage 실행
   return store;
};

export  const wrapper = createWrapper(  makeStore , {
    debug: process.env.NODE_ENV !== 'production'    
} );
