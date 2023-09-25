/*
    메인함수
    연(year), 월(month), 일(day)를 아래의 함수를 이용하여 입력받고
    입력받은 값을 출력해준다.
*/

fun main(){
    val year=inputValidYear()
    println("입력받은 연도는 $year 입니다")
    val month=inputValidMonth()
    println("입력받은 월은 $month 입니다")
    val day=inputValidDay(month, year)
    println("입력받은 일은 $day 입니다")
    println("입력반은 년/월/일은 $year 년 $month 월 $day 일 입니다.")

}
/*
    연도를 입력받는 함수
    연도가 올바르지 않은 값(0보다 작거나 같은 연도)를 입력받으면
    올바른 값을 입력받을 때까지 반복한다.
*/
fun inputValidYear(): Int {
    var y=1
    do{
        println("연도를 입력하시오: ")
        y=readln().toInt()
    }while(y<=0)
    return y
}

/*
    월을 입력받는 함수
    월이 올바르지 않은 값(1보다 작거나 12보다 큰 수)을 입력받으면
    올바른 값을 입력받을 때 까지 반복한다.
*/
fun inputValidMonth(): Int{
    var m=1
    do{
        println("월을 입력하시오: ")
        m=readln().toInt()
    }while(m<1 || m>12)
    return m
}

/*
    일을 입력받는 함수
    일이 올바르지 않은 값(1보다 작거나 maxday보다 작은 수)을 입력받으면
    올바른 값을 입력받을 때 까지 반복한다.
*/
fun inputValidDay(m: Int, y: Int): Int{
    var d=1
    /*
        월의 마지막 날을 찾는 변수 maxday
        when 문을 사용하여 각 월의 마지막 날을 찾는다.
        2월같은 경우, 윤년일 때 마지막 날이 29일이므로
        2번 문제에 쓴 isLeapYear()함수를 가져와서 2월이
        29일까지 있는지 28일까지 있는지를 판별해 주었다.
    */
    var maxday=when(m){
        2->if(isLeapYear(y))29 else 28
        4, 6, 9, 11 -> 30
        else -> 31
    }
    do{
        println("일을 입력하시오: ")
        d= readln().toInt()
    }while(d<1 || d>maxday)
    return d
}