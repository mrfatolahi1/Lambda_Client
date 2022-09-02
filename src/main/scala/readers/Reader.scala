package readers

import java.io.{BufferedInputStream, File, FileInputStream, InputStream}

abstract class Reader {
  val initialFile: File
  val inputStream: InputStream
  def read(): Object
}
