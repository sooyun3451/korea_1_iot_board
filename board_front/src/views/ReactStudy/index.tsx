import React from 'react'

import UseState from './../../react-study/A_useState';
import UseEffect from './../../react-study/B_useEffect';
import StateEffect from './../../react-study/C_StateEffect';
import StatePractice from './../../react-study/C_StateEffectPractice';
import PostPractice from './../../react-study/C_StateEffectPostPractice';

export default function ReactStudy() {
  return (
    <>
      <h2>UseState: 상태관리</h2>
      <UseState />
      <hr style={{marginTop: "20px"}}/>

      <h2>UseEffect: 부수효과</h2>
      <UseEffect />
      <hr style={{marginTop: "20px"}}/>
      
      <h2>State & Effect: Menu 검색 구현</h2>
      <StateEffect />
      <hr style={{marginTop: "20px"}}/>
      
      <h2>Menu 검색 구현 연습</h2>
      <StatePractice />
      <hr style={{marginTop: "20px"}}/>

      <h2>Menu Post 연습</h2>
      <PostPractice />
      <hr style={{marginTop: "20px"}}/>
    </>
  )
}
