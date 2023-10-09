# 정보 은닉과 캡슐

## 학습목표
* 정보은닉과 캡슐화의 개념을 이해한다.
* 가시성 지시자를 통한 접근 제어를 이해한다.
* 프로퍼티의 접근 방법을 이해한다.

## 정보 은닉(Information Hiding)
### **정보 은닉**은 *객체 내부의 정보를 다른 객체로부터 감추기* 위해서 객체 내부 정보를 반영하지 않는 *추상화된 인터페이스*를 정의하는 소프트웨어 설계 원칙이다.
* **객체 내부 정보를 은닉함**으로써, 보안을 높일 수 있고 소프트웨어의 유지 보수성을 향상시킨다.
* 객체 내부 정보
    * 구현 방식
    * 데이터 표현 방식
 ![image](https://github.com/qlkdkd/OOP/assets/71871927/3343714e-bf66-4be0-a9ab-71d9c09dc7f7)

## 정보 은닉 사례
![image](https://github.com/qlkdkd/OOP/assets/71871927/2bbd49ce-37b1-44e4-a1d4-cdcc1e297453)
JVM은 하부 운영체제 및 하드웨어 플랫폼의 세부사항을 응용프로그램에 숨김

## 캡슐화란?
### *캡슐화*는 정보 은닉 원칙을 구현하는 객체지향 매커니즘
* 관련된 데이터와 함수를 하나의 프로그래밍 단위(클래스)로 묶고, 가시성(혹은 접근 제어) 지시자 (public, private) 사용하여 외부에서 데이터와 함수의 접근을 제어한다.
![image](https://github.com/qlkdkd/OOP/assets/71871927/fd4e1699-62ae-4449-b9c7-84394c1ae89b)

## 정보 은닉 및 캡슐화 사례: 은행계좌
```Kotlin
class Account()
val Id
val balance
fun withdraw(amount: Int): Void{
   if(amount>0 && balance>=amount){
      balance-=amount
      println("$amount 웡 출금되었습니다. 총 잔액: $balance 원")
   }
   else{
      println("잔액이 부족하거나 유효하지 않은 출금액입니다.")
   }
}
fun deposit(amount: Int): Void

fun main(){
   val acc=Account()
   acc.balance=1000//접근 불가
}
```
---

# 가시성(접근제어) 지시자

## 가시성 지시자
가시성 지시자|Kotlin|Java
---|---|---
private|동일한 파일 내의 클래스, 함수, 프로퍼티, 인터페이스에서 접근 가능|동일한 클래스 내에서 접근 가능
packcage-private(Java 기본값)|지원 안함|동일 패키지 내에서 접근 가능
internal|동일 모튤 내에서 접근 가능|지원 안함
Public(Kotlin 기본값)|어디서든 접근 가능

## 가시성 지시자(Kotlin)
![image](https://github.com/qlkdkd/OOP/assets/71871927/7fab9cb8-7896-415a-a966-355d95be2056)
[코틀린 코드](https://github.com/qlkdkd/OOP/blob/main/%EA%B0%9D%EC%A7%80/week7/week7_Lecture/src/main/kotlin/section1/privateVisibility/commom/PrivateMemberTest.kt)

## 가시성 지시자(Java)
![image](https://github.com/qlkdkd/OOP/assets/71871927/fc9dde32-bd4d-44c5-9df2-888748d8b972)

## 가시성 지시자(종합)
![image](https://github.com/qlkdkd/OOP/assets/71871927/5bf3c5af-2a93-4c95-9fc2-5f344fc3bbd5)

## 가시성 지시자: private(공통)-멤버 수준
![image](https://github.com/qlkdkd/OOP/assets/71871927/911f52eb-e15d-40cb-b715-f1f6fe510732)

## 가시성 지시자: private(Kotlin)-클래스 수준
![image](https://github.com/qlkdkd/OOP/assets/71871927/b8341d4e-f2ac-46f9-9ec9-db8ff238a958)
[코드](https://github.com/qlkdkd/OOP/blob/main/%EA%B0%9D%EC%A7%80/week7/week7_Lecture/src/main/kotlin/section1/privateVisibility/kotlin/PriviteClassTest.kt)
## 가시성 지시자: internal(Kotlin)
![image](https://github.com/qlkdkd/OOP/assets/71871927/a7b37f47-baf2-4168-8177-8772905c14bd)
[코드보기](https://github.com/qlkdkd/OOP/blob/main/%EA%B0%9D%EC%A7%80/week7/week7_Lecture/src/main/kotlin/section1/internalVisibility/InternalVisibility.kt)
![image](https://github.com/qlkdkd/OOP/assets/71871927/da6c11f9-14f9-401f-b3d8-772043ec1c4b)
[코드보기](https://github.com/qlkdkd/OOP/blob/main/%EA%B0%9D%EC%A7%80/week7/week7_Lecture/src/main/kotlin/section1/internalVisibility/internalTestOtherFile.kt)
![image](https://github.com/qlkdkd/OOP/assets/71871927/9833ac7e-c999-4562-bec8-f2a9dbaae7ae)
![image](https://github.com/qlkdkd/OOP/assets/71871927/6f9eb657-8761-49df-92ed-30e6bae14398)
[코드보기](https://github.com/qlkdkd/OOP/blob/main/%EA%B0%9D%EC%A7%80/week7/week7_Lecture/src/main/kotlin/section1/internalVisibility/internalTestOtherModule.kt)

# 프로퍼티의 접근
## Java에서 필드의 접근
### Java
* Java의 필드(멤버변수)
   * 변수 선언만을 정의
   * Java에서는 private필드를 다른 클래스에서 접근하기 위해서는 이에 대한 접근 메서드(게터/세터)를 만들어야 함
![image](https://github.com/qlkdkd/OOP/assets/71871927/29bc849d-49f0-467f-902b-52b99d0feb38)
## Java의 Person 클래스와 접근 메소드 예제: PersonTest.java
[코드 보기]()

## Kotlin에서 프로퍼티의 접근
* Kotlin의 프로퍼티: 변수 선언과 함꼐 기본적인 접근 메소드가 내부적으로 표현됨
```java
public class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name=name;
        this.age=age;
    }
    public String getName(){return name;}

    public void setName(String name){
        this.name=name;
    }

    public int getAge(){return age;}
    public void segAge(int age){
        this.age=age;
    }
}
```
->
```kotlin
class Person(var name: String, var age: Int)

fun main(){
   val p1=Person("kildong", 30)
   p1.name="Dooly"
   println(p1.name)
}
```

## 기본 접근자 메소드(게터와 세터) 직접 지정하기
```kotlin
var 프로퍼티이름[: 프로퍼티 자료형][=프로퍼티 초기화]
   [get(){게터 본문}]
   [set(value){세터 본문}]
var 프로퍼티이름[: 프로퍼티자료형][=프로퍼티 초기화]
   [get(){게터 본문}]
```

```kotlin
var name: String=_name{
   get()=field
   set(value){//세터의 매개변수로 value 대신 다른 이름 사용 가능
      field=value
   }
}
val id: Int=_id
   get()field//지원 필드(Backing Field)
```

* `val`로 선언하는 경우에는 게터(getter)와 세터(setter) 둘다 선언 가능
* `var`로 선언하는 경우에는 게터만 선언 가능
* 게터(getter)
   * get이라는 이름의 파라미터를 포함하지 않은 메서드 형태로 선언
   * 반드시 프로퍼티와 **동일한 타입의 데이터를 리턴**
* 세터(setter)
   * set이라는 이름의 파리미터 1개를 포함하는 메서드 형태로 구현한다. **파라미터의 데이터**타입은 프로퍼티와 동일하며 명시적으로 선언하지 않는다.
 
## 기본 게터와 세터 지정 예제-[NormalGetterSetter.kt]()
## 지원 필드(Backing field)를 반드시 사용해야 하는가?
![image](https://github.com/qlkdkd/OOP/assets/71871927/64c58053-d757-4f3e-89dc-5c63c65a9108)

## 커스텀 게터와 세터 사용하기-[CustomGetterSetter.kt]()

## 지원 프로퍼티(Backing Property)
### 지원 필드(Backing Field)만으로는 접근 메서드(게터/세터)의 구현의 한계를 느낄 때, 지원 프로퍼티(Backing Property)를 직접 사용하여 접근 메서드 구현

* 사례 1. 프로퍼티 값을 외부에서 직접 조작하거나 접근하는 것을 제한
```kotlin
class Myclass{
   private var )myProperty: Int=0

   var myProperty: Int
      get()=_myProperty//게터에서는 Backing property의 값을 반환
      set(value){
         _myProperty=value=value//세터에서는 Backing property에 값을 할당
      }
}
```
* 사례 2. 프로퍼티와 다른 타입을 반환하고 싶을 때
```kotlin
private var _results; MutableList<List<String>>=mutableListOf()

val results: List<List<String>>
   get()=_results//게터에서는 Backing Properlty의 타입 (MutableList)을 List 타입으로 변환하여 반환
```

지원 프로퍼티 사용 예제-[CustomSetterSetterBackingProperty.kt]()
