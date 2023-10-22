# 함수 선언하고 호출하기

## 함수란?
* 함수는 여러 인자 값을 입력 받아 기능을 수행하고 결과값을 반환하는 코드의 모음

![image](https://github.com/qlkdkd/OOP/assets/71871927/05cb36f8-839f-41d9-bfde-d7a8c9218176)

```kotlin
fun sum(a: Int, b: Int): Int{
  var sum=a+b
  return sum
}
```
### 함수의 설명
1. fun키워드로 함수 선언 시작하기
2. 함수 이름 짓기: 키워드는 피할 것, 함수의 이름이 길어지면 카멜표기법으로 작성
3. 매개변수 정의하기: 매개변수는 함수에서 입력한 값을 받는 변수, 콜론(:)과 함께 자료형을 명시해 주어야함
4. 반환값의 자료형 명시: 함수가 반환하는 값이 있다면 반환값의 자료형도 명시해 주어야한다.
5. 함수의 본문 환성하기
6. 값 반환하기: return 키워드와 함께 반환할 값을 명시해야 함

## 함수를 간략하게 표기하기(Kotlin)
```kotlin
fun sum(a: Int, b: Int): Int=a+b//중괄호 안의 코드가 한 줄이면, 중괄호와 return 생략
```

```kotlin
fun sum(a: Int, b: Int)=a+b//a+b가 Int형이므로, 반환값의 자료형 생
```

## 함수의 선언 및 호출 예제
```kotlin
package chap03.section1

fun sum(a: Int, b: Int): Int {
    var sum = a + b
    return sum
}

fun main(){
    val result1 = sum(3, 2) // IntelliJ IDEA에서 매개변수(a: 3, b: 2)를 보여줌
    val result2 = sum(6, 7) // IntelliJ IDEA에서 매개변수(a: 6, b: 7)를 보여줌

    println(result1)
    println(result2)

    var total: Int = 0

    for (num in 1..100 step 2) total += num
    println("Odd total: $total")
```

결과
```
5
13
```

## 반환값이 없는 함수
* 함수의 반환값은 생략할 수 있다.
* 예: 두 인자를 그대로 출력하는 함수는 값을 반환하지 않아도 됨
* 그 대신 반환값의 자료형을 Unit으로 지정하거나 생략할 수 있음

```kotlin
fun printSum(a: Int, b: Int): Unit{
  println("a+b=${a+b}")
}
```

## 매개변수의 기본값
* 코틀린은 함수 매개변수의 기본값 기능을 제공함
```kotlin
package chap03.section1

fun main() {

    val name = "홍길동"
    val email = "hong@example.kr"

    add(name)
    add(name, email)
    add("둘리", "dooly@example.kr")
    defaultArgs()        // 100 + 200
    defaultArgs(200)  // 200 + 200
}

fun add(name: String, email: String = "default") {
    val output = "${name}님의 이메일은 ${email}입니다."
    println(output)
}

fun defaultArgs(x: Int = 100, y: Int = 200) {
    println(x + y)
}
```

결과
```
홍길동님의 이메일은 default입니다.
홍길동님의 이메일은 hong@example.kr입니다.
둘리님의 이메일은 dooly@example.kr입니다.
300
400
```

## 매개변수 이름과 함께 호출하기(Kotlin)
* 만약 함수의 매개변수의 기본값이 있다면, 함수를 호출할 때 모든 입력값을 쓸 필요는 없음
```kotlin
package lecture

fun main() {

    namedParam(x = 200, z = 100) // y는 기본값
    //namedParam(x = 300)  // Error - z에 기본값도 없고 인자도 없으므로.
    namedParam(z = 150)  // Ok - x와 y는 기본값으로 지정됨

}

fun namedParam(x: Int = 100, y: Int = 200, z: Int) {
    println(x + y + z)
}
```

결과
```
500
450

```

## 매개변수가 고정되지 않은 함수 사용하기
* 가변 인자(variable Argument) 사용
* 가변 인자: 인자의 개수가 변함
* 가변 인자를 사용하면 함수는 하나만 정의해놓고 여러개의 인자를 받을 수 있다.

```kotlin
package lecture

fun main() {

    normalVarargs(1, 2, 3, 4) // 4개의 인자 구성
    normalVarargs(4, 5, 6)    // 3개의 인자 구성

}

fun normalVarargs(vararg counts: Int): Unit {
    for (num in counts) {
        print("$num ")
    }
    print("\n")
}
```

결과
```
1 2 3 4 
4 5 6 
```

---

# 함수형 프로그래밍

## 함수형 프로그래밍이란?
* 순수 함수를 작성하여 프로그램의 부작용을 줄이는 프로그래밍 기법
* 함수형 프로그래밍은 람다식과 고차 함수 사용

### 순수 함수
* 같은 인자에 대하여 항상 같은 값을 반환함
* 함수 외부의 어떤 상태도 바꾸지 않음

```kotlin
//순수 함수의 예
fun sum(a: Int, b: Int): Int{
  return a+b
}
```

```kotlin
//비순수 함수의 예
const val global=10

fun main(){
  val num1=10
  val num2=3
  val result=noPureFunction(num1, num2)
  println(result)
}

fun noPureFunction(a: Int, b: Int){
  return a+b+global//입력값과 무관하게 외부의 변수 사용
}
```

## 함수형 프로그래밍이란?
* 순수 함수를 일급 객체로 취급하여, 작은 함수를 합성하는 방식으로 프로그램을 작성하는 방식

### 일급 객체(First Class Citizen)
* 일급 객체는 함수의 인자로 전달할 수 없다.
* 일급 객체는 함수의 반환값에 사용할 수 있다.
* 일급 객체는 변수에 담을 수 있다.

* 함수가 일급 객체면 일급 함수라고 부름
* 일급 함수에 이름이 없는 격우 '람다식' 또는 '람다 함수'라고 부를 수 있음
* 즉, 람다 함수는 일급 객체의 특징을 가진 이름 없는 함수다.

### 고차 함수(High-order Function)
* 다른 함수를 인자로 사용하거나 함수를 결괏값으로 반환하는 함수
* 일급 객체 혹은 일급 함수를 서로 주고받을 수 있는 함수가 고차 함수다

![image](https://github.com/qlkdkd/OOP/assets/71871927/dedc5164-9c9c-42a6-aa44-30854e3cc0af)

---

# 고차함수와 람다식
## 고차 함수의 형태
* 인자에 일반함수를 사용하는 고차 함수
```kotlin
fun main() {

    val res1 = sum(3, 2)  // 일반 인자
    val res2 = mul(sum(3, 3), 3) // 인자에 함수를 사용

    println("res1: $res1, res2: $res2")
}

fun sum(a: Int, b: Int) = a + b

fun mul(a: Int, b: Int) = a * b
```

결과
```
res1: 5, res2: 18
```

* mul()함수의 첫 번째 인자에 sum()함수를 사용

* 반환값에 일반 함수를 사용하는 고차 함수

```kotlin
fun main(){
    println("funcFunc: ${funcFunc()}")
}

fun sum(a: Int, b: Int)=a+b
fun funcFunc(): Int{
    return sum(2, 2)
}
```

결과
```
funcFunc: 4
```

* funcFunc()함수의 반환값으로 sum()함수를 사용

## 람다식
### 람다식(Lambda Expression)이란?
* 익명 함수의 하나의 형태로 이름 없이 입력과 출력과의 대응을 화살표(->)로 표시
* 람다 대수(Lambda calculus)로부터 유래

`{x, y -> x+y}//람다식의 예(이름이 없는 함수)`

### 람다식 예
```kotlin
fun main() {

    var result: Int

    // 1. 일반 변수에 람다식 할당 ((1)~(3)의 선언은 모두 같음)
    val multi = { x: Int, y: Int -> x * y }  // (1) 선언부 생략, 람다식 선언에만 자료형 지정
//    val multi: (Int, Int) -> Int = {x: Int, y: Int -> x * y} // (2) 람다식, 선언부 자료형 지정
//    val multi: (Int, Int) -> Int = {x, y -> x * y}  //  (3) 선언부만 자료형 지정
//    val multi = {x, y -> x * y} // 모든 선언을 제거하면 에러! 추론이 가능하지 않음

    // 람다식 본문이 여러줄인 경우
    val multi2: (Int, Int) -> Int = { x: Int, y: Int ->
        println("x * y")
        x * y  // 마지막 표현식이 반환됨
    }

    // 람다식이 할당된 변수는 함수처럼 사용 가능
    result = multi(10, 20)
    println(result)
    println(multi2(10, 20))
}
```

## 람다식의 다양한 사례
* 람다식의 매개변수에 자료형이 지정되어있다면 변수의 자료형은 생략할 수 있다.
```kotlin
val multi: (Int, Int)->Int={x: Int, y: Int -> x*y}//생략되지 않은 전체 표현
val multi={x: Int, y: int -> x*y}//선언 자료형 생략
val multi: (Int, Int)->Int{x, y->x*y}//람다식 매개변수 자료형의 생략
val multi={x, y->x*y}//에러! 추론 불가능
```
* 표현식이 2줄 이상일 때
```kotlin
val multi2: (Int, Int)->Int{x: Int, y: Int ->
  println("x*y")
  x*y//마지막 표현식이 반환됨
}
```

* 반환 자료형이 없거나 매개변수가 하나 있을 때
    * 람다식에 매개변수와 반환값이 없다면 람다식의 자료형은 Unit이다. 이 때는 매개변수를 표현할 필요가 없으므로 화살표 앞쪽과 화살표 화살표 자체 생략 가능
    * 람다식을 보고 매개변수와 반환값을 추론할 수 있다면 람다식의 매개변수 자료형은 생략할 수 있음
 
```kotlin
val greet: ()->Unit={println("Hello World!)}
val square: (Int)->Int={x->x*x}
```

* 람다식 안에 람다식이 있는 경우: 자료형을 ()->()->Unit로 명시
```kotlin
val nestedLambda: ()->()->Unit={{println("nested")}}
```

* 선언부의 자료형 생략
```kotlin
val greed={println("Hello World!")}//추론 가능
val square={x: Int -> x*x}//선언 부분을 생략하려면 x의 자료형을 명시해야 함
val nestedLambda={{println("nested")}}//추론 가능
```

## 매개변수에 람다식 함수를 이용한 고차 함수

```kotlin
package lecture

fun main(){
    var result: Int
    result=highOrder({x, y -> x+y}, 10, 20)//람다식을 매개변수와 인자로 사용 가능한 함수
    println(result)
}

fun highOrder(sum: (Int, Int)->Int, a: Int, b: Int): Int{
    return sum(a, b)
}
```

결과
```
30
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/e6f59854-8295-4b30-ba99-693ae5d37cff)
1. highOrder()함수를 호출
    * 첫 번째 인자: 람다식{x, y -> x+y}, 두 번째와 세 번째 인자: 정수형
    * 첫 번째 인자의 람다식은 highOrder()함수의 매개변수에서 선언한 자료형을 구성해야 함
2. 3개의 인자를 highOrder()함수의 매개변수에 전달
    * sum은 람다식 함수를 가리키고 a와 b는 각각 20과 30을 가리킴
3. sum은 전달받은 a와 b를 인자처럼 받아서 람다식 x와 y로 대체
    * 함수의 내용인 x+y에 의해 덧셈 연산을 수행한 후 결과 반환
4. 원래 코드의 result로 반환

## 인자와 반환값이 없는 람다식 함수

```kotlin
package lecture

fun main(){
    val out: ()->Unit={println("Hello world!")}//인자와 반환값이 없는 람다식의 선언
    //자료형 추론이 가능하므로 val out={println("Hello world!")}와 같이 생략 가능

    out()//함수처럼 사용 가능
    val new=out//람다식이 들어있는 변수를 다른 변수에 할당
    new()
}
```

결과
```
Hello world!
Hello world!
```

* 람다식은 인자가 없거나 반환값이 없을 수 있음
* 람다식 선언 부분의 화살표 왼쪽에는 비어 있는 형태의 인자를 사용하여 람다식의 인자가 없음을 표현하고 오른쪽에는 Unit을 사용하여 반환값이 Unit임을 표현
* 람다식 본문에도 "Hello world!"를 출력한다는 함수의 내용만 있은 뿐 매개변수가 없기 때문에 인자를 전달받지 않고 있음

## 값에 의한 호출
* 코틀린에서 값에 의한 호출은 함수다 또 다른 함수의 인자로 전달될 경우 람다식 함수는 값으로 처리되어 그 즉시 함수가 수행된 후 값을 전달함

```kotlin
fun main() {
    val result = callByValue(lambda()) // 람다식 함수로 호출
    println(result)
}

fun callByValue(b: Boolean): Boolean { // 일반 변수 자료형으로 선언된 매개변수
    println("callByValue function")
    return b
}

val lambda: () -> Boolean = { // 람다 표현식이 두 줄이다
    println("lambda function")
    true // 마지막 표현식 문장의 결과가 반환
}
```

결과
```
lambda function
callByValue function
true
```

![image](https://github.com/qlkdkd/OOP/assets/71871927/447d2434-b32d-479b-a478-fbd62bb32262)
1. callByValue(lambda())에서 인자로 전달된 lambda()가 먼저 수행
2. 람다식에 의해 "lambda function"을 화면에 출력하고 true를 반환함
3. callByValue() 함수의 b에 값을 복사, 그 다음 callByValue () 함수의 본문인 println()이 수행됨
4. b를 최종적으로 반환
5. result변수에 할당되어 true 출력

## 이름에 의한 람다식 호출
* 람다식의 이름이 인자로 전달될 경우, 람다식 함수는 인자로 전달될때 실행되지 않고, 실제로 호출될 때 실행됨
```kotlin
fun main() {
    val result = callByName(otherLambda) // 람다식 이름으로 호출
    println(result)
}

fun callByName(b: () -> Boolean): Boolean { // 람다식 함수 자료형으로 선언된 매개변수
    println("callByName function")
    return b()
}

val otherLambda: () -> Boolean = {
    println("otherLambda function")
    true
}
```

결과
```
callByName function
otherLambda function
true
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/94be2aff-1b03-45dd-ab27-af4c07bcfe0b)
1. 람다식 자체가 매개변수에 복사됨: 람다식 이름을 callByName() 함수의 인자로 넣어 사용하고 있음. 람다식 매개변수 b에 복사되어 사용되기 전까지는 람다식이 실행되지 않음
2. 람다식이 호출되어 실행: 함수 형태로 호출해야 비로소 람다식이 실행됨. 이름이 전달된 시점이 아니라 callByName() 함수 블록에 사용되는 b()에 의해 호출된다는 것
3. true 반환
4. b()가 결과인 true 반환
5. result에 true 반환

## 다른 함수의 참조에 의한 일반 함수 호출
* 람다식이 아닌 일반 함수를 또 다른 함수의 인자에서 호출하는 고차 함수의 경우

```kotlin
fun suim(x: Int, y: int)=x+y

funcParam(3, 2, sum)//오류! sum은 람다식이 아님
fun funcParam(a: Int, b: Int, c: (Int, Int)->Int): Int{
  return c(a, b)
}
```

## 참조에 의한 호출 방식으로 함수 호출하기 예제
```kotlin
fun main() {

    // 1. 인자와 반환 값이 있는 함수
    val res1 = funcParam(3, 2, ::sum)
    println(res1)

    // 2. 인자가 없는 함수
    hello(::text) // 반환값이 없음
   // hello({ a, b -> text(a, b) }) // 위의 식과 동일한 표현
   // hello { a, b -> text(a, b) } // 위의 식과 동일한 표현

    // 3. 일반 변수에 값처럼 할당
    val likeLambda = ::sum
    // 혹은 val likeLambda:(Int, Int) -> Int = ::sum
    println(likeLambda(6,6))
}

fun sum(a: Int, b: Int) = a + b

fun text(a: String, b: String) = "Hi! $a $b"

fun funcParam(a: Int, b: Int, c: (Int, Int) -> Int): Int {
    return c(a, b)
}

fun hello(body: (String, String) -> String): Unit {
    println(body("Hello", "World"))
}
```

결과
```
5
Hi! Hello World
12
```

* 콜론 2개(::)를 이용한 표기법
```kotlin
hello(::text)//함수 참조 기호
hello({a, b, text(a, b)}//람다식 표현(동일한 결과)
hello{a, b, text(a, b)}//소괄호 생략(동일한 결과)
```

1. funcParam(3, 2, ::sum)은 인자 3, 2가 sum에 전달되며 결괏값으로 5 반환
2. hello(::text)는 반환값이 없으며 hello()함수 선언부의 body()함수와 함수에 인자로 전달한 2개의 문자열이 hi!와 결합되어 출력
3. ::sum을 변수에 할당함

## 매개변수 개수에 따라 람다식을 구성하는 방법

```kotlin
fun main() {
    // 1. 매개변수 없는 람다식 함수
    noParam({ "Hello World!" })
    noParam { "Hello World!" } // 위와 동일 결과, 소괄호 생략 가능

    // 2. 매개변수가 하나 있는 람다식 함수
    oneParam({ a -> "Hello World! $a" })
    oneParam { a -> "Hello World! $a" } // 위와 동일 결과, 소괄호 생략 가능
    oneParam { "Hello World! $it" }  // 위와 동일 결과, it으로 대체 가능

    // 3. 매개변수가 두개 있는 람다식 함수
    moreParam { a, b -> "Hello World! $a $b" } // 매개변수명 생략 불가

    // 4. 인자와 함께 사용하는 경우
    withArgs("Arg1", "Arg2", { a, b -> "Hello World! $a $b" })
    // withArgs()의 마지막 인자가 람다식인 경우 소괄호 바깥으로 분리 가능
    withArgs("Arg1", "Arg2") { a, b -> "Hello World! $a $b" }

    // 5. 특정 매개변수의 생략
    omitArgs("Arg1", "Arg2") { _, b -> "Hello World! $b" }

}

// 매개변수가 없는 람다식 함수가 noParam 함수의 매개변수로 지정됨
fun noParam(out: () -> String) = println(out())

// 매개변수가 하나 있는 람다식 함수가 oneParam함수의 매개변수로 지정됨
fun oneParam(out: (String) -> String) {
    println(out("OneParam"))
}

// 매개변수가 두개 있는 람다식 함수가 moreParam함수의 매개변수로 지정됨
fun moreParam(out: (String, String) -> String) {
    println(out("OneParam", "TwoParam"))
}

// withArgs함수는 일반 매개변수 2개를 포함, 람다식함수를 마지막 매개변수로 가짐
fun withArgs(a: String, b: String, out: (String, String) -> String) {
    println(out(a, b))
}

// 특정 매개변수의 생략
fun omitArgs(a: String, b: String, out: (String, String) -> String) {
    println(out(a, b))
}
```

![image](https://github.com/qlkdkd/OOP/assets/71871927/525b91c1-b562-4b7a-8aae-a70773bcfe4a)

1. 매개변수가 없는 경우
    * noParam() 함수의 매개변수는 람다식 1개를 가지고 있음. 이때는 함수 사용 시 소괄호 생략 가능
    * main()함수에서 사용된 noParam() 함수의 인자에는 람다식 표현식인 {...}형태의 인자가 있음. 이 람다식에서는 매개변수가 없으므로 화살표(->)기호가 사용되지 않음

![image](https://github.com/qlkdkd/OOP/assets/71871927/2f3e16d0-e030-4bfd-b4af-a0ceb88789c1)

2. 매개변수가 1개인 경우
    * 매개변수 1개가 들어간 람다식을 구성할 때 변수와 화살표를 추가하여 a -> 와 같이 나타냄
    * 경우에는 화살표 표기를 생략하고 $it로 대체함.
    * $it는 람다식 매개변수로 지정된 String형과 매칭되어 "OneParam"문자열로 바뀌며 최종적으로 "Hello World! OneParam"을 출력함

![image](https://github.com/qlkdkd/OOP/assets/71871927/7c1561c8-7106-4574-a23b-480e6b1c4c4c)

3. 매개변수가 2개 이상인 경우
    * moreParam()함수의 out에 정의된 대로 a는 매개변수의 첫 번째 String형을 사용되고, b는 두 번째 String형을 위해 사용됨
    * 매개변수가 2개 이상일 때는 $it을 사용해 변수를 생략 불가능
    * 만약 특정 람다식의 매개변수를 사용하고 싶지 않을 때는 이름 대신 언더바(_)로 대체할 수 있음
        * `moreParam{_, bn -> "Hello World! $b"}`

![image](https://github.com/qlkdkd/OOP/assets/71871927/71d13308-8b82-4131-b472-8ef4397b27e7)

4. 일반 매개변수와 람다식 매개변수를 같이 사용
    1. 일반 함수 withArgs()에 2개의 매개변수 a와 b 그리고 람다식을 추가
         * 람다식이 짧으면 소괄호 안에 인자를 모두 전달할 수 있으마 람다식이 길어지면 읽기가 어려워짐
    2. 일반 함수의 마지막 매개변수가 람다식 함수라면 withArgs()함수의 소괄호 바깥으로 마지막 인자인 람다식을 빼낼 수 있음

![image](https://github.com/qlkdkd/OOP/assets/71871927/afef3a17-cca2-47f1-9910-e77076c30ec6)

5. 두개의 람다식을 가진 함수의 사용
    * 보통 twoLambda() 함수의 소괄호를 생략할 수 없으나, 마지막 인자는 소괄호 밖에 둘 수 있다.
    * 람다식 함수가 3개 이상일 때도 마찬가지
