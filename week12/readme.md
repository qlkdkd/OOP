# 컬렉션

# 컬렉션의 구조와 기본
## kotlin 컬렉션
* 컬렉션(collection): 자주 사용하는 기초적인 자료구조를 모아놓은 일종의 프레임워크
    * 자료구조: 어떻게 하면 효율적으로 데이터를 다룰 것인가에 초점을 맞춘 학문
* 컬렉션의 종류: List, Set, Map
* 불변형과 가변형
    * 가변형(mutable) 컬렉션: 객체에 데이터를 추가하거나 변경할 수 있음
    * 불변형(immutable) 컬렉션: 데이터를 한 번 할당하면 읽기 전용이 됨

### 컬렉션의 불변형 자료형 및 가변형 자료형 분류와 그에 따른 생성 헬퍼 함수
컬렉션|불변형(읽기 전용)|가변형
---|---|---
List|listOf|mutableListOf, arrayListOf
Set|setOf|mutableSetOf, hashSetOf, linkedSetOf, sortedSetOf
Map|mapOf|mutableMapOf, hashMapOf, linkedMapOf, sortedMapOf

## 컬렉션 인터페이스
![image](https://github.com/qlkdkd/OOP/assets/71871927/a6465274-1bb0-4671-973a-be2c0f37d2aa)
* Iterable 인터페이스: 컬렉션이 연속적인 요소를 표현할 수 있도록 함
```kotlin
public interface Iterable <out T>{
    public abstract operator fun iterator(): Iterator<T>
}
```
* Iterator: hasNext(), next()메서드를 가지고 요소를 순환
    * hasNext(): 읽을 요소가 있는지 확인
    * next(): 데이터를 반환
    * 형식 매개변수: 공변성을 제공하도록 out으로 선언됨
* Iterator로부터 확장된 Collection 인터페이스는 불변형: 여기서 확장된 Set와 List는 읽기 전용 컬렉션

* Collection 인터페이스의 멤버

멤버|설명
---|---
size|컬렉션의 크기
isEmpty()|컬렉션이 비어 있는 경우 true를 반환
contains(element: E)|특정 요소가 있다면 true를 반환
containsAll(element: Collection<E>)|인자로 받아들인 Collection이 있다면 true를 반환

## MutableCollection 인터페이스
* MutableCollection 인터페이스: 가변형 컬렉션을 지원하기 위해 준비된 인터페이스. 요소를 추가하거나 제거하는 등의 기능 수행
* MutableCollection 인터페이스의 멤버 메서드

멤버 메서드|설명
---|---
add(element: E)|인자로 전달받은 요소를 추가하고 true를 반환하며, 이미 요소가 있거나 중복이 허용되지 않으면 false를 반환
remove(element: E)|인자로 받은 요소를 삭제하고 true를 반환하며, 삭제하려는 요소가 없다면 false를 반환한다.
addAll(element: Collection<E>)|컬렉션을 인자로 전달받아 모든 요소를 추가하고 true를 반환하며, 실패 시 false를 반환한다.
removeAll(element: Collection<E>)|컬렉션을 인자로 전달받아 모든 요소를 삭제하고 true를 반환하며, 실패 시 false를 반환한다.
retainAll(element: Collection<E>)|인자로 전달받은 컬렉션의 요소만 보유한다. 성공 시 true를 반환하고, 실패 시 false를 반환한다.
clear()|컬렉션의 모든 요소를 삭제한다.

---

# List의 활용
## List
* List: 순서에 따라 정렬된 요소를 가지는 컬렉션(가장 많이 사용되는 컬렉션 중 하나)
* 불변형 리스트 생성: `listOf()`함수 사용
* 가변형 리스트 생성: `arrayListOf()`, `mutableListOf()` 함수 사용
* 인자는 원하는 만큼의 가변 인자를 가지도록 `varang`로 선언 가능

* listOf()
```kotlin
public fun <T> listOf(varang elements: T): List<T>
```

* arrayListOf()
```kotlin
public fun <T> arrayListOf(varang elements: T): ArrayList<T>
```

* mutableListOf()
```kotlin
public fun <T> mutableListOf(varang elements: T): MutableList<T>
```

## 불변형 리스트의 사용
### [listOf()함수 사용]()
```kotlin
package section1

fun main(){
    var numbers: List<Int> =listOf(1, 2, 3, 4, 5)
    var names: List<String> =listOf("one", "two", "three")
    for(name in names){
        println(name)
    }

    for(num in numbers)print(num)//한 줄에서 처리하기
    println()//내용이 없을 때는 한 줄 내리는 개행
}
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/cf8ac335-acea-45dd-8243-5835588bcc83)

## 컬렉션 반복하기
* 배열과 마찬가지로 List같은 컬렉션에서 요소를 순환하기 위해 for문을 사용할 수 있음
```kotlin
package section1

fun main(){
    var fruits=listOf("apple", "banana", "kiwi")

    //for와 in을 사용한 출력
    for (item in fruits){
        println(item)
    }
    println()

    //인덱스를 사용한 출력
    for (index in fruits.indices){//인덱스 지정
        println("fruits[$index]=${fruits[index]}")
    }
    println()

    // 나머지 연산자를 사용하여 인덱스 0번과 짝수번만 골라내기
    for (index in fruits.indices){
        if(index%2==0)
            println("fruits[$index]=${fruits[index]}")
    }
}
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/c005cad9-4bc5-4aac-97b6-15e9b82da183)

## 기타 리스트 생성 함수
### emptyList()함수
* 빈 리스트 생성
```kotlin
val emptyList: List<String> =emptyList<String>()
```

