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

