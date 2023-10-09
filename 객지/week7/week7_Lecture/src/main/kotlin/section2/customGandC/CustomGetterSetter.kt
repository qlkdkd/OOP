package section2.customGandC

import java.util.*

class User(_id: Int, _name: String, _age: Int){
    val id: Int=_id
    var name: String=_name
        set(value){
            println("This name was changed")
            //인자를 대문자로 변경해 프로퍼티에 할당
            field=value.uppercase(Locale.getDefault())
        }
    var age: Int=_age
        private set//외부에서 변경하지 못하게 설정
}

fun main(){
    val user1= User(1, "kildong", 35)
    user1.name="coco"
    println("user3.name=${user1.name}")
    //user1.age=36//외부엣 변경할 수 없음
}