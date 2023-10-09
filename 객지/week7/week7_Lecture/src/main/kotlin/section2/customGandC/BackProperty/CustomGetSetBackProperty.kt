package section2.customGandC.BackProperty
import java.util.*
class User(_id: Int, _name: String, _age: Int) {
    val id: Int = _id
    var age: Int = _age

    private var _givenName: String? = null
    private var _familyName: String? = null

    var name:String = _name             // 프로퍼티 초기화
        get() {
            if (_familyName==null)
                return field.uppercase(Locale.getDefault())
            else
                return "$_givenName ${_familyName!!.uppercase(Locale.getDefault())}"
        }
        set(value) {
            println("The name was changed")
            field = value           // 인자를 프로퍼티에 할당
            if (value.split(" ").count()>1) {   // 인자가 두 단어 이상이면
                _familyName = value.split(" ").get(0)
                _givenName = value.split(" ").get(1)
            }
        }
}
fun main() {
    val user1 = User(1, "Kwanwoo Lee", 35)
    println("user1.name = ${user1.name}")
    val user2 = User(2, "John", 30)
    println("user2.name = ${user2.name}")
    user2.name = "David"
    println("user2.name = ${user2.name}")

}