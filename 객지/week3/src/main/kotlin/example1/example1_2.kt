package example1

fun main()
{
    //람다식 예제
    var square={a: Int -> a*a}
    var negative={a: Int -> -a}
    var sum={a: Int, b: Int -> a+b}
    var sub={a: Int, b: Int -> a-b}

    var a=square(2)
    var b=negative(2)
    var c=sum(1, 2)
    var d=sub(1, 2)

    println("$a, $b,$c, $d")
}