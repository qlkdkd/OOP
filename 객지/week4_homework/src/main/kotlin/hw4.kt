/*
    inputValidYear(), inputValidMonth, inputValidDay()함수는 3번째 실습에서,
    isLeapYear()함수는 2번째 실습에서 가져옴
*/
fun main(){
    var year=inputValidYear()
    var month=inputValidMonth()
    var day=inputValidDay(month, year)
    //윤년일 경우 366일을 반환해주고 그렇지 않을 경우 365일을 반환해준다.

    var totalDay=calculateTotalDays(year, month, day)
    println("기준일(1년 1월 1일)부터 $year 년 $month 월 $day 일까지의 총 $totalDay 입니다.")
}

fun calculateTotalDays(y: Int, m: Int, d: Int): Int{
    var totalDays=0

    //1. 연도에 따른 날 수 추가
    totalDays+=(y-1)*365

    //2. 윤년 계산하여 추가
    totalDays+= y/4 - y/100 + y/400

    //3. 현재 연도가 윤년이고 월이 1월 또는 2월일 경우 1을 뺌
    if (isLeapYear(y)&&(m==1 || m==2)){
        totalDays-=1
    }

    //4. 각 월의 일 수를 더함
    var daysInMonth= intArrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    for (i in 1 until m){
        totalDays+=daysInMonth[i]
    }

    //5. 현재 월의 일수를 더함
    totalDays+=d

    return totalDays
}