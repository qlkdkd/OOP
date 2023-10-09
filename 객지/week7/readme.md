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

## 가시성 지시자(Java)
![image](https://github.com/qlkdkd/OOP/assets/71871927/fc9dde32-bd4d-44c5-9df2-888748d8b972)

## 가시성 지시자(종합)
![image](https://github.com/qlkdkd/OOP/assets/71871927/5bf3c5af-2a93-4c95-9fc2-5f344fc3bbd5)

## 가시성 지시자: private(공통)-멤버 수준
![image](https://github.com/qlkdkd/OOP/assets/71871927/911f52eb-e15d-40cb-b715-f1f6fe510732)

## 가시성 지시자: private(Kotlin)-클래스 수준
![image](https://github.com/qlkdkd/OOP/assets/71871927/b8341d4e-f2ac-46f9-9ec9-db8ff238a958)

## 가시성 지시자: internal(Kotlin)
![image](https://github.com/qlkdkd/OOP/assets/71871927/a7b37f47-baf2-4168-8177-8772905c14bd)
![image](https://github.com/qlkdkd/OOP/assets/71871927/da6c11f9-14f9-401f-b3d8-772043ec1c4b)
![image](https://github.com/qlkdkd/OOP/assets/71871927/9833ac7e-c999-4562-bec8-f2a9dbaae7ae)
