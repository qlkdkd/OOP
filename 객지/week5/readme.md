# week5. 클래스와 객체1

## 절차지향적 소프트웨어 개발
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
