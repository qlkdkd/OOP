fun main()
{
    println("연도를 입력하세요: ")
    var year: Int=readln().toInt()//연도 입력

    /*
    연도를 4로 나누었을때 나머지가 존재하지 않고,
    100으로 나누었을 때 나머지가 존재하면 윤년이 맞음,
    또는 연도를 400으로 나누었을 때 나머지가 존재하지 않으면
    윤년이 맞음
    */
    if((year%4==0 && year%100!=0)||year%400==0){
        println("$year 년은 윤년이 맟습니다.")
    }
    /*
    그 외의 경우 윤년이 아님
    */
    else println("$year 년은 윤년이 아닙니다.")
}