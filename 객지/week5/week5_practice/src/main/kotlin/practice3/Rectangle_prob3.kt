package practice3

class Rectangle(var width: Double, var height: Double) {
//    var width: Double
//    var height: Double

    constructor(): this(1.0, 1.0)//this: class Rectangle을 의미

//    constructor(width: Double,height: Double){
//        this.width=width
//        this.height=height
//    }
    fun calcArea()=width*height
}

fun main(){

    val rect=Rectangle()//객체 생성
    /*
    println("사각형의 폭을 입력하세요: ")
    rect.width=readln().toDouble()//객체 프로터티 접근
    println("사각형의 높이를 입력하세요: ")
    rect.height=readln().toDouble()
*/
    println("사각형의 넓이: ${rect.calcArea()}")

    val rect2=Rectangle(3.0, 4.0)
    println("사각형2의 넓이: ${rect2.calcArea()}")
}