![image](https://user-images.githubusercontent.com/81465068/219571225-27face3f-67dd-4264-85a6-de09b521e7f5.png)

# 우테코 5기 1레벨 2~3주차 - 사다리타기 미션&List 구현하기 미니 미션

![Generic badge](https://img.shields.io/badge/level1-week2~3-green.svg)
![Generic badge](https://img.shields.io/badge/test-27_passed-blue.svg)
![Generic badge](https://img.shields.io/badge/version-1.0.1-brightgreen.svg)

> 우아한테크코스 5기 1레벨 2~3주차 미션, 사다리타기 미션과 List 구현하기 미니 미션을 구현한 저장소입니다.

![image](https://user-images.githubusercontent.com/81465068/221404888-3211bf2c-977f-4bf8-8f11-e6f7065c9479.png)

![image](https://user-images.githubusercontent.com/81465068/221404911-daaf0d38-a1c3-430c-89be-2570864cbfc6.png)


# 목차
- [시작하기](#시작하기)
- [기능 목록](#기능-목록)
  - [입력](#입력)
  - [로직](#로직)
  - [출력](#출력)


## 시작하기
해당 레포지토리를 Clone하고 IDE에서 src/main/java에 위치한 Application.java 파일을 실행시켜 프로그램을 동작시킬 수 있습니다.
```
git clone -b as https://github.com/amaran-th/java-ladder.git
```

## 기능 목록
### 입력
- 이름들을 입력받는다.
- 실행 결과를 입력받는다.
    - 실행결과의 개수가 참여할 사람과 동일하지 않을 경우 예외처리 한다.
        - 에러 메세지에 입력받은 개수도 포함시킨다.
    - 입력받은 각 실행결과가 5글자를 초과할 경우 예외처리한다.
- 결과를 보고 싶은 사람을 입력받는다.(반복적으로)

### 로직
- 이름은 5글자 까지만 가능하다
    - 예외 6글자부터 예외
- 이름은 쉼표를 기준으로 구분한다
- 라인을 생성할 때, 겹치면 안된다
- 플레이어 이름 정보와 실행 결과 이름 정보의 구조가 거의 동일하므로 Names를 부모 클래스로 만들고 자식클래스로 PlayerNames와 RewardNames를 만든다.
- 모든 사람에 대한 실행 결과를 계산하는 로직을 구현한다.
    - 테스트 코드는 모든 connection이 true인 사다리와 false인 사다리 두가지 경우에 대해 구현한다.

### 출력
- 사다리는 '-' 5개로 출력한다
- 사다리 끝에 순서대로 입력받은 실행결과들을 출력한다.
- 참여할 사람에 대한 실행결과를 출력한다.
- 모든 사람에 대한 실행결과를 출력한다.
