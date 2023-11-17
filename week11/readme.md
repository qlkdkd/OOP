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
## 배열이란?
* 데이터를 연속적으로 나열한 형태
![image](https://github.com/qlkdkd/OOP/assets/71871927/00b99a8a-fd77-4114-bdb8-8fc84e881131)
* 배열 생성 방법
    * arrayOf() 혹은 arrayOfNulls()(빈 배열) 함수 활용: 특정 값을 넣어서 배열을 생성
    * Array() 생성자 활용

## 배열 생성: arrayOf()
* Array 타입의 배열 객체를 반환하는 함수
```kotlin
public inline fun <reified @PurePeifiable T> arrayOf(varang elements: T): Array<T>
```

* 기본 및 다차원 배열
```kotlin
package section2

//기본 배열
fun main() {

    val array1 = arrayOf(1, 2, 3)
    val array2 = arrayOf(4, 5, 6)
    val array3 = arrayOf(7, 8, 9)

    val arr2d = arrayOf(array1, array2, array3)

    // 또는 다음과 같이 초기화 할 수 있음
    //val arr2d_v2 = arrayOf(arrayOf(1, 2, 3), arrayOf(4, 5, 6), arrayOf(7, 8, 9))

    for (e1 in arr2d) {
        for (e2 in e1) {
            print(e2)
        }
        println()
    }

    println(arr2d[2][1])
}
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/40238804-c1cf-40e6-82ba-ab95401adf45)

## 배열 생성: 다양한 자료형
* 다양한 자료형의 혼합 가능
```kotlin
val mixArr=arrayOf(4, 5, 7, 3, "Chike", false)//정수, 문자열, 논리형 혼합
```

* 특정 자료형을 제한할 경우
    * arrayOf<자료형>()
    * 자료형 이름+ArrayOf()
          * charArrayOf(), booleanArrayOf(), longArrayOf(), shortArrayOf(), byteArrayOf(), intArrayOf()...
          * 부호 없는 자료형: ubyteArrayOf(), ushortArrayOf(), uintArrayOf(), ulongArrayOf()
```kotlin
val intOnlyArr1=arrayOf<Int>(4, 5, 7, 3)
val intOnlyArr2=intArrayOf(4, 5, 7, 3)
```

## 배열 생성: Array()
* 코틀린 표준 라이브러리의 Array.kt
```kotlin
public class Array<T>{
    public inline constructor(size: Int, init: (Int)->T)
    public operator fun get(index: Int, value: T)
    public operator fun set(index: Int, vlaue: T):Unit
    public val size: Int
    public operator fun iterator(): Iterator<T>
}
```

* Array 생성자를 통한 배열 생성
    * size: 배열의 크기
    * init: 초기값을 위한 람다식(Int)->T
```kotlin
val numArray=Array(5, {i->i*2})//[0, 2, 4, 6, 8]
for (element in numArray)
    println(element)

val a=Array(1000, {i->myClass(i)
```

## 다양한 자료형을 위한 Any로 선언된 배열
```kotlin
fun main(){
    val b=Array<Any>(10, {0})
    b[0]="Hello World"
    b[1]=1.1
    println(b[0])
    println(b[1])
    println(b[2])
}
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/3b0c6cd3-6a4d-44ef-96a9-aff2e633f9f7)

## [배열 요소에 접근하기]()
* 배열에 사용하는 Array 클래스는 get()와 set() 메서드를 가지고 있는데 이것은 요소에 접근하기 위한 게터/세터임
* 코틀린에서 배열은 대괄호를 사용해도 접근할 수 있는데 이건은 연산자 오버로딩으로 정의되어 있기 때문
```kotlin
arr.get(index)->value=arr[index]
arr.set(index)->arr[index]=value
```
* 인덱스 번호 2번인 세 번째 요소가 출력 되어 두 출력문 모두 3을 나타냄. 따라서 arr.get()과 arr[]은 동일한 표현
```kotlin
val arr=intArrayOf(1, 2, 3, 4, 5)
println(arr.get(2))
println(arr[2])
```
* 다차원 배열일 경우 대괄호를 하나 더 사용
```kotlin
val arr2d=arrayOf(arrayOf(1, 2, 3), arrayOf(4, 5, 6), arrayOf(7,8,9))
pritnln(arr2d[2][1])
```

* 배열 안에 값을 설정할 경우: set()에 의해 처리됨
```kotlin
arr.set(2, 7)//인덱스 2번 요소를 7로 교체
arr[0]=8//인덱스 0번 요소를 8로 교체
arr2d[2][1]=2//다차원 배열의 요소를 교체
println("size: ${arr.size}, arr[0]: ${arr[0]}, arr[2]: ${arr[2]}")
```

* 배열 내 요소 순환
```kotlin
for (i in 0..arr.size-1){
    println("arr[$i]=${arr[i]}")
}
```

* 배열 선언 및 접근 연습하기
```kotlin
package section2

import java.util.Arrays//Arrays를 사용하기 위해 자바 표준 라이브러리 임포트

fun main(){
    val arr=intArrayOf(1, 2, 3, 4, 5)
    println("arr: ${Arrays.toString(arr)}")
    println("power: ${arr.size}")
    println("sum(): ${arr.sum()}")

    //게터/세터에 의한 접근과 index 연산자 표기법
    println(arr.get(2))
    println(arr[2])

    arr.set(2, 7)
    arr[0]=8
    println("power: ${arr.size}, arr[0]: ${arr[0]}, arr[2]: ${arr[2]}")

    //루프를 통한 배열 요소의 접근
    for (i in 0..arr.size-1){
        println("arr[$i]=${arr[i]}")
    }

    println(arr.contains(4))
    println(4 in arr)
}
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/b8ae67c4-3069-4184-b31b-8073a0996ecf)

## [배열 관리 API]()
```kotlin
package section2

import java.util.Arrays

fun main(){
    val arr=intArrayOf(1, 2,3,4,5)

    //하나의 요소를 추가한 새 배열 생성
    val arr2=arr.plus(6)
    println("arr2: ${Arrays.toString(arr2)}")

    //필요한 범위를 잘라내 새 배열 생성
    val arr3=arr.sliceArray(0..2)//인자에 잘라낼 인덱스 범위를 지정
    println("arr3: ${Arrays.toString(arr3)}")

    //첫 번째와 마지막 요소 확인
    println(arr.first())
    println(arr.last())

    //요소 3의 인덱스 출력
    println("indexOf(3): ${arr.indexOf(3)}")

    //배열의 평균값 출력
    println("average: ${arr.average()}")

    //count에 의한 요소 개수
    println("count: ${arr.count()}")
}
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/e646b004-7c78-4283-8f46-e4368d7e1f8e)

![image](https://github.com/qlkdkd/OOP/assets/71871927/b73923f6-6062-40ae-a27b-ac89ce3d6248)

* 배열 요소 확인 메서드
```kotlin
println(arr.contains(4))
println(4 in arr)
```

## 배열의 순환
* 순환 메서드 사용
```kotlin
package section2

fun main(){
    var arr=intArrayOf(1, 2, 3, 4, 5)

    //forEach에 의한 요소 순환
    arr.forEach{element->print("$element")}
    println("\n")

    //forEachIndexed에 의한 요소 순환
    arr.forEachIndexed{i,e -> println("arr[$i]= $e")}
    println("\n")
    
    //Iterator 이용
    val iter: Iterator<Int> =arr.iterator()
    while(iter.hasNext()){
        val e=iter.next()
        print("$e")
    }
}
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/cfa178bc-29d1-4670-8145-5f668f36cb61)

* forEach: 요소 개수만큼 지정한 구문을 반복 실행
* forEachIndexed: 인덱스는 i로 요소는 e로 받아 화살표 표현식 오른쪽의 구문처리
* iterator(): forEach와 유사
    * hasNext(): 배열에서 참조할 다음 요소가 있는지 확인
    * next(): 다음 요소를 반환하는 메서드
 
## 배열의 정렬
* 정렬(sort)
    * 오름차순(ascending)으로 정렬하거나 내림차순(descending) 정렬
    * Array는 기본적인 정렬 알고리즘을 제공
* 정렬된 배열 반환
    * sortedArray(): 오름차순으로 정렬된 배열을 반환
    * sortedArrayDescending(): 내림차순으로 정렬된 배열을 반환
* 원본 배열에 대한 정렬 진행
    * sort(): 원본 그대로
    * sortDescending(): 원본 거꾸로
 
## [배열의 정렬 예제]()
```kotlin
package section2

import java.util.Arrays

fun main(){
    val arr=arrayOf(8, 4, 3, 2, 5, 9, 1)

    //오름차순, 내림차순으로 정렬된 일반 배열로 반환
    val sortedNums=arr.sortedArray()
    println("ACS: "+ Arrays.toString(sortedNums))

    val sortedNumsDesc=arr.sortedArrayDescending()
    println("DES: "+Arrays.toString(sortedNumsDesc))

    //원본 배열에 대한 정렬
    arr.sort(1, 3)//sort(fromIndex, toIndex)
    println("ORI: "+ Arrays.toString(arr))
    arr.sortDescending()
    println("ORIDEC: "+ Arrays.toString(arr))

    //List로 반환
    val listSorted: List<Int> =arr.sorted()
    val listDecs: List<Int> =arr.sortedDescending()

    println("LST: "+listSorted)
    println("LSTDEC: "+listDecs)
}
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/a55b8322-ff0e-4d20-a8fa-4c27be0ad041)

## [배열의 정렬: sortBy]()
* sortBy
```kotlin
inline fun <T, R: Comparable<R>> Array<out T>.sortBy(
    crossline selector:(T)->R?:Unit
)
```
    * selector 함수의 반환값의 정렬딘 순서로 배열 내 원소를 정렬
    
```kotlin
package section2

data class Product(val name: String, val price: Double)

fun main(){
    val products=arrayOf(
        Product("SnowBall", 870.0),
        Product("Smart Phone", 999.0),
        Product("Drone", 240.0),
        Product("Mouse", 333.55),
        Product("Keyboard", 125.99),
        Product("Monitor",1500.99),
        Product("Tablet", 512.99)
    )

    products.sortBy{it.price}
    products.forEach{println(it)}
    println()

    products.sortBy{it.name}
    products.forEach{println(it)}
    println()
}
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/6a571d68-f2e9-4d57-ae57-915b496d8594)
