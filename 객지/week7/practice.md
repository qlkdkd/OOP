# 실습 문제-정보은닉과 캡슐화
은행계좌를 나타내는 Account 클래스를 코틀린으로 만들어보자
1. Account 클래스는 잔액을 나타내는 balance 필드와 계좌번호를 나타내는 id필드를 가진다.
    * balance와 id 필드는 외부에서 읽을 수는 있지만 변경되지 못하도록 설정
2. Account 클래스는 다음 2개의 메소드를 가진다.
    1. withdraw(amount: Int):Unit
        * balance에서 amount만큼의 돈을 차감
    2. deposit(amount: Int): Unit
        * balance에 amount만큼의 돈을 추가
    3. Account 클래스에 적절한 생성자를 정의하시오

다음 시나리오 조건을 만족하는 테스트 프로그램을 작성하시오.
1. Account 객체를 2개 이상 생성하여 돈을 입금하고 인출하는 시나리오를 구현합니다.
2. 돈을 입금하거나 인출한 후에 계좌번호와 잔액을 출력하시오.

## 코드 보기
* [class](https://github.com/qlkdkd/OOP/blob/main/%EA%B0%9D%EC%A7%80/week7/week7_practice/src/main/kotlin/Account.kt)
* [main](https://github.com/qlkdkd/OOP/blob/main/%EA%B0%9D%EC%A7%80/week7/week7_practice/src/main/kotlin/Main.kt)
