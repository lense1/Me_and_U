# 🌟 Me_and_U

> **버킷리스트를 함께 완성하는 커뮤니티 플랫폼**
> 
> 나만의 버킷리스트를 관리하고, 다른 사람들과 꿈을 공유하며, 함께할 모임까지 찾을 수 있는 소셜 버킷리스트 서비스입니다.

---

## 📌 프로젝트 개요

| 항목 | 내용 |
|------|------|
| 프로젝트명 | Me_and_U |
| 개발 기간 | 2026.05 |
| 배포 링크 | 없음 |
| 패키징 | WAR (Tomcat 배포) |

---

## 🛠 기술 스택

### Backend
- **Java 11**
- **Spring Boot 2.7.7** (MVC, Security, JDBC, DevTools)
- **MyBatis 2.3.0** — SQL 매핑
- **MySQL** — 메인 데이터베이스

### Frontend
- **JSP / JSTL** — 서버사이드 렌더링
- **Summernote** — 리치 텍스트 에디터 (공지사항, FAQ 작성)
- **HTML / CSS / JavaScript**

### 외부 API
- **Naver Clova Chatbot API** — AI 챗봇
- **Naver CLOVA Speech (STT)** — 음성 → 텍스트
- **Naver TTS** — 텍스트 → 음성
- **Daum 주소 API** — 주소 검색 (모임 등록 시)
- **javax.mail** — 이메일 인증 (아이디 찾기 / 비밀번호 재설정)

---

## 📁 프로젝트 구조

```
src/main/
├── java/com/Me_and_U/project/
│   ├── controller/          # 요청 처리 컨트롤러
│   │   ├── BucketListController.java
│   │   ├── LoginController.java
│   │   ├── RegisterController.java
│   │   ├── ReviewController.java
│   │   ├── FaqController.java
│   │   ├── QnaController.java
│   │   ├── NoticeController.java
│   │   ├── ChatbotController.java
│   │   ├── MypageController.java
│   │   └── AdminController.java
│   ├── service/             # 비즈니스 로직
│   ├── dao/                 # MyBatis 인터페이스
│   ├── model/               # VO (Value Object)
│   │   ├── MemberVO.java
│   │   ├── ComBKListVO.java     # 모두의 버킷리스트
│   │   ├── MyBKListVO.java      # 나의 버킷리스트
│   │   ├── RegGatherVO.java     # 정기모임
│   │   ├── ReviewVO.java
│   │   ├── FaqVO.java
│   │   ├── QnaVO.java
│   │   └── NoticeVO.java
│   ├── WebSecurityConfiguration.java   # Spring Security 설정
│   └── EmailAutoConfiguration.java     # 이메일 설정
├── resources/
│   ├── mappers/             # MyBatis XML SQL 매퍼
│   │   ├── bucketList/BKListMapper.xml
│   │   ├── gather/regGatherMapper.xml
│   │   ├── member/MemberMapper.xml
│   │   ├── review/ReviewMapper.xml
│   │   └── cscenter/ (Faq, Notice, Qna)
│   ├── been/MailAuthBean.xml
│   └── application.properties
└── webapp/WEB-INF/views/
    ├── index.jsp            # 메인 페이지
    ├── layout/              # 공통 레이아웃 (head, top, bottom)
    ├── jsp/bucketlist_com/  # 모두의 버킷리스트
    ├── jsp/bucketlist_my/   # 나의 버킷리스트
    ├── jsp/cscenter/        # CS센터 (FAQ, 공지, QnA)
    ├── jsp/memManagement/   # 회원 관리
    ├── jsp/review/          # 리뷰
    └── jsp/                 # 모임, 마이페이지, 챗봇 등
```

---

## ✨ 주요 기능

### 1. 👤 회원 관리
- 회원가입 / 로그인 / 로그아웃
- 아이디 중복 체크
- **아이디 찾기** — 이름 + 이메일 인증
- **비밀번호 재설정** — 이메일 인증 후 변경
- 마이페이지 — 개인정보 조회 및 수정 (이름, 연락처, 주소, 관심분야)
- Spring Security 기반 인증/인가

