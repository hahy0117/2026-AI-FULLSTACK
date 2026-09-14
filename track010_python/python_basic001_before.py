# ==============================================================================
# 00. 설치 및 환경 설정 가이드 (터미널에서 먼저 실행)
# ==============================================================================
# 0) python.org
# vs code: Extensions - python Extension Pack / Python Ident
# 1) 파이썬 설치 확인: python --version
# 2) 가상환경 생성: python -m venv venv
# 3) 가상환경 활성화:
#    - Windows (CMD): venv\Scripts\activate
#    이거 사용 - Windows (PowerShell): .\venv\Scripts\Activate.ps1
#    - Windows (Git Bash) / Mac / Linux: source venv/Scripts/activate (Mac은 venv/bin/activate)
#    * 활성화 성공 시 터미널 왼쪽에 (venv) 가 표시됩니다.
# 4) 필수 패키지 설치: pip install numpy pandas
# ==============================================================================

# ==============================================================================
# [1교시] Python 핵심 (Java/JS 문법 비교 및 핵심 문법)
# ==============================================================================
# 1) ; 사용하지 않고
# 2) {} 사용하지 않고 들여쓰기로 코드블록 구분
# 3) 타입선언 명시하지 않음 (int /String )

print("\n\n--- [1] Python 핵심 ---")

print("\n--- 0. 변수 선언 및 출력 ---")
### int,String /const ,let ,var 키워드 필요 하지 않다 -자바에서 사용
## 변수명=값 (js 의 true /python True, False)
age=10
name="파이썬"
is_active=True
print(f"이름: {name},나이:{age},활성화:{is_active}")

#Q1. day라는 변수 만들어서 "금요일" 넣고
#Q2.f-String 이용해서 오늘은 금요일 출력

day="금요일"
print(f"오늘은{day}")

print("\n--- 1. 제어문 (if) ---")
### 실습
#2.else if -> elif
### if(조건){} ()생략가능
# if 조건:
# 들여쓰기가 맞아야 블록인식
if age>=20 : 
    print(f"{name}은 성인")
else:
    print(f"{name}은 미성년자")

print("\n--- 2. 반복문 (for i in range) ---")
# java : for(int i=1; i<4; i++){}
#python: for i in range(1,4): 어디서부터 어디전까지
for i in range (1,4):
    print(f"카운트:{i}")
    


    


print("\n--- 3. 리스트(List) ---")
### 
fruits=["apple","banana","coconut"]

print(f"과일리스트:{fruits}")
for i in fruits :
    print(i)

fruits.append("orange") # js push() ,Java add()
print(f"orange 추가 후 과일리스트:{fruits}")
print(f"index의 0번쨰 과일 :{fruits[0]}")
print(f"index의 -1번쨰 과일 :{fruits[-1]}") # -1은 맨뒤에 있는 요소

print("\n--- 4. 딕셔너리(Dictionary) ---")
### Java 'HashMap' key-value 구조
# json 형태로 데이터 가공 
user_info={"name":"홍길동","role":"admin","level":5}
user_info["level"] += 1 # 기존의 Key의 value 수정/ 없으면 새로 key-value 추가

print(f"딕셔너리{user_info}")
print(f"역할:{user_info['role']},레벨:{user_info['level']}")


print("\n--- 5. 컴프리헨션(Comprehension) ---")
### Java 람다식 .filter().map() ----
## 짝수 찾아서 짝수의 제곱
numbers=[1,2,3,4,5,6,7,8,9,10]
es =[i**2 for i in numbers if i%2==0 ]
##            1) for           2)if 짝수 고르기  3) 제곱  4) 리스트
print(f"짝수 찾아서 제곱 : {es}")

## 예시 2)
categories=["커뮤니티","커머스","콘텐츠"]
cs = { i:0 for i in categories }
# 3) {} 2) 결과물을 0으로 셋팅 1) for 이용해서 하나씩 key
print(f"딕셔너리의 초기값들을 다 0으로 셋팅 : {cs}")

# ------------------------------------------------------------------------------
# ✏️ [연습문제 01 - Python 기초 및 컴프리헨션]
# ------------------------------------------------------------------------------
# Q1. scores 리스트에서 60점 이상인 점수만 10점씩 가산한 `passed_scores` 리스트를 만드세요.
# Q2. members 리스트의 각 이름을 Key로, "OFFLINE"을 Value로 갖는 `status_dict` 딕셔너리를 만드세요.
#
# 🎯 [목표 출력 결과]
# Q1 결과: [85, 98, 105, 70]
# Q2 결과: {'kim': 'OFFLINE', 'lee': 'OFFLINE', 'park': 'OFFLINE'}

