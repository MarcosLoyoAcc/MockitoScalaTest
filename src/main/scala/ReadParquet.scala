import org.apache.spark.sql.{DataFrame, SparkSession}
class ReadParquet(spark: SparkSession) {
  def read(path: String): DataFrame = { spark.read.parquet(path) } }