### 2. 📝 나의 버킷리스트
- 개인 버킷리스트 직접 등록 / 삭제
- 버킷리스트 **완료 체크** (토글 줄긋기)
- **모두의 버킷리스트**에서 항목 담아오기 (중복 체크 포함)

### 3. 🌍 모두의 버킷리스트
- 버킷리스트 게시글 등록 (제목, 부제목, 내용, 이미지 업로드)
- 목록 조회 — **페이징** (페이지당 8개)
- **정렬** — 최신순 / 조회순 / 이름순
- **검색** — 제목 / 부제목 / 내용 키워드 검색
- 상세 페이지 — 조회수 자동 증가, 작성자에게만 삭제 버튼 표시
- 나의 버킷리스트로 담기

### 4. 🤝 정기 모임
- 모임 개설 — 제목, 설명, 지역(대분류/소분류), 카테고리, 시작/종료일, 최대 정원, 대표 이미지
- 모임 목록 조회 / 상세 페이지
- Daum 주소 API 연동으로 지역 검색

### 5. ⭐ 리뷰
- 리뷰 등록 / 수정 / 삭제
- 리뷰 목록 / 검색 결과 보기
- 마이페이지에서 내 리뷰 관리

### 6. 📞 CS 센터
| 기능 | 설명 |
|------|------|
| **FAQ** | 자주 묻는 질문 목록 / 상세 / 관리자 등록·수정·삭제 |
| **공지사항** | 공지 목록 / 상세 / 관리자 등록·수정·삭제 |
| **QnA** | 사용자 문의 작성 / 목록 / 상세 / 수정·삭제 |
| **문의 목록** | 관리자 전체 문의 현황 관리 |

### 7. 🤖 AI 챗봇
- **Naver Clova Chatbot** 연동 — 텍스트 대화
- **STT (음성 → 텍스트)** — Naver CLOVA Speech 연동
- **TTS (텍스트 → 음성)** — Naver TTS 연동

### 8. 🔧 관리자 페이지
- 회원 및 콘텐츠 관리
- CS 센터 FAQ / 공지사항 직접 등록·수정·삭제

---

## 🗄 주요 DB 테이블

| 테이블명 | 설명 |
|----------|------|
| `member` | 회원 정보 (ID, PW, 이름, 이메일, 전화번호, 주소, 관심분야 등) |
| `mybklist` | 나의 버킷리스트 (회원별 개인 목록) |
| `combklist` | 모두의 버킷리스트 (공개 게시글) |
| `mycombklist` | 모두의 버킷리스트 → 나의 버킷리스트 담기 |
| `reggather` | 정기모임 정보 |
| `review` | 리뷰 |
| `faq` | FAQ |
| `notice` | 공지사항 |
| `qna` | QnA 문의 |

---

## ⚙️ 로컬 실행 방법

### 사전 요구사항
- Java 11
- MySQL 8.x
- Maven

### 1. DB 설정
```sql
CREATE DATABASE me_and_u DEFAULT CHARACTER SET utf8mb4;
```

### 2. application.properties 설정
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/me_and_u?serverTimezone=Asia/Seoul
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3. 이미지 업로드 경로 생성
```
C:/springWorkspace/me_and_u_images/
```
> `BucketListController.java`, `RegisterController.java` 내 `uploadPath` 하드코딩 경로 — 필요 시 수정

### 4. 외부 API 키 설정
> `ChatbotService.java`, `STTService.java` 내 주석 처리된 `apiURL`, `secretKey`, `clientId`, `clientSecret` 값을 실제 키로 교체

### 5. 빌드 및 실행
```bash
./mvnw spring-boot:run
```

---

## 📝 개발 시 참고 사항

- 이미지 업로드 경로(`C:/springWorkspace/me_and_u_images/`)가 하드코딩되어 있으므로 **배포 환경에 맞게 수정 필요**
- 챗봇/STT/TTS API 키는 소스 코드에서 **주석 처리** 되어 있음 — 배포 전 별도 환경변수로 분리 권장
- Spring Security 설정(`WebSecurityConfiguration.java`)에서 접근 권한 URL 패턴 관리

---

## 👨‍💻 팀 프로젝트

Spring Boot + JSP + MyBatis 기반의 팀 웹 개발 프로젝트입니다.