scores = [45, 75, 88, 52, 95, 60]
members = ["kim", "lee", "park"]

# --- [작성 공간] ---
# for+if 60점 이상인 점수만 처리:10점씩 결과:리스트
# TODO: 아래 변수들의 코드를 직접 완성해 보세요!

passed_scores = [i+10 for i in scores if i>= 60]
# for members ,처리: "OFFLINE"을 Value 결과:딕셔너리
status_dict = {i: "OFFLINE" for i in members}



# --- [출력 확인 공간] ---
print("\n--- [연습문제 01 결과 확인] ---")
print("Q1 결과:", passed_scores)
print("Q2 결과:", status_dict)


# ==============================================================================
# [2교시] NumPy 기초: 수치 데이터 및 배열 다루기
# ==============================================================================

print("\n\n--- [2] NumPy 기초 ---")

import numpy as np
# np.array([]) : 기존 파이썬 리스트를 NumPy 배열로 변환
# np.zeros(shape) : 지정 크기 만큼 0으로 채워진 배열
# np.arrange(start,end) : start 부터 end 전까지 연속된 배열 

print("\n--- 1. 1차원 및 2차원 배열(NDArray) 생성 ---")
### 1.배열
arr1= np.array([10,20,30,40,50])
print(f"1차원 배열: {arr1}")
print(f"Array Shape :{arr1.shape}")

arr2 = np.array([
    [1, 2, 3],
    [4, 5, 6]
])
print(f"2차원 배열 :{arr2}")
print(f" Array Shape:{arr2.shape}")

arr3 = np.array([
    [[1, 2, 3], [4, 5, 6]],
    [[7, 8, 9], [10, 11, 12]]
])
print(f"3차원 배열{arr3}")
print(f"Array Shape:{arr3.shape}")

## 3행2열 [방문자수,매출액] 형태
data_2d=np.array([
    [150,10000],
    [300,50000],
    [500,60000]
])

print(f"방문매출 2d배열 : {data_2d}")
print(f"Array Shape:{data_2d.shape}")

zero_arr = np.zeros((2,3)) # 2층 3칸  0으로 채워진 공간




print("\n--- 2. 인덱싱 및 슬라이싱 [행, 열] ---")
### 실습


print("\n--- 3. 조건부 추출 (Boolean Indexing) ---")
### 실습
visitors =data_2d [:, 0] # 방문자 수 컬럼만 추출
print(f"방문자수 추출 : {visitors}")
sales=None # 여기작성 
print(f"매출액 추출: {sales}")

print(data_2d[0])
print(data_2d[0:1])
print(data_2d[0:2])


print("\n--- 4. 수치 통계 연산 및 Axis(축) 연산 ---")
### 통계함수: 평균-mean, 합계-sum, 최댓값-max,표준편차-std
sales = data_2d[:, 1]  # 매출액 데이터만 뽑아서 sales 변수에 저장
print("방문자수 평균 :",np.mean(visitors))
print("총 매출액 합계:",np.sum(sales))
print("방문자수 최대:",np.max(visitors))    
print("매출액 표준편차:",np.std(sales))

col_sums=np.sum(data_2d,axis=0)
print(f"Axios=0 세로 방향(열방향) 합계 :{col_sums}")

# ------------------------------------------------------------------------------
# ✏️ [연습문제 02 - NumPy 다차원 배열 연산]
# ------------------------------------------------------------------------------
# store_data는 4개 매장의 [주문 건수, 총 결제 금액] 데이터입니다.
# Q1. 주문 건수(0번 열)가 30건 이상인 매장의 데이터만 추출하여 `over_30_stores`에 저장하세요.
# Q2. 전체 매장의 총 결제 금액(1번 열) 합계(`total_pay`)와 주문 건수(0번 열)의 평균(`avg_orders`)을 구하세요.
#

# 🎯 [목표 출력 결과]
# Q1 결과 (주문 30건 이상 매장):
# [[    40 120000]
#  [    85 250000]
#  [    50 180000]]
# Q2 결과 -> 총 결제 금액: 585000원, 평균 주문 건수: 47.5건
import numpy as np

# 4개 매장의 [주문 건수, 총 결제 금액] 데이터
store_data = np.array([
    [15, 35000],
    [40, 120000],
    [85, 250000],
    [50, 180000]
])

#주문 건수(0번 열)가 30건 이상인 매장의 데이터 추출
over_30_stores = store_data[store_data[:, 0] >= 30]

