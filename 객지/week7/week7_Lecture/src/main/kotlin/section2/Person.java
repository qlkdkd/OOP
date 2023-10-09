package section2;

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

class Main{
    public static void main(String[]args){
        Person p1=new Person("kildong", 30);

        //p1.naem="Dooly" 접근 불가
        p1.setName("Dooly");
        System.out.println(p1.getName());
    }
}