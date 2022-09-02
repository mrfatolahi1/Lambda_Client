package readers
import java.io.{BufferedInputStream, File, FileInputStream, InputStream}
//import org.json

class UserActivityReader extends Reader {
  override val initialFile: File = new File("/home/mohammadreza/Downloads/sorted_20160801-20170201-raw_user_activity.json")
  override val inputStream: InputStream = new BufferedInputStream(new FileInputStream(initialFile), 100000)

  override def read(): String = {
    var row: String = ""
    while (true){
      val char: Char = inputStream.read().toChar
      if (char == '\n'){
        return row
      } else {
        row += char
      }
    }

    null
  }

}
