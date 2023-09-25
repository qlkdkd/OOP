package practice1.OOPVer

class DiceGame {
    var dice1=Dice()
    var dice2=Dice()

    fun play(){
        dice1.roll()
        dice2.roll()

        decision(dice1.getValue(), dice2.getValue())
    }

    fun decision(diceValue1: Int,diceValue2: Int){
        if(diceValue1+diceValue2>=7){
            println("Win: 주사위 윗면의 합: ${diceValue1+diceValue2}")
        }
        else{
            println("Lose: 주사위 윗면의 합: ${diceValue1+diceValue2}")
        }
    }
}

fun main(){
    val game=DiceGame()
    game.play()
}