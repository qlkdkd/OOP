class Account(_balance: Int){
    val id: String// 선언자를 val로 하면 외부에서 읽을수만 있다.

    var balance: Int=_balance
        private set
    init{
        id="acc"+System.currentTimeMillis()
    }
    constructor(): this(0)

    fun  withdraw(amount: Int){
        if(amount>0 && balance>=amount){
            balance-=amount
            println("$amount 원이 출금되었습니다. $id 계좌의 총 잔액은 $balance 원 입니다.")
        }
        else{
            println("잔액이 부족합니다.")
        }
    }

    fun deposit(amount: Int){
        if(amount>0){
            balance+=amount
            println("$amount 원이 입금되었습니다. $id 계좌의 총 잔액은 $balance 입니다.")
        }
    }
}