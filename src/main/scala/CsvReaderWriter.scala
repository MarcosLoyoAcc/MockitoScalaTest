import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.SaveMode

object CsvReaderWriter {
  def readCsv(sparkSession: SparkSession, filePath: String): DataFrame = {
    sparkSession.read
      .format("parquet")
      .option("header", "true")
      .option("inferSchema", "true")
      .load(filePath)
  }

  def writeCsv(dataFrame: DataFrame, filePath: String): Unit = {
    dataFrame.write
      .mode(SaveMode.Overwrite)
      .option("header", "true")
      .option("delimiter", ",")
      .parquet(filePath)
  }
}
