package homework

class Account(var balance: Int, var Id: Int, var amount: Int){


    fun select()
    fun withdraw(amount: Int):Int {
        do{
            println("잔액이 부족합니다!")
        }while(balance-amount>0)
        return balance-amount
    }

    fun deposit(amount: Int): Int{
        return amount+balance
        println("$balance 원에서 ${amount}원이 추가되어 잔액에 ${balance+amount}원이 남았습니다.")
    }
}

fun main(){
    val myBankInfo=Account(readln().toInt(), readln().toInt(), readln().toInt())
}