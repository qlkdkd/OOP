package example2
fun sum(a: Int, b: Int)=a+b
fun sub(a: Int, b: Int)=a-b
fun mul(a: Int, b: Int)=a*b
fun div(a: Int, b: Int)=a/b

fun op(a: Int, b: Int, c: (Int, Int)->Int): Int
{
    return c(a, b)
}

fun main()
{
    val res1=op(1, 2, ::sum)
    val res2=op(1, 2, ::sub)
    val res3=op(1, 2, ::mul)
    val res4=op(1, 1, ::div)


}