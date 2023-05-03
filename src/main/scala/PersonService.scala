class PersonService {
  def getPersonNameAndAge(person: Person): (String, Int) = {
    (person.name, person.age)
  }
}
