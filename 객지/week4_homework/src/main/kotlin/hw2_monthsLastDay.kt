fun main(){
    /*연도와 월을 입력받기*/
    println("연도를 입력하세요: ")
    var year: Int=readln().toInt()
    println("월을 입력하세요: ")
    val month: Int=readln().toInt()
    /*
    마지막 날을 저장할 변수 lastday는
    함수 lastDay(year, month)를 저장
    */
    val lastday=lastDay(year, month)
    println("$year 년 $month 월의 마지막 날은 $lastday 일 입니다.")
}
/*
1, 3, 5, 7, 8, 10, 12월일때 는 31일을 반환하고,
4, 6, 9, 11월일 때는 30일을 반환하고,
윤년 2월인 경우 29일을, 그렇지 않은 2월일 경우 28일을 반환하고
엉뚱한 값이 입력됬을 때는 0을 반환하고 잘못된 값이라고 출력해주는
함수를 작성한다.
*/
fun lastDay(y: Int, m: Int):Int{
    return when(m){
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11 -> 30
        2 ->{//윤년을 판단하는 함수 isLeapYear()을 사용
            if (isLeapYear(y)) 29
            else 28
        }
        else ->{
            println("올바른 값이 아닙니다.")
            0
        }
    }
}

/*
윤년 판단 함수:
연도를 4로 나누었을때 나머지가 존재하지 않고,
100으로 나누었을 때 나머지가 존재하면 윤년이 맞음,
또는 연도를 400으로 나누었을 때 나머지가 존재하지 않으면
윤년이 맞음
그 외의 경우 윤년이 아님
*/
fun isLeapYear(year:Int) = (year%400==0)|| (year%4==0 && year%100!=0)