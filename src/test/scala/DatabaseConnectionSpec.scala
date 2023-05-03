import org.scalatest._
import flatspec._
import matchers._
import org.mockito.Mockito._

class DatabaseConnectionSpec extends AnyFlatSpec with should.Matchers {

  "A database connection" should "return data from the database" in {
    val connection = mock(classOf[DatabaseConnection])
    when(connection.getData("some query")).thenReturn(Seq("result1", "result2"))

    assert(connection.getData("some query").size == 2)
  }

  "a test for check strings" should "pass if the sentence starts with Hello" in {
    val accel = "Hello World"
    accel should startWith("Hello")
  }

}
