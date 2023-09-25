package practice1

import java.lang.Math.random
fun main() {
    val diceValue1: Int = getDiceValue()
    val diceValue2: Int = getDiceValue()

    decision(diceValue1,diceValue2)
}

fun getDiceValue()=(random() * 6 + 1).toInt()
fun decision(diceValue1: Int,diceValue2: Int){
    if(diceValue1+diceValue2>=10){
        println("Win: 주사위 윗면의 합: ${diceValue1+diceValue2}")
    }
    else{
        println("Lose: 주사위 윗면의 합: ${diceValue1+diceValue2}")
    }
}