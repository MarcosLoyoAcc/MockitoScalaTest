import org.apache.spark.sql.{DataFrame, SQLContext}

class Test {
  def execute(sqlContext: SQLContext) {
    val df: DataFrame = sqlContext.read.parquet("src/test/resources/parquets/df.json")
  }
}