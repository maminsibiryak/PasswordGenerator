import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream


class FileWorker {
    fun readFromFile(fileName: String): Password {
        val fileInputStream = FileInputStream(fileName)
        val objectInputStream = ObjectInputStream(fileInputStream)
        val password = objectInputStream.readObject() as Password
        val temp = password.pass.toCharArray()
        val result = CharArray(temp.size)
        for (i in temp.indices){
            result[i] = temp[i] - 6
        }
        password.pass= String(result)
        return password

    }

    fun writeToFile(fileName: String, password: Password) {
        val outputStream = FileOutputStream(fileName)
        val objectOutputStream = ObjectOutputStream(outputStream)
        val temp = password.pass.toCharArray()
        val result  = CharArray(temp.size)
        for (i in temp.indices){
           result[i] = temp[i]+6
        }
        password.pass = String(result)
        objectOutputStream.writeObject(password)
        objectOutputStream.close()
    }
}