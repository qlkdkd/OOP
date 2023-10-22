# 조건문

## 조건문 -if, if-else, 다중 if-else(Kotlin, Java 전용)
### 조건: if
```kotlin
if(조건식){
    실행 문장
}
```

### 조건: if-else
```kotlin
if(조건식){
    실행 문장1
}
else{
    실행 문장2
}
```

### 다중 조건 if-else
```kotlin
if(조건식1){
    실행문1
}
else if(조건식2){
    실행문2
}

else if(조건식m){
    실행문m
}

else{
    실행문n
}
```

## 예제: if문

### 1. 1~12월 사이의 월을 입력받아, 해당 월의 문자열을 출력하는 프로그램
```kotlin
package week4.section1

import java.util.*


object IfStatmentTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val month: Int

        val sc = Scanner(System.`in`)
        print("월을 입력하시오(1~12):")
        month = sc.nextInt()
        if (month == 1) println("January")
        if (month == 2) println("February")
        if (month == 3) println("March")
        if (month == 4) println("April")
        if (month == 5) println("May")
        if (month == 6) println("June")
        if (month == 7) println("July")
        if (month == 8) println("August")
        if (month == 9) println("September")
        if (month == 10) println("October")
        if (month == 11) println("November")
        if (month == 12) println("December")
    }
}
```

### 2. 키보드에서 입력 받은 정수가 홀수인지 짝수인지를 말해주는 프로그램
```kotlin
package week4.section1

import java.util.*

fun main() {
    val number: Int

    val sc = Scanner(System.`in`)
    print("정수를 입력하시오: ")
    number = sc.nextInt()

    if (number % 2 == 0) {
        println("입력된 정수는 짝수입니다.")
    } else {
        println("입력된 정수는 홀수입니다.")
    }

    println("프로그램이 종료되었습니다. ")
}
```

### 3. 사용자로부터 받은 정수가 양수인지 음수인지 0인지를 검사하는 프로그램
```kotlin
package week4.section1

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    print("정수를 입력하시오: ")
    val number1: Int = sc.nextInt()
    if (number1 > 0) {
        println("양수입니다.")
    } else if (number1 == 0) {
        println("0입니다.")
    } else {
        println("음수입니다.")
    }
}
```

## if~else문의 간략화(Kotlin)
### 조건 표현식
```kotlin
//기존 방식
var max: Int
if(a>b) max=a
else max=b
```

```kotlin
//간략화 버전
var max=if(a>b)a else b
```

### 조건 표현식 예제
```kotlin
fun main(){
    var a=12
    var b=7

    val max=if(a>b) a else b
    println(max)
}
```

## in 연산자와 범위 연산자로 조건식 간략하게 만들기
### in 연산자와 범위(...)지정자
* **변수명 in 시작값 ... 마지막값**

### 예제
```kotlin
if(score>=90.0) grade='A'
else if(score in 80.0 ... 89.9) grade='B'
...
```

## 다중 조건식-when(kotlin)
### 문법
* 문장과 표현식(변수에 할당됨)의 두 가지 형식 제공
* 인자는 생략 가능하고, 식은 임의의 표현식이 가능하나 일반적으로는 변수로 표현됨
* 내부는 하나 이상의 조건 분기를 포함
    * 화살표(->) 왼쪽에는 인자의 식과 일치하는 값, 식, 범위, 타입, else로 조건을 나타내고, 오른쪽에는 수행할 문장
    * (콤마로 구분된) 다중 조건 표현 가능
### 동작 방식
* 조건 분기의 비교 값이 식과 일치하면 해당 실행 문장 수행
* 조건과 일치하는 값이 없으면 else문 실행