### listOfNotNull()함수
* null을 제외한 요소만 반환
```kotlin
val nonNullsList: List<Int> =listOfNotNull(2, 45, 2, null, 5, null)
println(nuoNullsList)
```

## 리스트의 주요 멤버 메서드
멤버 메서드|설명
---|---
get(index: Int)|특정 인덱스를 인자로 받아 해당 요소를 반환한다.
indexOf(element: E)|인자로 받은 요소가 첫 번째로 나타나는 인덱스를 반환하며, 없으면 -1을 반환
lastIndexOf(element: E)|인자로 받은 요소가 마지막으로 나타나는 인덱스를 반환하고, 없으면 -1을 반환
listIterator()|목록에 있는 iterator을 반환
sublist(fromIndex: Int, toIndex: Int)|특정 인덱스의 from과 to 범위에 있는 요소 목록을 반환

## 리스트의 기본 멤버 메서드 이용해 보기
[ListMethods.kt]()
```kotlin
fun main(){
    var names: List<String> =listOf("one", "two", "three")

    //list의 기본 메서드
    println(names.size)
    println(names.get(0))
    println(names.indexOf("three"))
    println(names.contains("two"))
}
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/c9acd8b6-085d-40b5-8537-552fcebbd9a4)

## 가변형 리스트 생성하기
### arrayListOf()함수
    * 가변형 헬퍼 함수를 사용하면 손쉽게 요소를 추가하거나 삭제할 수 있다.
    * arrayListOf()는 가변형 리스트를 생성하지만 반환자료형은 자바의 ArrayList
* arrayListOf()함수의 원형
```kotlin
public fun<T> arrayListOf(varang elements: T): ArrayList<T>
```

[ArrayList.kt]()
```kotlin
package section1

import java.util.*

fun main(){
    //가변형 리스트를 생성하고 자바의 ArrayList로 반환
    val stringList: ArrayList<String> =arrayListOf<String>("Hello", "Kotlin", "Wow")
    
    stringList.add("Java")//추가
    stringList.remove("Hello")//삭제
    println(stringList)
}
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/08c07e68-f163-470a-a0a0-295831b46268)

### mutableListOF() 함수
* 요소의 추가, 삭제 또는 교체를 위해 mutableListOf()를 통해 MutableList형으로 가변형 리스트 생성
```kotlin
public fun <T> mutableListOf(varang elements: T): MutableList<T>
```

[mutableList.kt]()
```kotlin
package section1

fun main(){
    val mutableList: MutableList<String> =mutableListOf<String>("Kildong", "Dooly", "Chelsu")

    mutableList.add("Ben")
    mutableList.removeAt(1)//인덱스 1 삭제
    mutableList[0]="Sean"//인덱스 0 변경
    println(mutableList)

    //자료형의 혼합
    val mutableMixed=mutableListOf("Android", "Apple",5, 6, 'x')
    println(mutableMixed)
}
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/653a39f0-7e9d-493e-a2e8-8bfc95ce3570)

## 불변형 리스트의 변경
* toMutableList() 사용
```kotlin
package section1

fun main(){
    //불변형 리스트를 가변형으로 변환
    val names: List<String> =listOf("one", "two", "three")

    val mutableNames=names.toMutableList()//새로운 가변형 리스트가 만들어짐
    mutableNames.add("four")
    println(mutableNames)
}
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/5f47ab79-2d81-4381-adbb-dd07ecd6a80c)

## 리스트와 배열의 차이
* Array 클래스에 의해 생성되는 배열 객체는 내부구조상 고정된 크기를 가짐
* 코틀린의 `List<T>`와 `MutableList<T>는 인터페이스로 설계됨
    * 이것을 하위에서 특정한 자료구조로 구현
    * 따라서 성능 달라짐
* `List<T>`는 `Array<T>`처럼 메모리가 고정된 것이 아니기 때문에 자료구조에 따라 늘리거나 줄이는 것이 가능

* 또 다른 차이점: Array<Int>는 Array<Number>과 무관하지만 List<T>는 공변성이기 때문에 List<Int>가 List<Number>에 저장될 수 있다.

---

# Set의 활용

## 세트 생성
* 개념
    * 정해진 순서가 없는 요소들의 집합(set)
    * 집합의 개념이기 때문에 동일한 요소를 중복해서 가질 수 없음
* 생성 헬퍼 함수
    * 불변형 세트: `setOf()`
    * 가변형 세트: `mutableSetOf()`

## [불변형 세트의 초기화]()
```kotlin
package section2

fun main(){
    val mixedTypeSet=setOf("Hello", 5, "world", 3.14, 'c')
    val intSet: Set<Int> =setOf(1, 5, 5)//자료형 제한: 정수형만 초기화

    println(mixedTypeSet)
    println(intSet)
}
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/05e5fbd1-a899-42e0-a4b8-51b6665db84e)

## [가변형 세트의 초기화]()
```kotlin
package section2

fun main(){
    //가변형 세트 정의하기
    val animals=mutableSetOf("lion", "dog", "cat", "python", "hippo")
    println(animals)

    //요소의 추가
    animals.add("dog")//이미 존재하므로 변화 없음
    println(animals)

    //요소의 삭제
    animals.remove("python")
    println(animals)
}
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/45e99969-1b5d-45dc-b9c5-71d2afec7ca5)

## 세트의 여러가지 자료구조
* hashSetOf() 함수
    * 해시 테이블에 요소를 저장할 수 있는 자바의 해시세트 컬렉션을 만든다.
    * 
