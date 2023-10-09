package section1.internalVisibility

internal class InternalClass{
    internal var i=1
    internal fun icFunc(){
        i+=1//접근 허용
    }
    fun access(){
        icFunc()//접근 혀용
    }

}
class Other{
    internal val ic=InternalClass()//프로퍼티 지정 시  internal로 맞춰야 한다.
    fun test(){
        ic.i
        ic.icFunc()
    }
}
fun main(){
    val mic=InternalClass()//생성 가능
    mic.i//접근허용
    mic.icFunc()//접근허용
}