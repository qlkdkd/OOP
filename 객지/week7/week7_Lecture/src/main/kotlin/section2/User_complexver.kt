package section2

class User_complexver(_id: Int, _name: String, _age: Int) {
    val id: Int=_id
        get()=field//중복 정의
    var name: String=_name
        get()=field//중복정의
        set(value){
            field=value//중복정의
        }

    var age: Int=_age
        get()=field//중복정의
        set(value){
            field=value//중복정의
        }
}