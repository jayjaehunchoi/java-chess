# java-chess
## 1단계 - 체스판 초기화

- [x] 체스판을 만든다
  - [x] 칸을 만든다
  - [x] 말을 만든다
  - [x] 초기 세팅한다
  
## 2단계 - 말 이동

- [ ] command 입력 규칙을 지키지 않았을 때 에러 발생


- ChessGame - 말 이동 기능
- [x] Position 생성
  - [x] 범위를 초과하는 Column, Row 받을 시 에러 발생

  
- [ ] Game
  - [x] source가 빈칸이면 에러 발생
  - [ ] piece의 이동 전략에게 이동을 묻는다.
  - [ ] piece를 이동시킨다.

- [ ] Piece
  - [ ] 각 피스별 이동 전략
  - [ ] 빈칸, 폰인지 확인
  
- [ ] 이동 전략
  - [ ] target이 같은 색이면 이동 불가
  - [ ] 폰일 경우 target 위치 확인 후 불가능하면 이동불가

# 페어 체크리스트

### 설계를 하고 프로그래밍 시작 하기
- [ ] 기능목록 작성
  - [ ] 도메인 학습
  - [ ] 책임을 분리하기
  - [ ] 역할 구분 


- [ ] 코드를 작성할 때 어떻게 작성할지 이야기 후 코드 작성 시작
  - [ ] 이름
  - [ ] 구현 방식


- [ ] 코드 작성


- [ ] 코드에 대해 회고하기
  - [ ] 리팩터링 여부
  - [ ] 불편한 점 최대한 개선하고 넘어가기



## 질문거리
- 빈칸을 piece를 상속받아 관리하려 합니다. 그로인해 color enum에 무색이 추가될것 같아요 이런 접근법에 대해 어떻게 생각하는지
- 테스트용 보드를 초기화할 방법