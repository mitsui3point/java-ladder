# 사다리 게임

## 프로젝트 개요

스트림, 람다, Optional 등 함수형 프로그래밍 학습을 위한 실습

## 요구사항

### 람다

1. 익명 클래스를 람다로 전환
2. 람다를 활용해 중복 제거
    - 인터페이스에 대한 구현체를 익명 클래스로 구현해 메소드의 인자로 전달

### 스트림(stream)

- map, reduce, filter

### Optional

1. Optional을 활용해 조건에 따른 반환
2. Optional에서 값을 반환
3. Optional에서 exception 처리

### 사다리 게임
- 사람
  - 이름 5글자 이상 불가
- 라인
  - 연속된 가로 라인 불가
- 사다리 게임
  - 쉼표(,)로 구분된 이름으로 사람들 생성
  - 라인 생성 전략에 따라 사다리 생성
- 라인 생성 전략
  - 랜덤 boolean 값을 생성
  - 이전 boolean 값이 true이고 현재 boolean 값이 true인 경우, 현재 boolean 값을 false로 변경 
- 입/출력
  - 참여자들의 이름을 입력
  - 실행 결과 입력
  - 최대 사다리 높이 개수를 입력
  - 사다리 결과 출력
    - 사람 이름
    - 사다리 라인
    - 실행 결과
  - 결과 보고 싶은 사람 입력
    - 개인별 이름 입력시 개인별 결과 출력
    - "all" 입력시 전체 참여자의 실행 결과 출력