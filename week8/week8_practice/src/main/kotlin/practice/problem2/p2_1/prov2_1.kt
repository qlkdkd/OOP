package practice.problem2.p2_1

open class Shape(protected val x: Int, protected val y: Int)

class Rectangle(x: Int, y: Int,//공통 프로퍼티
                private val width: Int,
                private val height: Int): Shape(x, y){
fun displayRectangle()=println("x=$x, y=$y, width=$width, height=$height")
}

class Circle(private val x: Int, private val y: Int,
             private val radious: Int){
    fun displayCircle()=println("x=$x, y=$y, radious=$radious")
}

fun main() {
    //생성자 호출
    //class rectangle
    // x, y는 class shape로 초기화, width와 hegiht는 class rectangle로 초기화
    val r1 = Rectangle(1,2,3,4);
    val r2 = Rectangle(2,3,4,5)
    val r3 = Rectangle(3,4,5,6)
    //class circle
    val c1 = Circle(3,4,5)
    val c2 = Circle(4,5,6)
    val c3 = Circle(5,6,7)

    r1.displayRectangle()
    r2.displayRectangle()
    r3.displayRectangle()
    c1.displayCircle()
    c2.displayCircle()
    c3.displayCircle()
}