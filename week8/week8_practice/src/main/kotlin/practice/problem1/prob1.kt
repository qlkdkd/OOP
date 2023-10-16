package practice.problem1

class Rectangle{
    val x: Int//공통 프로퍼티
    val y: Int//공통 프로퍼티
    val width: Int
    val height: Int

    constructor(x: Int, y: Int, width: Int, height: Int){
        this.x=x
        this.y=y
        this.width=width
        this.height=height
    }

    fun displayRectangle()=println("x=$x, y=$y, width=$width, height=$height")
}

class Circle{
    val x: Int
    val y: Int
    val radious: Int

    constructor(x: Int, y: Int, radious: Int){
        this.x=x
        this.y=y
        this.radious=radious
    }
    fun displayCircle()=println("x=$x, y=$y, radious=$radious")
}

fun main() {
    val r1 = Rectangle(1,2,3,4);
    val r2 = Rectangle(2,3,4,5)
    val r3 = Rectangle(3,4,5,6)
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