# w11. 제네릭과 배열
# 1. 제네릭

## 파리미터화된 프로그래밍(Parameterized Programming)
* 프로그램의 동작 및 행동을 설정, 조정 또는 변경하기 위해 매개변수(parameter)를 사용하는 프로그래밍 기법
![image](https://github.com/qlkdkd/OOP/assets/71871927/68042938-4095-4e75-8170-94db5869d4cd)

## 제네릭
### 제네릭이란?
* 제네릭: 클래스 내부에서 사용할 자료형을 나중에 인스턴스를 생성할 때 확정
* 클래스나 메소드 내부에서 사용할 자료형을 컴파일 시간에 결정하는 방법
* 제네릭 인터페이스 혹은 클래스
* 제네릭 함수 혹은 메소드
![image](https://github.com/qlkdkd/OOP/assets/71871927/20b198ce-3e06-44a7-982a-842d2edcd598)

### 제네릭의 일반적인 사용
* 앵글 브래킷(<>) 사이에 형식 매개변수를 사용해 선언
* 형식 매개변수는 자료형을 대표하는 용어로 T와 같이 특정 영문의 대문자로 사용(다른 이름 사용 가능)
```kotlin
interface Set<E>
interface Map<K. V>
```

형식(매개변수 이름)|의미
---|---
E|요소(element)
K|키(key)
N|숫자(number)
T|형식(type)
V|값(value)
S,U, V, etc.|두번째, 세번째, 네번째 형식(2nd, 3rd, 4th types)

* 제네릭의 장점: 의도하지 않은 자료형의 객체를 지정하는 것을 막고 객체를 사용할 때 원래의 자료형에서 다른 자료형으로 형 변환 시 발생할 수 있는 오류를 줄여줌

### [간단한 제네릭의 예]()
```kotlin
package section1

class Box<T>(t: T){//형식 매개변수로 받은 인자를 name에 저장
    var name=t
}

fun main(){
    val box1: Box<Int> =Box<Int>(1)
    val box2: Box<String> =Box<String>("Hello")
    println(box1.name)
    println(box2.name)
}
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/76120b86-1c37-4211-94fb-1b0868b5d195)

## [제네릭 클래스]()
### 형식 매개변수를 한 개 이상 받는 클래스
* 인스턴스를 생성하는 시점에서 클래스의 자료형을 정하게 된다.
* 제네릭 클래스 내에 메서드와 프로퍼티에 다음과 같이 형식 매개변수를 사용
* 만일 형식 매개변수를 클래스의 프로퍼티에 사용하는 경우 클래스 내부에서는 사용할 수 없다.
* 그 대신 주 생성자나 부 생성자에 형식 매개변수를 지정해 사용할 수 있다.
* 그러면 객체 인스턴스를 생성할 때 명시적으로 자료형 지정 가능
```kotlin
package section1

/*
class myClass<T>{
    var myProp: T//오류! 프로퍼티는 초기화되거나 abstract로 선언되어야 함
}
*/

class MyClass<T>(val myProp: T) {  // 주생성자 프로퍼티의 자료형에 사용됨
    fun <S>myMethod(a: S) { 		// 메서드의 매개변수 자료형에 사용됨
        println("a=$a")
    }
}

fun main() {
    var a = MyClass<Int>(12)
    println(a.myProp)
    a.myMethod(2)

    var b = MyClass<String>("hello")
    println(b.myProp)
    b.myMethod("world")

}
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/4d040dfc-6b54-40da-b225-683c5cd3bb00)

## [형식 매개변수의 null 제어]()
### 제네릭의 형식 매개변수는 기본적으로 null이 허용되는 자료형(예, Int?)을 수용한다.
* 형식 매개변수 T가 null이 허용되는 자료형을 제한하려면, 특정 자료형을 지정해야 한다. -> <T: Any>

```kotlin
package section1

class GenericNull<T>{//T는 기본적으로 null이 허용되는 자료형을 수용
    //calss GenericNull<T: Any>로도 선언 가능
    
    fun EqualityFunc(arg1: T, arg2: T){
        println(arg1?.equals(arg2))//null 허용
    }
}

fun main(){
    val obj=GenericNull<String>()//non-null로 선언됨
    obj.EqualityFunc("Hello", "World")//null을 허용하지 않음

    val obj2=GenericNull<Int?>()//null이 가능한 형식으로 선언됨
    obj2.EqualityFunc(null, 10)//null 사용
}
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/629507d8-e092-489d-850f-e7b589a5f56b)
* GenericNull 클래스에 사용된 형식 매개변수 T는 기본적으로 null을 허용
* 마지막 코드인 obj2.EqualityFunc(null, 10)에서 null을 사용하고 있으며 안전한 작업을 위해 코드 본문에는 arg1?.equals(arg2)처럼 null인 경우 equals()로 비교하지 않고 null을 반환하게 됨
* null을 허용하지 않으려면 형식 매개변수에 특정 자료형을 지정하면 null을 제한함

## [제네릭 함수 혹은 메서드]()
* 형식 매개변수를 받는 함수/매서드
* 해당 함수나 메서드 앞쪽에 <T>와 같이 지정
* <K, V>와 같이 형식 매개변수를 여러개 사용 가능
* 자료형의 결정은 함수가 호출될 때 컴파일러가 자료형 추론
```kotlin
fun<T> genericFunc(arg: T): T?{...}//매개변수와 반환 자료형에 형식 매개변수 T가 사용
fun<K, V> put(key: K, value: V): Unit{...}//형식 매개변수가 여러개인 경우
```
```kotlin
package section1

fun <T> find(a: Array<T>, Target: T): Int{
    for(i in a.indices){
        if(a[i]==Target)return i
    }
    return -1
}

fun main(){
    val arr1: Array<String> = arrayOf("Apple", "Banana", "Cherry", "Durian")
    println("arr.indices ${arr1.indices}")//arr.indices 0...3(indices는 배열의 유효 범위 반환)
    println(find(arr1, "Cherry"))//요소 2의 인덱스 찾아내기
}
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/5c9367c1-713e-4bbb-b579-40d430ff7791)

## [자료형 제한하기]()
* 자료형의 사용 범위를 좁히기 위해서
  * 코틀린은 콜론(:)과 자료형을 기입하면 형식 매개변수 T의 자료형이 기입한 자료형으로 제한됨
 
```kotlin
//자료형을 숫자로 제한하기
package section1

class Calc<T: Number>{//클래스의 형식 매개변수 제한
    fun plus(arg1: T, arg2: T): Double{
        return arg1.toDouble()+arg2.toDouble()
    }
}

fun main(){
    val calc=Calc<Int>()
    println(calc.plus(10, 20))

    val calc2=Calc<Double>()
    val calc3=Calc<Long>()
    //val calc4=Calc<Stirng>()//제한된 자료형으로 인해 오류 발생!

    println(calc2.plus(2.5, 3.5))
    println(calc3.plus(5L, 10L))
}
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/22e39447-3af2-4255-9fc2-2ea622e2e593)

---

# 2. 배열 다루기
## 베열이란?
