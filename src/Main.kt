import java.io.File

fun main() {
val password = Password("qwerty", "123")
    val fileWorker = FileWorker()
    fileWorker.writeToFile("pass", password)

    val result = fileWorker.readFromFile("pass")
    if(result.key == readLine()){
        println("OK")
        println(result.pass)
    } else println("NOT OK")

}