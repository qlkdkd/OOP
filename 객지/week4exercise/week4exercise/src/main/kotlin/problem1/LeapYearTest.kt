package problem1

fun main() {
    print("연도를 입력하시오>")
    val year = readln().toInt()

//    if ((year%400==0)|| (year%4==0 && year%100!=0))
    if (isLeapYear(year))
        println("$year 년은 윤년입니다.")
    else
        println("$year 년은 평년입니다.")
}

/*
fun isLeapYear(year : Int) : Boolean {
    return (year%400==0)|| (year%4==0 && year%100!=0)
}
*/

fun isLeapYear(year:Int) = (year%400==0)|| (year%4==0 && year%100!=0)