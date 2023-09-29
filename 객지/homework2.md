## 실습과제
1. 은행 계좌를 나타내는 Account 클래스를 코트린으로 만들어 보자.
  * Account 클래스는 잔액을 나타내는 balance 필드와 계좌번호를 나타내는 id 필드를 가진다.
  * Account 클래스는 다음 두 개의 메소드를 가진다.
    * withdraw (amount:Int):Unit
      * balance에서 amount 만큼의 돈을 차감
    * deposit (amount:Int):Unit
      * balance에 amount 만큼의 돈을 추가
  * Account 클래스에 적절한 생성자를 정의하시오.
2. 다음 시나리오 조건을 만족하는 테스트 프로그램을 작성하시오
  * Account 객체를 2개 이상 생성하여서 돈을 입금하고 인출하는 시나리오를 구현합니다.