![image](https://github.com/qlkdkd/OOP/assets/71871927/8637fef4-384b-4478-a04f-bbafee284d3e)

## when(Kotlin)-문장 vs 표현식
![image](https://github.com/qlkdkd/OOP/assets/71871927/7ed34464-bcd3-4bb3-b300-cd37f2003db2)

## when-다양한 조건 분기

* 일치되는 여러 조건
```kotlin
when(x){
    0, 1 -> println("x==0 or x==1")
    else -> println("기타")
```

* 범위에 따른 조건 분기(in 연산자)
```kotlin
when(x){
    in 1..10->println("x는 1 이상 10 이하")
    !in 10..20->println("x는 10 이상 20 이하가 아님")
    else-> println("x는 어떤 범위에도 없음")
}
```

* 타입에 따른 조건 분기(is 연산자)
```kotlin
val str="안녕하세요"
val result=when(str){
    is String->"문자열"
    else->false
```

## when-인자가 없는 when
* when 문에 인자가 주어지지 않으면 else if 문처럼 각각의 조건을 실행시킬 수 있음
* 형식
```kotlin
when{
    조건[혹은 표현식] -> 실행문
    ...
}
```
* 특정 인자에 제한하지 않고 다양한 조건을 구성

### 예제
```kotlin
fun main(){
    print("Enter the score: ")
    val score=readLine()!!.toDouble()
    var grade: Char='F'

    //인수 없는  when의 사용
    when{
        score>=90->grade='A'
        score in 80.0..89.9->grade='B'
        score in 70.0..79.9->grade='C'
        score<70.0->grade='F'
    }
    println("Score: $score, Grade: $grade")
}
```

## 다양한 자료의 인자 받기 예제
```kotlin
fun main() {
    cases("Hello") // String
    cases(1) // Int
    cases(1234L) // Long
    cases(MyClass()) // Not a string
}
fun cases(obj: Any) {
    when (obj) {
        1 -> println("Int: $obj")
        "Hello" -> println("String: $obj")
        is Long -> println("Long: $obj")
        !is String -> println("Not a String")
        else -> println("Unknown")
    }
}
```

결과
```
String: Hello
Int: 1
Long: 1234
Not a String
```

## 다중 조건식-switch(자바)
### 문법
* 식은 일반적으로는 변수로 표현됨
* case문의 값은 정수, 문자, 문자열 리터럴을 허용
* switch 표현식 가능(JDK12+)
* (콤마로 구분됨) 다중 case값 표현 가능
### 동작 방식
* case의 비교값이 식과 일치하면 해당 실행문장 수행
    * break를 만나면 switch문을 벗어남(JDK12-)
    * break 생략(JDK12+)
* 식과 일치하는 case의 비교 값이 없으면 default문 실행
    * default문은 생략 가능
    * switch 표현식을 사용하는 경우 case문의 값은 식의 모든 값을 커버할 수 있도록 default가 요구될 수 있음
 
![image](https://github.com/qlkdkd/OOP/assets/71871927/50c818db-11eb-47c2-8d15-9d0407271ff2)
![image](https://github.com/qlkdkd/OOP/assets/71871927/b8b5cd96-9f9d-4623-898e-4ac9ba5067fa)

---

# 반복

## while 문
```kotlin
while(조건식){//조건식이 true인 동안 본문의 무한 반복
    본문
    ...
}
```

## while문 예제: 팩토리얼 계산
```kotlin
fun main(){
    println("Enter the number: ")
    var number=readLine()!!.toInt()
    var factorial: Long=1

    while(number>0){
        factorial*=number
        --number
    }
    println("Factorial: $factorial")
```

## 반복문-do~while문
### do~while문
```kotlin
do{
    본문
}while(조건식)//Java에서는 문장 끝에 세미콜론(;)을 추가해야 함
```

### do~while문 예제
```kotlin
var i=1
do{
    println("$i")
    ++i
}while(i<=5)
```

결과
```
1
2
3
4
```

## 반복문-for문
`for(요소 변수 in컬렉션 혹은 범위){반복할 본문}`
```kotlin
for(x in 1..5){//코틀린의 in과 범위 지정을 활용한 루프
    println(x)//본문
}

for(x in 1..5) println(x)//한 줄에 표현하는 경우
```

### 하행 반복

```kotlin
for (i in 5 downTo 1)println(i)
for (i in 5..1)println(i)//잘못된 사용! 아무것도 출력하지 않음
```

### 필요한 단계 증가-step
```kotlin
for (i in 1..5 step 2)println(i)//숫자를 2단계씩 증가
```

### 혼합 사용
```kotlin
for(i in 5 downTo 1 step 2)println(i)
```

## for문 예제: 삼각형 출력하기
```kotlin
fun main() {

    print("Enter the lines: ")
    val n = readLine()!!.toInt() // 콘솔로부터 입력 받는다

    for (line in 1..n) {
        for (space in 1..(n - line)) print(" ") // 공백 출력
        for (star in 1..(2 * line - 1)) print("*")// 별표 출력
        println() // 개행
    }
}
```

결과
```
Enter the lines: 5
    *
   ***
  *****
 *******
*********
```

## for문 예제: 짝수와 홀수의 합 구하기

```kotlin
fun main(){
    var total: Int=0

    for(num in 1..100 step 2) total+=num
    println("Odd total: $total")

    for(num in 0..99 step 2)total+=num
    println("Even total: $total")
}
```

결과
```
Odd total: 2500
Even total: 4950

```

---

# 흐름의 중단과 반환
## return문
* return 문으로 값 반환하기: 보통 return 문은 다음과 같이 값을 반환하는 데 사용됨
```kotlin
fun add(a: Int, b: Int): Int{
    return a+b
    println("이 코드는 실행되지 않음")// 함수 내에서 return 문 다음 문장부터는 실행이 안된다.
}
```

## return으로 Unit반환하기
```kotlin
//1. Unit을 명시적으로 반환
fun hello(name: String): Unit{
    println(name)
    return Unit
}

//2 Unit 이름을 생략한 반환
fun hello(name: String): Unit{
    println(name)
    return
}

//3. return문 자체를 생략
fun hello(name: String){
    println(name)
}
```

## Lambda식에서 return 사용하기
* 람다식에서는 return을 바로 사용할 수 없음
```kotlin
val add={a: Int, b: Int -> a+b}//O
val add={a: Int, b: Int -> return a+b}//X
```
* return@label과 같이 라벨(label) 표기와 같이 사용해야 함
    * 라벨: 코드에서 특정한 위치를 임의로 표시한 것으로, @ 기호와 이름을 붙여서사용한다.
* 인라인으로 선언된 함수에서 람다식을 매개변수로 사용하면 람다식에서 return 을 사용할 수 있음

```kotlin
fun main(){
    println("start of retFunc")
    applyLambda(3, 3, printSum)
    applyLambda(13, 3, printSum)
    applyLambda(7, 3, printSum)
    println("end fo retFunc")
}

fun applyLambda(a: Int, b: Int, op: (Int, Int)->Unit): Unit=op(a, b)

        val printSum=label@{a: Int, b: Int ->
            val result=a+b
            if(result>10)return@label//10보다 크면 결과를 출력하지 않음
            println("result: $result")
        }
```

## 익명 함수에서 return 사용하기
* 익명 함수: 함수 이름이 생략된 함수
```kotlin
fun (x: Int, y: Int): Int=x+y

val add:(Int, Int)->Int=fun(x, y)=x, y//익명 함수를 선언한 add 선언
val result=add(10, 2)//add의 사용

val add=fun(x:Int, y:Int)=x+y
val add={x: Int, y: Int ->x+y}//람다식과 매우흡사

//익명 함수에서의 return (라벨을 사용하지 않아도 됨)
val printSum(a: Int, b: Int){
    val result=a+b
    if(result>10)return
    println("result: $result")
}
```

### 익명함수 예제
```kotlin
package Test

fun main(){
    println("start of retFunc")
    applyLambda(3, 3, printSum)
    applyLambda(13, 3, printSum)
    applyLambda(7, 3, printSum)
    println("end of retFunc")
}

fun applyLambda(a: Int, b: Int, op: (Int, Int)->Unit): Unit=op(a, b)

//익명 함수
val printSum=fun(a: Int, b: Int){
    val result=a+b
    if(result>10)return//10보다 크면 결과를 출력하지 않음
    println("result: $result")
}
```

결과
```
start of retFunc
result: 6
result: 10
end of retFunc
```

## 주의할 점
![image](https://github.com/qlkdkd/OOP/assets/71871927/007ebb81-6860-4020-bd7d-31a556203d6d)

## break와 continue
* for나 while, do...while문 루프를 빠져 나옴
![image](https://github.com/qlkdkd/OOP/assets/71871927/3043bdb5-d046-4d41-8f33-69b32ad31ad6)

## 조건에 따른 break 사용하기
```kotlin
package week4.section3

fun main() {
    for (i in 1..5) {
        if (i==3) continue //또는 break // for문 자체가 중단됨
        print(i)
    }
    println()
    println("outside")
}
```

## 예외
### 예외(exception): 실행 도중의 잠재적인 오류까지 검사할 수 없기 때문에 정상적으로 실행이 되다가 비정상적으로 프로그램이 종료되는 경우
* 운영체제의 문제(잘못된 시스템 호출의 문제)
* 입력 값의 문제(존재하지 않는 파일 혹은 숫자 입력란에 문자 입력 등)
* 받아들을 수 없는 연산(0으로 나누기 등)
* 메모리의 할당 실패 및 부족
* 컴퓨터 기계 자체의 문제(전원 문제, 망가진 기억 장치 등)

### 예외을 대비하기 위한 구문
```kotlin
try{
    예외 발생 가능성 있는 문장
}catch(e: 예외처리 클래스명){
    예외를 처리하기 위한 문장
}finally{
    반드시 실행되어야 하는 문장
}
```

* 반드시 실행해야 할 작업이 없다면 finally 블록은 생략하고 try~catch 블록만으로도 코드를 구성할 수 있다.

## 예제: 0으로 나누었을 때 예외 처리하기
```kotlin
fun main() {
    val a = 6
    val b = 0
    val c : Int

    try {
        c = a / b  // 예외가 발생할 수 있는 코드
     // (1) 기본 사용
//    } catch (e : Exception){
//        println("Exception is handled.")
//    }

     // (2) 특정 예외 처리
//    } catch (e : ArithmeticException){
//        println("Exception is handled. ${e.message}")
//    }

    // (3) 스택 추적
    } catch (e : Exception){
        e.printStackTrace()
    }

    // (3) 메시지 출력
//    } catch (e : Exception){
//        println(e.message)
//    }

    finally {
        println("finally 블록은 반드시 항상 실행됨")
    }
}
```
