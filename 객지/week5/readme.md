# week5. 클래스와 객체1
## Section1
### 절차지향적 소프트웨어 개발
* *하향식 설계*(Top Down Design) - 단계적 상세화(Stepwise Refinement)
* *프러시저*(Procedure) 혹은 *함수*(Function)를 기반으로 프로그램을 구성
* *데이터 공유*(전역변수)
![image](https://github.com/qlkdkd/OOP/assets/71871927/4f47dbcb-3548-4f63-965a-124f3511dc57)

* 사례-GuiFigureApp개발 요구사항
  * GUI에 세 개의 도형이 있는데 사용자가 어떤 도형을 클릭하면 그 *도형을 회전* 시키고 *각 도형마다 정해진 AIF 사운드 파일을 재생*한다.
  
  ![image](https://github.com/qlkdkd/OOP/assets/71871927/3f505821-b71c-4bd8-9f0b-ee401e3936d3)

### 초기 프로그램
![image](https://github.com/qlkdkd/OOP/assets/71871927/d1e17d62-6789-4976-83ad-b11e394b53f3)

[구현 코드_ 도형프로그램](https://github.com/qlkdkd/OOP/blob/main/%EA%B0%9D%EC%A7%80/week5/week5_Lecture/src/main/kotlin/section1/procedural/init/GuiFigureApp.kt)

* 프로그램 변경 사항
  * 새로운 도형(아메바) 추가
    * 아메바 도형의 *회전 중심은 도형의 한쪽 끝*
    * 아메바 도형의 사운드는 *.hif형식*
   
[구현 코드_아메바 추가](https://github.com/qlkdkd/OOP/blob/main/%EA%B0%9D%EC%A7%80/week5/week5_Lecture/src/main/kotlin/section1/procedural/revision/GuiFigureApp_plusAmeba.kt)

### 절차지향 개발의 장단점

* 장점
 * 복잡한 문제를 하향식으로 분해하면서 해결하기 용이하다.
 * 프로그램의 실행 흐름에 따라 프로그램의 구조를 파악하기 용이하다.

* 단점
 * *데이터의 세부 사항이 여러 함수에 노출*되어 있어, *데이터의 변경이 여러 함수에 영향*을 줄 수 있다.
 * *데이터와 함수가 분리되어 독립적으로 모델링*되므로, 데이터와 함수의 일부가 함께 재사용될 경우에 재사용될 코드가 프로그램의 여러 부분에 흩어져 있어서 *재사용하기가 용이하지 않다.*


## 객체지향 소프트웨어 개발
* **상향식 설계**(Bottom Up Design)
* **객체(Object)** 를 기반으로 프로그램을 구성
* **데이터 캡슐화** - 데이터와 관련된 함수를 묶어 객체에 정의하고, 객체 내부의 데이터를 외부 객체에서 직접 접근하는 것을 제한\

  ![image](https://github.com/qlkdkd/OOP/assets/71871927/029bfe93-501a-4c97-84a1-282404b11566)

### GUIFigureApp 객체지향 설계(초기 설계)
![image](https://github.com/qlkdkd/OOP/assets/71871927/98c1c8f7-8428-4cb9-83df-3c5c6ec4cc8b)

[GUIFigureApp.kt]
(https://github.com/qlkdkd/OOP/tree/main/%EA%B0%9D%EC%A7%80/week5/week5_Lecture/src/main/kotlin/section1/objectoriented/init)

[GUIFigureApp_Circle](https://github.com/qlkdkd/OOP/blob/main/%EA%B0%9D%EC%A7%80/week5/week5_Lecture/src/main/kotlin/section1/objectoriented/init/Circle.kt)

[GUIFigureApp_Rectangle](https://github.com/qlkdkd/OOP/blob/main/%EA%B0%9D%EC%A7%80/week5/week5_Lecture/src/main/kotlin/section1/objectoriented/init/Rectangle.kt)

[GUIFigureApp_Triangle](https://github.com/qlkdkd/OOP/blob/main/%EA%B0%9D%EC%A7%80/week5/week5_Lecture/src/main/kotlin/section1/objectoriented/init/Triangle.kt)

[GUIFigureApp_main](https://github.com/qlkdkd/OOP/blob/main/%EA%B0%9D%EC%A7%80/week5/week5_Lecture/src/main/kotlin/section1/objectoriented/init/GuiFigureApp.kt)


### 변경 사항 추가(Ameba)반영 후...

[GUIFigure_AddAmeba](https://github.com/qlkdkd/OOP/blob/main/%EA%B0%9D%EC%A7%80/week5/week5_Lecture/src/main/kotlin/section1/objectoriented/init/Ameba.kt)

[GUIFigureApp_Revisioned](https://github.com/qlkdkd/OOP/blob/main/%EA%B0%9D%EC%A7%80/week5/week5_Lecture/src/main/kotlin/section1/objectoriented/init/GuiFigureApp_revision.kt)


### 현재 객체지향 설계의 문제점

![image](https://github.com/qlkdkd/OOP/assets/71871927/3635433f-f1e8-486f-a771-4abc99ec8c26)

### 개선된 객체지향 설계
* 공통적인 _메소드_ (함수의 다른 표현)를 _슈퍼클래스_ 에 정의하고, 서브클래스에서는 슈퍼클래스의 메소드를 그대로 _상속_ 받는다.
* 서브클래스에서 슈퍼클래스로부터 상속받은 기능을 확장하거나 변경할 필요가 있는 경우에는 _메소드를 재정의(메소드의 오버라이딩)_ 한다.

![image](https://github.com/qlkdkd/OOP/assets/71871927/6bc28ce2-829a-4cd7-994a-b7622bd68379)

#### 객체지향 설계의 장점

1. 더 자연스러운 방식으로 설계하는 데 도움이 된다.
2. 새로운 기능을 추가하기 위해 이미 테스트까지 완료한 코드를 수정하지 않아도 된다.
3. 데잍와 그 데이터로 작업을 처리하기 위한 메소드가 한 클래스에 들어갈 수 있다.
4. 다른 애플리케이션의 코드를 재사용할 수 있다.


## Section2

### 객체란?
* 상태 혹은 행동을 가지고 있는 _사물, 생물, 개념적 실체_
![image](https://github.com/qlkdkd/OOP/assets/71871927/3688d319-3742-4c39-a6d0-4e52d15db537)

### 클래스란?
* 공통된 속성(상태 혹은 행동)을 가진 _객체들의 추상화 및 일반화된 개념_
![image](https://github.com/qlkdkd/OOP/assets/71871927/30b9fec5-6a7f-437b-ad07-bf7fa096955d)

### 클래스와 객체(소프트웨어 관점)

![image](https://github.com/qlkdkd/OOP/assets/71871927/94d8a7a1-1c62-47e8-ac40-7726cf84a60f)

### NULL을 허용한 변수(KOTLIN)
* _코틀린의 변수 선언은_ 기본적으로 NULL을 허용하지 않고, **NULL을 허용하려면 자료형 뒤에 물음표(?) 기호를 명시해야 함.**
```kotlin
var a: String="Hello"
a=NULL //오류!
```
```kotlin
var a=String?
a=NULL //허용
```
* 세이프 콜
  * NULL이 할당되어 있을 가능성이 있는 변수를 검사하여 안전하게 호출
```kotlin
println("str1: $str1, length: ${str1?.length}") //str1이 null이면 null 반환, null이 아니면, str1.length 접근
```

* Non-NULL 단정 기호
  * 변수에 할당된 값이 NULL이 아님을 단정하므로, NULL 검사 없이 호출
  * 실행 시 변수에 NULL이 할당되어 있으면 NPE(NULL Pointer Exception) 발생
```kotlin
println("str1: $str1, length: ${str1!!.length}") //null 검사 없이, str1.length 접근근
```

### Java 클래스 구현
[Java 클래스 구현](https://github.com/qlkdkd/OOP/blob/main/%EA%B0%9D%EC%A7%80/week5/week5_Lecture/src/main/kotlin/section2_java/Dog.java)

### 객체 생성(kotlin)

객체 생성 절차
* 객체 생성(생성자 호출 - **클래스 이름 뒤에 소괄호() 사용**)
* 객체에 대한 레퍼런스 변수와 객체의 연결

![image](https://github.com/qlkdkd/OOP/assets/71871927/f1e5e7db-ffde-46d0-9200-efb49ce6ae21)

### 객체의 멤버 접근(kotlin)
1. 객체의 프로퍼티(멤버변수)에 값 대입
2. 객체의 프로퍼티(멤버변수)에서 값 읽기
3. 객체의 메소드(멤버함수) 호출

![image](https://github.com/qlkdkd/OOP/assets/71871927/8f605e21-b125-4e8e-ad07-5d18aed7cb2f)
[구현 코드](https://github.com/qlkdkd/OOP/blob/main/%EA%B0%9D%EC%A7%80/week5/week5_Lecture/src/main/kotlin/section2/dog.kt)

## Section3

### 생성자
* 객체가 생성될 때, 생성된 **객체의 프로퍼티(멤버변수)를 유효한 값으로 초기화**하는 역할을 수행하는 메소드

![image](https://github.com/qlkdkd/OOP/assets/71871927/a3d660e9-809b-4373-84d5-f5bc8ea9fb37)

### 반드시 생성자가 필요한가요?
* 생성된 객체의 프로퍼티가 의미론적으론 유효하지 않는 값으로 초기화되는 것을 막을 수 있다.

![image](https://github.com/qlkdkd/OOP/assets/71871927/a45824c1-3ba3-4478-94f1-7d93aa0d6bee)

### 생성자 문법(kotlin)
* 클래스 이름과 블럭 시작 부분 사이에 _constructor_ 키워드와 함께 선언(_constructor_ 키워드 생략 가능)
* 프로퍼티 초기화 방법
  * **init** 블럭 사용(_constructor_ 키워드 생략 가능)
```kotlin
class Dog constructor(type: String, name: String?, age: Int){
    var type: String
    var name: String?
    var age: Int

    init{
        this.type=type
        this.name=name
        this.age=age
    }
}
```

   * 생성자의 매개변수를 **프로퍼티 초기값**으로 할당 가능
     
```kotlin
class Dog(type: String, name: String?, age: int){
    var type: String=type
    var name: String?=name
    var age: int=age        
}
```

### 주 생성자 예제
1. 주 생성자의 매개변수를 프로퍼티(클래스 멤버변수)의 초기값으로 할당하는 예제 코드
[코드 보기](https://github.com/qlkdkd/OOP/blob/main/%EA%B0%9D%EC%A7%80/week5/week5_Lecture/src/main/kotlin/section3/mainconstructor/initWIthParam/Dog.kt)
2.  init 블럭에서 프로퍼티(클래스 멤버변수)를 초기화하는 예제코드
[코드 보기](https://github.com/qlkdkd/OOP/blob/main/%EA%B0%9D%EC%A7%80/week5/week5_Lecture/src/main/kotlin/section3/mainconstructor/initBlock/Dog.kt)
3.  주 생성자의 매개변수를 프로퍼티로 표현하고, Init 블럭에서 프로퍼티를 초기화하는 예제 코드
[코드 보기](https://github.com/qlkdkd/OOP/blob/main/%EA%B0%9D%EC%A7%80/week5/week5_Lecture/src/main/kotlin/section3/mainconstructor/initBlock/propertyAsParam/Dog.kt)

### 생성자 문법(kotlin)
* 부 생성자
    * 주 생성자가 없이 부 생성자만 정의될 수 있다.
    * 부 생성자를 여러개 정의될 경우, 각 **부 생성자의 매개변수의 타입 및 개수는 달라야 한다.**
```kotlin
class Dog{
    var type: String
    var name: String?
    var age: int

    constructor(type: String, name: String?, age: Int){
        this.type=type;
        this.name=name;
        this.age=age;
    }
    constructor(type: String, age: Int): this(type, "NoName", age)
    constructor(type: String): this(type, "NoName", 0)
}
```

  * (주 생성자가 있는 경우) 부 생성자는 **주 생성자를 반드시 상속**해야 한다.

```kotlin
class Dog(type: String, name: String?, age: Int){
    var type: String=type
    var name: String?=name
    var age: Int=age

    constructor(type: String, age: Int):
        this(type, "NoName", age)
    constructor(type: String):
        this(type, "NoName", 0)
}
```

```kotlin
class Dog(type: String, name: String?, age: Int){
    var type: String
    var name: String
    var age: Int

    init{ ... }

    constructor(type: String, age: Int):
        this(type, "NoName", age)
    constructor(type: String):
        this(type, "NoName", 0)
}
```