#전체 매장의 총 결제 금액(1번 열) 합계와 주문 건수(0번 열)평균 구하기
total_pay = store_data[:, 1].sum()
avg_orders = store_data[:, 0].mean()

# 결과 출력
print("(주문 30건 이상 매장):")
print(over_30_stores)
print(f"총 결제 금액: {total_pay:,}원, 평균 주문 건수: {avg_orders}건")



# --- [작성 공간] ---
# --- [작성 공간] ---
# 매출액이 30000넘었니? [False,True,True]
# sql:where sales >= 30000
#Q [행,열] 이용해서 매출액만 추출
sales_30000=data_2d[:,1] >= 30000
print(f"매출액 30000 이상 필터링 :{sales_30000}")
print(f"필터링된 실재데이터:{data_2d[sales_30000]}")

# 방문자수가 300 이상인 매장 필터링
over_30_stores = data_2d[data_2d[:, 0] >= 300]

# 전체 매출액(1번 열)의 합계
total_pay = data_2d[:, 1].sum()

# 평균 방문자수(0번 열) 평균
avg_orders = data_2d[:, 0].mean()



# --- [출력 확인 공간] ---
print("\n--- [연습문제 02 결과 확인] ---")
print("Q1 결과 (주문 30건 이상 매장):\n", over_30_stores)
print(f"Q2 결과 -> 총 결제 금액: {total_pay}원, 평균 주문 건수: {avg_orders}건")


# ==============================================================================
# [3~4교시] Pandas 데이터 정제 & 실전 집계 (EDA)
# ==============================================================================
# Pandas -엑셀 (Excel) 이나 관계형 데이터베이스(Rdb)의 테이블 형태
#핵심객체
# 1) Series: 1차원 데이터 (1개의 컬럼)
# DataFrame:2차원데이터(행과 열로 구성된 표형태)
print("\n\n--- [3] Pandas 데이터 정제 & 실전 집계 ---")

import pandas as pd

print("\n--- 1. 샘플 데이터 생성 및 DataFrame 변환 ---")
### 실습


print("\n--- 2. 데이터 탐색 메서드 (head, info, describe) ---")
### 실습


print("\n--- 3. 조건 조회 (Boolean Filtering) 및 파생 컬럼 생성 ---")
### 실습


print("\n--- 4. 핵심 그룹화 연산 (groupby) ---")
### 실습


print("\n--- 5. 분석 결과를 파이썬 리스트로 추출 ---")
### 실습


# ------------------------------------------------------------------------------
# ✏️ [연습문제 03 - Pandas 필터링, 컬럼 생성 및 Groupby]
# ------------------------------------------------------------------------------
# Q1. log_df에서 status_code가 200인 행만 추출해 `success_df`를 만드세요.
# Q2. log_df에 response_time_ms를 1000으로 나눈 `response_time_sec` 컬럼을 추가하세요.
# Q3. server별 response_time_ms의 평균을 구해 `server_summary` DataFrame을 만들고, 
#     서버 이름 목록을 `server_list` 파이썬 리스트로 추출하세요.
#
# 🎯 [목표 출력 결과]
# Q1 결과 (정상 응답):
#      server  status_code  response_time_ms
# 0  Server_A          200               120
# 2  Server_A          200               150
# 3  Server_B          200               200
#
# Q3 결과 (서버별 평균 응답시간 집계):
#      server  response_time_ms
# 0  Server_A        116.666667
# 1  Server_B        325.000000
# Q3 리스트 변환 결과: ['Server_A', 'Server_B']

log_data = [
    {'server': 'Server_A', 'status_code': 200, 'response_time_ms': 120},
    {'server': 'Server_B', 'status_code': 500, 'response_time_ms': 450},
    {'server': 'Server_A', 'status_code': 200, 'response_time_ms': 150},
    {'server': 'Server_B', 'status_code': 200, 'response_time_ms': 200},
    {'server': 'Server_A', 'status_code': 404, 'response_time_ms': 80},
]

log_df = pd.DataFrame(log_data)

# --- [작성 공간] ---
# TODO: 아래 코드들을 직접 작성해 보세요!
success_df = None

# TODO: log_df에 'response_time_sec' 컬럼을 생성하는 코드를 작성하세요.

server_summary = None
server_list = None


# --- [출력 확인 공간] ---
print("\n--- [연습문제 03 결과 확인] ---")
print("Q1 결과 (정상 응답):\n", success_df)
print("\nQ3 결과 (서버별 평균 응답시간 집계):\n", server_summary)
print("Q3 리스트 변환 결과:", server_list)