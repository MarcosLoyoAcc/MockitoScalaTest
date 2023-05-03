import org.mockito.Mockito._
import org.scalatest._
import flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.mockito.MockitoSugar

class PersonServiceSpec extends AnyFlatSpec with Matchers with MockitoSugar {

  "PersonService" should "return the name and age of a person" in {
    val person = Person("John", 25)
    val expectedName = "John"
    val expectedAge = 25

    val mockedPersonService = mock[PersonService]
    when(mockedPersonService.getPersonNameAndAge(person)).thenReturn((expectedName, expectedAge))

    val (person.name, person.age) = mockedPersonService.getPersonNameAndAge(person)

    person.name should be(expectedName)
    person.age should be(expectedAge)
  }
}
