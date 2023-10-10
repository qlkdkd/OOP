fun main(){
    val account1=Account()
    Thread.sleep(100)//account1.id와 account2.id 를 다르게 출력하기 위해 100초간 차이를 내준다.
    val account2=Account(1000)
    println("${account1.id}계좌의 잔액은 ${account1.balance}원 입니다.")
    println("${account2.id}계좌의 잔액은 ${account2.balance}원 입니다.")

    account1.deposit(2000)
    //account1.id="aaaa"
    //account1.balance=1000

    account2.withdraw(100)
}