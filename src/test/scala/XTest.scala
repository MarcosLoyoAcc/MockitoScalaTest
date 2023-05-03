import org.apache.spark.sql
import org.apache.spark.sql.{DataFrame, DataFrameReader, SaveMode, SparkSession, SQLContext}
import org.mockito.Mockito.when
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar
import org.scalatestplus.mockito.MockitoSugar.mock

class XTest extends AnyFunSuite with MockitoSugar {

  test("Test") {

    val sparkSession = SparkSession
      .builder()
      .master("local[*]")
      .appName("View_Persistence_Spark_Job")
      .getOrCreate()
    sparkSession.sparkContext.setLogLevel("ERROR")

    val test = new Test()
    val df_from_json: sql.DataFrame = sparkSession.read.option("multiline", "true").json("src/test/resources/parquets/df.json")
    val mockContext = mock[SQLContext]
    val dataFrameReader = mock[DataFrameReader]

    when(mockContext.read).thenReturn(dataFrameReader)
    when(dataFrameReader.parquet("src/test/resources/parquets/df.json")).thenReturn(df_from_json)
    test.execute(mockContext)

    df_from_json.show()

  }

  test("Creacion de un parquet"){
    val spark = SparkSession.builder()
      .master("local[*]")
      .appName("parquet-writer")
      .getOrCreate()
    val data = Seq((1, "John"),(2, "Jane"),(3, "Alice"))
    val df = spark.createDataFrame(data).toDF("id", "name")
    df.write.mode(SaveMode.Overwrite).parquet("src/test/resources/parquets")
  }
}