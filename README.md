# 🚀 하혜원 | Backend & Full-Stack Developer

> **데이터와 요청의 흐름을 따라 문제를 해결하는 개발자입니다.**

Java와 Spring Boot를 기반으로 REST API와 서비스 로직을 구현하고,
JPA와 MyBatis를 활용한 데이터 처리 및 React와의 API 연동을 경험했습니다.

단순히 기능을 구현하는 것에 그치지 않고,
오류가 발생했을 때 로그와 코드의 흐름을 따라가며 원인을 찾고
팀원들과 의견을 조율하며 기능을 완성하는 과정을 중요하게 생각합니다.

---

## 📌 About Me

|            |                                                 |
| ---------- | ----------------------------------------------- |
| **Name**   | 하혜원                                             |
| **Major**  | Computer Science                                |
| **Email**  | [hahy0117@gmail.com](mailto:hahy0117@gmail.com) |
| **GitHub** | https://github.com/hahy0117                     |

---

## 🛠️ Tech Stack

### Backend

`Java` `Spring` `Spring Boot` `Spring Security` `JPA` `MyBatis`

### Frontend

`React` `JavaScript` `HTML` `CSS` `Thymeleaf`

### Database

`Oracle` `MySQL`

### DevOps

`AWS EC2` `Linux` `Nginx` `GitHub Actions`

### Tools

`Git` `GitHub` `Swagger`

---

## 💻 Project

### MOIT | 모임 기반 커뮤니티 서비스

> 모임을 생성하고 참여하며, 모임 종료 후 후기를 통해 경험을 공유할 수 있는 서비스

**Tech Stack**

`Java` `Spring Boot 3` `JPA` `MyBatis` `Oracle` `React`

### 🙋 담당 기능 | 후기 관리

* 후기 등록·조회·수정·삭제 기능 구현
* 모임 종료 여부 및 중복 작성 여부 검증
* 후기 다중 이미지 등록·수정·삭제 기능 구현
* 후기 이미지 확대 기능 구현
* 후기 상세 조회 및 조회수 기능 구현
* 후기 좋아요 등록·삭제 기능 구현
* 후기 댓글·대댓글 기능 구현
* 후기 검색 및 정렬 기능 구현
* 모임 종료 후 후기 작성 알림 자동화
* 관리자 후기 조회 및 상태 관리 기능 구현
* AI 기반 후기 요약 및 인사이트 기능 구현

### 🔍 Problem Solving

**후기 작성 조건 검증**

모임이 종료된 경우에만 후기를 작성할 수 있도록 모임 상태를 확인하고,
동일한 모임에 대한 중복 후기 작성이 발생하지 않도록 작성 여부를 검증했습니다.

**연관 데이터 조회 개선**

후기 조회 과정에서 회원, 모임, 댓글 등 연관 데이터를 함께 다루면서
필요한 데이터만 조회할 수 있도록 `FetchType.LAZY`와 `@EntityGraph`를 활용했습니다.

**이미지 관리**

후기 하나에 여러 이미지를 등록할 수 있도록 구성하고,
수정 및 삭제 과정에서 기존 이미지와 새 이미지를 함께 관리할 수 있도록 구현했습니다.

**API 연동**

백엔드 API를 Swagger를 통해 먼저 확인하고 테스트한 뒤
React와 연결하여 실제 화면에서 데이터를 주고받을 수 있도록 구현했습니다.

---

## 🔐 Authentication & Authorization

### Spring Security & JWT

* JWT 기반 Access Token / Refresh Token 인증 구현
* 커스텀 인증 필터를 통한 요청별 토큰 검증
* `SecurityContext`를 활용한 인증 사용자 정보 관리
* 사용자 권한에 따른 접근 제어 구현

---

## ☁️ Deployment

### AWS EC2 기반 서비스 배포

* AWS EC2 서버 환경 구성
* Linux 환경에서 애플리케이션 운영
* Nginx를 활용한 웹 서버 구성
* GitHub Actions를 활용한 CI/CD 환경 구성
* 배포 환경에서 발생한 프론트엔드와 백엔드 연결 문제 확인 및 수정

---

## 📚 Development Approach

### 데이터와 요청의 흐름을 따라 문제를 해결합니다.

오류가 발생했을 때 바로 코드를 수정하기보다
로그와 Stack Trace를 확인하고 관련 코드의 흐름을 따라가며 원인을 좁혀갑니다.

특히 프론트엔드의 요청이 백엔드 API를 거쳐
서비스 로직과 데이터베이스까지 어떻게 전달되는지 확인하며 문제를 해결하려고 합니다.

### 새로운 기술은 직접 사용하며 익힙니다.

익숙하지 않은 기술을 접했을 때 작은 기능부터 직접 적용하고,
실행 결과를 확인하면서 동작 원리를 이해하는 과정을 반복합니다.

### 협업에서는 의견을 조율합니다.

팀원과 의견이 다를 때 한 가지 방법을 고집하기보다
각 방법의 장단점과 현재 구현 상황, 일정 등을 함께 고려하여
프로젝트에 적합한 방향을 찾으려고 합니다.

---

## 🌱 Growth

**Java**

→ 객체지향 프로그래밍과 웹 개발 기본기 학습

**Spring Boot**

→ REST API 및 서비스 로직 구현 경험

**JPA / MyBatis**

→ Entity 기반 데이터 처리 및 SQL 매핑 경험

**React**

→ 컴포넌트 기반 UI 구현 및 백엔드 API 연동 경험

**AWS / GitHub Actions**

→ 서버 배포 및 CI/CD 환경 구성 경험

**프로젝트**

→ 기능 구현을 넘어 문제 해결과 협업 경험 확장

---

## 🎯 Future Goals

* Java / Spring Boot 기반 백엔드 개발 역량 강화
* JPA 및 데이터 조회 구조에 대한 이해 확장
* React와 백엔드 API 연동 경험 강화
* AWS 기반 배포 및 CI/CD 경험 확장
* AI 기능을 실제 서비스에 적용하는 경험 확대

---

## 📫 Contact

**Email**
[hahy0117@gmail.com](mailto:hahy0117@gmail.com)

**GitHub**
https://github.com/hahy0117
