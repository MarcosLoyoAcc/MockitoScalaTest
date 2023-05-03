import org.apache.parquet.hadoop.ParquetReader
import org.apache.spark.sql.{DataFrame, DataFrameReader, SparkSession}
import org.mockito.BDDMockito.Then
import org.mockito.Mockito.when
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.mockito.MockitoSugar


class ParquetReaderSpec extends AnyFlatSpec with Matchers with MockitoSugar {
  "ParquetReader" should "read parquet file" in {
    //Given
 val path = "src/test/resources/parquets/"
 val expectedDataFrame = mock[DataFrame]
 val sparkSessionMock = mock[SparkSession]
    val dataFrameReader = mock[DataFrameReader]
 when(dataFrameReader.parquet(path)).thenReturn(expectedDataFrame)
 val parquetReader = new ReadParquet(sparkSessionMock)
 //When
 val actualDataFrame = parquetReader.read(path)
 //Then
 actualDataFrame shouldBe actualDataFrame
 }
 }