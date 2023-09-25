package example2

//하나의 매개변수를 받는 고차함수
fun applyUnaryFunction(a: Int, op: (Int)->Int):Int
{
  return op(a)
}

//두 개의 매개변수를 받는 고차함수
fun applyBinCalculation(a: Int, b: Int, op: (Int, Int)->Int): Int
{
    return op(a, b)
}

fun main()
{
    var square={a: Int ->a*a}
    var negative={a: Int -> -a}
    var sum={a: Int, b: Int -> a+b}
    var sub={a: Int, b: Int -> a-b}
    println("${applyUnaryFunction(2, square)}")
    println("${applyUnaryFunction(2, negative)}")
    println("${applyBinCalculation(2, 2, sum)}")
    println("${applyBinCalculation(2, 2, sub)}")
}
