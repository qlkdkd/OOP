package section2

class User(_id: Int,_name: String, _age: Int) {
    val id: Int=_id
    var name: String=_name
    var age: Int=_age
}

fun main(){
    val user1=User(1,"Kildong", 30)
    //user1.id=2//val프로퍼티는 값 변경 불가
    user1.age=35//세터
    println("user1.age=${user1.age}")//게터
}