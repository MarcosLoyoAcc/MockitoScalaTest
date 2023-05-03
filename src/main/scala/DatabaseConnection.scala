trait DatabaseConnection {
  def getData(query: String): Seq[String]
}
