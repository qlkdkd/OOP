package section2_java;

public class Dog { // ① 클래스의 정의
    // ② 프로퍼티들(속성)
    String type;
    String name;
    int age;

    // ③ 메서드들(함수)
    void bark() {
        System.out.println(name+"(이/가)  짖고 있습니다.");
    }
    void eat() {
        System.out.println(name+"(이/가) 식사 중입니다.");
    }

    public static void main(String[] args) {
        Dog aDog = new Dog();  // ④ 클래스의 생성자를 통한 객체의 생성
        aDog.type = "진도개";  // ⑤ 객체의 프로퍼티에 값 할당
        aDog.name = "화랑";
        aDog.age = 3;

        // ⑥ 객체의 멤버 프로퍼티 읽기
        System.out.println("aDog.type: "+aDog.type +
                ", aDog.name: "+ aDog.name +
                ", aDog.age: " + aDog.age);
        aDog.bark(); // ⑦ 객체의 멤버 메서드의 사용
        aDog.eat();
    }
}