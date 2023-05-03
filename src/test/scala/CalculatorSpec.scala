import org.mockito.Mockito._
import org.scalatest._
import flatspec.AnyFlatSpec
import org.mockito.ArgumentMatchers.byteThat
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.mockito.MockitoSugar

class CalculatorSpec extends AnyFlatSpec with Matchers with MockitoSugar {

  "Calculator" should "add two numbers correctly" in {
    val calculator = new Calculator()
    val a = 5
    val b = 7
    val c = 9
    val expectedResult = calculator.add(c,b)

    val mockedCalculator = mock[Calculator]
    when(mockedCalculator.add(c, b)).thenReturn(expectedResult)

    val result = mockedCalculator.add(c, b)

    result should be(expectedResult)
  }
}

class CalculatorSpec2 extends AnyFunSuite{
  test("Confirmar valores de suma"){
    val a= 5
    val b= 7
    val c= 12
    val calculator = new Calculator()
    val resultadoEsperado = b+c

    val mockedCalculator = mock(classOf[Calculator])
    when(mockedCalculator.add(b,c)).thenReturn((resultadoEsperado))

    val resultadoReal = calculator.add(b,c)

    assert(resultadoReal === resultadoEsperado)


  }
}
