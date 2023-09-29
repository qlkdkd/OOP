package HomeWork2

class Account(var id: Int, var balance: Int){

    //입금
    fun deposit(amount: Int){
        if(amount>0){
            balance+=amount
            println("$amount 원 입금되었습니다.\n현재 잔액: $balance 원")
        }
        else println("입금 금액은 0원 이상이여야 합니다.")
    }

    //인출
    fun withdraw(amount: Int){
        if(amount>0 && amount <=balance){
            balance-=amount
            println("$amount 원 인출되었습니다.\n 현재 잔액: $balance 원")
        }
        else println("잔액이 부족합니다!\n현재 잔액: $balance 원")
    }


}

fun main(){
    println("계좌번호를 입력하세요: ")
    val myId=readln().toInt()

    println("초기 잔액을 입력하세요: ")
    val myBalance=readln().toInt()

    //입력받은 정보로 계좌 생성
    val myAccount=Account(myId, myBalance)

    //기능 선택
    while(true){
        println("\n1. 입금")
        println("2. 인출")
        println("3. 종료")
        when(readln().toIntOrNull()?:0){
            1->{
                println("입금할 금액을 입력하세요: ")
                val amount=readln().toInt()
                myAccount.deposit(amount)
            }
            2->{
                println("인출할 금액을 입력하세요: ")
                val amount=readln().toInt()
                myAccount.withdraw(amount)
            }
            3->{
                println("프로그램을 종료합니다.")
                return
            }
            else->{
                println("잘못 선택하셨습니다.")
            }

    }
}
}