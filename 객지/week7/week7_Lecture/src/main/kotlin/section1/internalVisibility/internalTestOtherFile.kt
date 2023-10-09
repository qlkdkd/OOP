package section1.internalVisibility
import section1.internalVisibility.InternalClass

fun main(){
    val otheric=InternalClass()

    println(otheric.i)
    otheric.icFunc()
}