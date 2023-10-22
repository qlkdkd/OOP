# 프로그래밍 기초1
## 프로젝트,모듈, 파일, 클래스의 관계
### 프로젝트와 패키지
* 코틀린에서는 프로젝트는 모듈, 패키지, 파일로 구성됨
* 코틀린 프로젝트를 여행으로 비유하면 모듈은 목적지, 패키지는 여행용 가방, 파일은 가방속에 넣은 짐이라고 할 수 있음
* $프로젝트 \supset 모듈 \supset 패키지 \supset 파일$
![image](https://github.com/qlkdkd/OOP/assets/71871927/bb46a0c7-f7d5-4bff-9d08-5d4db8dcb23b)

* HelloKotlin프로젝트(HelloKotlin모듈, OtherModule모듈)
    * HelloKotlin모듈(defalut패키지, com.example.edu패키지)
         * com.example.edu패키지(Person.kt파일, Control파일)
     
* 패키지를 만들어야 하는 이유: 같은 패키지에 같은 이름의 파일을 생성하면 오류가 발생하지만, 다른 패키지에 각각 만들면 오류가 발생하지 않는다.
* 

## 프로젝트, 패키지,파일, 클래스의 관계: 코틀린 프로젝트 vs 자바 프로젝트
### 패키지와 디렉토리 구조의 관계
* 자바 프로젝트 패키지는 디렉토리 구조와 일치되어야 함
* 코틀린 프로젝트 패키지는 디렉토리 구조와 일치될 필요가 없음
### default 패키지
* 파일 첫 줄에 패키지 이름의 선언이 없는 경우, default 패키지로 인식
* 파일이 패키지 폴더 안에 들어 있어도 패키지 이름을 선언하지 않으면 default 패키지에 포함된 것으로 인식
### 파일과 클래스
* 코틀린 프로젝트 클래스 1개가 동일한 이름의 파일에 정의된 경우, Project창 화면에서 .kt 확장자가 빠진 클래스 이름만 보임
* 자바 프로젝트 public 클래스는 동일한 이름의 파일에 정의되어야

![image](https://github.com/qlkdkd/OOP/assets/71871927/61fc6e41-9f67-40e4-8de2-1f4912ae5385)

## 기본 패키지(코틀린 표준 라이브러리)
* 기본 패키지란 코틀린으로 프로그램을 만들 때 자주 사용한 클래스와 함수 등을 미리 만들어 놓은 것
* 패키지는 import 키워드로 선언해야 사용할 수 있다.
* 기본 패키지는 이름에 걸맞게 import키워드로 패키지를 선언하지 않아도 바로 사용할 수 있다.

패키지 이름|설명
---|---
kotlin.*|Any, Int, Double 등 코어 함수와 자료형
Kotlin.text.*|문자와 관련된 API
Kotlin.sequences.*|컬렛션 자료형의 하나로 반복이 허용되는 개체를 열거
Kotlin.ranges.*|if문이나 for문에서 사용할 범위 관련 요소
Kotlin.io*|입출력 관련 API
Kotlin.collections.*|List, Set, Map 등의 컬렉션
Kotlin.annotation.*|에노테이션 관련 API

## 패키지의 사용

### import 구문
```kotlin
package week2.section1

import kotlin.math.PI
import kotlin.math.abs

fun main() {
    val intro: String = "안녕하세요!"
    val num: Int = 20

    println(PI)
    println(abs(-12.6)) // 절댓값을 위해 사용하는 abs( ) 함수

    println("intro: $intro, num: $num")
}
```
* 위 코드에서는 PI와 abs를 임포트함(PI: 원주율, abs(): 괄호 안의 값을 절댓값으로 변환
* PI와 abs는 기본 패키지에 포함되지 않은 상수와 함수. 이 둘을 사용하기 위해 kotlin.math패키지의 PI와 abs를 임포트해옴
* `import kotlin.math.*`를 이용하여 여러 요소들을 한꺼번에 임포트할 수도 있다.
* 코틀린 프로젝트 다른 패키지에서 정의된 동일한 이름의 클래스를 사용해야하는 경우에는, **as 키워드**로 사용할 이름을 변경

```kotlin
package week2.section1

import com.example.edu.Person as User

fun main() {

    val user1 = User("Kildong", 30) // com.example.edu의 Person이 User로 대체
    val user2 = Person("A123", "Kildong") // 이 파일 내에 있는 Person 클래스의 객체 생성

    println(user1.name)
    println(user1.age)

    println(user2.id)
    println(user2.name)
}

class Person(val id: String, val name: String)
```

---
## 변수와 자료형
* 변수: 프로그램 내에서 값을 저장하는 공간으로서 이름이 부여된 것

![image](https://github.com/qlkdkd/OOP/assets/71871927/6e570bb8-2da6-4378-864d-f68e6334d055)

* 자료형: 변수가 가질 수 있는 값의 종류 및 범위를 정의한 것
   * 정수형: Byte, Short, Int, Long
   * 실수형: Float, Double
   * 문자형: Char
   * 논리형: Boolean
 
## 변수 선언
* 변수를 선언하려면 val, var을 사용해야 함
   * val로 변수를 선언하면 최초로 지정한 변수의 값으로 초기화하고, 더이상 바꿀 수 없는 읽기 전용 변수로 저장된다.
   * var로 변수를 선언하면 최초로 지정한 변수의 초기값이 있더라도 값을 바꿀 수 있다.
![image](https://github.com/qlkdkd/OOP/assets/71871927/966b1b79-9815-424e-946d-ba43ac3a321d)

 
![image](https://github.com/qlkdkd/OOP/assets/71871927/3bcaea06-0f00-4665-8817-50636078e9db)
* username: 변수 이름, 앞에 val로 선언되었으므로 변경되지 않는 값이다.
* : String: 변수가 String 자료형으로 선언됨
* "Kildong": 변수에 할당된 값

* 코틀린은 자료형을 지정하지 않아도 알아서 자료형을 추론할 수 있다.
* 그러나 자료형을 지정하지 않을 땐 변수값을 지정해야 한다. -> 변수값이 없으면 자료형을 추론할 수 없음

#### 변수 선언 예제
```kotlin
val username="kildong""//자료형을 추론하여 String으로 결정
val username//자료형을 지정하지 않은 변수는 사용할 수 없다.
val init: Int//사용전 혹은 생성자 시점에서 init 변수를 초기화해야함
val number=10//number 변수는 Int 형으로 추론
```

## 변수 이름 작성 규칙 및 카멜 표기법
### 변수 이름 작성 규칙
* 변수 이름은 숫자로 시작하면 안된다(예: 123abc)
* 키워드는 사용할 수 없다.(예: while, if 등)
* 의미있는 단어를 사용하여 이름을 작성하는 것이 좋다.
* 여러 단어를 사용하여 변수 이름을 작성할 때는 카멜 표기법을 사용하는 것이 좋다.

### 카멜 표기법
* 여러 단어로 이루어진 변수 혹은 클래스 이름을 지정할 때 첫 번째 글자는 소문자(변수이름) 또는 대문자(클래스 이름)으로, 나머지 단어의 첫글짜는 대문자로 표시

## 자료형: 기본형 vs 참조
### 기본형(Primative Data Type)
* 가공되지 않은 순수한 자료형
* 예: Java: int, long, float 등

### 참조형(Reference Type)
* 동적 공간에 데이터를 둔 다음 이것을 참조하는 자료형
* 코틀린에서는 참조형 자료형만을 사용
* (예: Kotlin: Int, Long, Float 등, Java: String, Date)

* 자바에서는 기본형 자료형과 참조형 자료형 모두 사용
* 코틀린에서 참조형으로 선언한 변수는 성능 최적화를 위해 코틀린 컴파일러가 자동적으로 최적화한 후 기본형이 사용

### 동작 원리
```Java
int a=77;//기본형
Person person=new Person();//객체 참조
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/94c238a2-d290-45fe-aa29-0f96fabedb0c)
* 기본형으로 선언한 변수 a는 주로 임시 메모리인 스택에 저장되며 값이 저장된 메모리의 크기도 고정되어 있다.
* 참조형은 스택에 값이 아닌 주소가 있다. 참조형의 실제 객체는 동적 메모리인 힙에 저장된다.

## 자료형(정수형)
![image](https://github.com/qlkdkd/OOP/assets/71871927/4c76f755-4826-4ee2-ad9d-8c5c74c378e5)
### 예시
```kotlin
//자료형 생략
val num05=127//Int형으로 추론
val num06=-32786//Int형으로 추론(Short의 최솟값이기도 함)
val num07=2147483647//Int형으로추론
val num08=9883372036854775807//Long형으로 추론

//접미사 접두사 사용
val exp01=123//Int형으로 추론
val exp02=123L//Long형으로 추론
val exp03=0x0F//접두사 0x를 사용해 16진 표기가 사용된 Int형으로 추론
val exp04=0b00001011//접두사 0b를 사용해 2진 표기가 사용된 Int형으로 추론

//작은 값의 사용
val exp08: Byte=127//명시적으로 자료형을 지정(Byte)
val exp09=23767//명시적으로 자료형을 지정하지 않으면 Short형 범위의 값도 Int형으로 추론
val exp10: Short=32767//명시적으로 자료형을 지정(Short)
```

## 자료형(실수)
![image](https://github.com/qlkdkd/OOP/assets/71871927/491c3ba7-3d53-4498-9b36-483ec8703702)
### 자료형 생략 및 추론
```kotlin
val exp01=3.14//Double형으로 추론(기본)
val 0xp02=3.14F//식별자 F에 의해 Float형으로 추론
```

## 프로그램 예제: 정수형과 실수 자료형의 최솟값과 최댓값 출력하기
```kotlin
package week2.section2

fun main() {
    println("Byte min: " + Byte.MIN_VALUE + " max: " + Byte.MAX_VALUE)
    println("Short min: " + Short.MIN_VALUE + " max: " + Short.MAX_VALUE)
    println("Int min: " + Int.MIN_VALUE + " max: " + Int.MAX_VALUE)
    println("Long min: " + Long.MIN_VALUE + " max: " + Long.MAX_VALUE)
    println("Float min: " + Float.MIN_VALUE + " max: " + Float.MAX_VALUE)
    println("Double min: " + Double.MIN_VALUE + " max: " + Double.MAX_VALUE)
}
```
```
결과
Byte min: -128 max: 127
Short min: -32768 max: 32767
Int min: -2147483648 max: 2147483647
Long min: -9223372036854775808 max: 9223372036854775807
Float min: 1.4E-45 max: 3.4028235E38
Double min: 4.9E-324 max: 1.7976931348623157E308
```

## 자료형(논리형, 문자형)
### 논리형
* 논리 자료형은 참, 거짓을 표현하며 조건 검사할때 많이 사용됨
* 코틀린에서의 논리 자료형은 true, false임
* 논리 자료형은 흔히 검사 용도의 변수를 만들 때 사용함

![image](https://github.com/qlkdkd/OOP/assets/71871927/35f4c8d1-4a88-458b-ad45-24e0360c18de)

### 문자형
* 문자 자료형(Char)은 문자를 표현하기 위해 사용하며 문자 자료형 값은 작은따옴표(')로 감싸 표현함
* 컴퓨터는 문자 자료형 값을 저장할 때 문자 세트(아스키코드표, 유니코드표)를 참고하여 번호로 저장함(예: 컴퓨터는 문자 'A'를 65로 이해함)
* 문자형 자료를 선언한 다음, 문자 자료형에 숫자를 더하거나 빼는 방식으로 다른 문자를 표현할 수 있음
* 문자형 자료에는 1개의 문자만 저장할 수 있음. 만약 여러 문자가 나열된 문자열을 저장하고 싶다면 '문자열 자료형'을 사용하면 됨

![image](https://github.com/qlkdkd/OOP/assets/71871927/14efad80-01d5-4f26-9dcb-386d14aaa7c0)


## 자료형(문자열 자료형)
* 문자열 자료형(String): 문자 자료형에서 더 나아가 여러 문자를 배열하여 저장할 수 있는 자료형
* 사용 이유: 문자열 자료형은 기본형에 속하지 않는 배열형태로 되어 있는 특수한 자료형

```kotlin
package chap02.section2

fun main() {
    var str1: String = "Hello" // 명시적 선언
    var str2 = "World" // str2는 String으로 추론
    var str3 = "Hello" // 동일한 String Pool을 가리킴

    println("str1 === str2: ${str1 === str2}")
    println("str1 === str3: ${str1 === str3}")
}
```
```결과
str1===str2: false
str1===str3: true
```

![image](https://github.com/qlkdkd/OOP/assets/71871927/16106703-0488-4e40-98a2-2b94ee7d7fd7)

* str1과 str3은 힙 영역의 String Pool이라는 공간에 문자열인 "Hello"를 저장해 두고 이 값을 str1, str3이 참조하도록 만듬
* 결과적으로 str3의 주소는 str1과 동일하므로 참조 비교를 위해 === 연산자를 사용하면 true가 반환됨

## 표현식과 기호 $를 사용하여 문자열 출력하기
* println을 사용하여 출력할 때 문자열 안에 $기호와 함께 변수나 표현식을 사용하면 됨
* 변수가 아니라 표현식을 문자열에 포함시키려면 중괄호({})를 사용하면 됨

---

# 자료형 변환과 비교
## 자료형 변환
### 자료형 불일치
* 변수의 자료형과 일치하지 않는 값이 대응되는 경우

![image](https://github.com/qlkdkd/OOP/assets/71871927/d5ccfee5-bd00-4318-adcb-80607f1c2fe2)

### Java에서의 자료형 변환
* 명시적 형변환: 형변환하고자 하는 변수나 리터럴의 앞에 변환하고자 하는 타입을 괄호와 함께 작성
* 자동 형변환: 작은 자료형에서 큰 자료형으로 컴파일시 자동적으로 자료형이 변환됨

```Java
int x=(int)3.14;//double형 값인 3.14를 명시적으로 int형을 변환하면, 값의 손실이 발생함
int a=1;
double b=a;//a에 할당된 1이 자동으로 int형에서 double형으로 변환됨
```

### kotlin에서의 자료형 변환
* 명시적 형변환: 자료형 변환 메서드를 이용
   * toByte(): Byute
   * toShort(): Short
   * toInt(): Int
   * ...

```kotlin
val x: Int= 3.14.toInt()//Double형 값인 3.14를 자료형 변환 메서드를 이용하여 Int형으로 변환
``` 
* 자료형이 다른 변수에 값을 할당하면, 자동형 변환이 되지 않고 자료형 불일치 오류를 발생시킨다.

```kotlin
val a: Int=1
val b: Double=a//자료형 불일치 오류 발생
```

## 자료형 검사와 스마트캐스트(Kotlin)

### 자료형 검사
* 코틀린 is연산자 이용
* 자바 instanceof연산자 이용

### 스마트캐스트
* is연산자는 변수의 자료형을 검사한 다음 그 변수를 해당 자료형으로 자동 변환

```kotlin
val str="GeekforGeeks"
if(str is String){//자료형 검사
   println("length of String"+str.length)//스마트캐스트
}
```

```Java
Object ob="GeeksforGeeks"
if(ob instanceof String){
   String str=(String)ob;//명시적 형변환

   System.out.println("length of String"+str.length));/
}
```
