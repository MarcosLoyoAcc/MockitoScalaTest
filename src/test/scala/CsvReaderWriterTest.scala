import org.apache.spark.sql.{DataFrame, SparkSession}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import java.nio.file.Files

class CsvReaderWriterTest extends AnyFunSuite{

  // Crea una sesión de Spark para las pruebas
  val spark = SparkSession.builder()
    .master("local[*]")
    .appName("CsvReaderWriterTest")
    .getOrCreate()

  // Cerrar la sesión de Spark después de las pruebas
  spark.stop()
}
