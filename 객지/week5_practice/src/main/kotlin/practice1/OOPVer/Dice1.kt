package practice1.OOPVer

import java.lang.Math.random
class Dice {
    var faceValue: Int=0
    fun roll(){
        faceValue=(random()*6+1).toInt()
    }
    fun getValue()=faceValue
}