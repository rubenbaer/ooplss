trait StrictlyOrdered[MyType] {
  def compare(other: MyType): Int;
  def > (other: MyType): Boolean = {
    return this.compare(other) > 0;
  }
  def < (other: MyType): Boolean = {
    return this.compare(other) < 0;
  }
}

trait Ordered[MyType] extends StrictlyOrdered[MyType] {
  def >= (other: MyType): Boolean = {
    return compare(other) >= 0;
  }
  def <= (other: MyType): Boolean = {
    return compare(other) <= 0;
  }
}
/* \label{line:literatureScala} */
abstract class Literature(val author: String, val year: Int) {
}

class Book(author: String, year: Int) extends Literature(author, year) with Ordered[Book] {
  def compare(other: Book): Int = {
    return this.year - other.year;
  }
}

class Journal(author: String, year: Int) extends Literature(author, year) with Ordered[Journal] {
  def compare(other: Journal): Int = {
    return this.year - other.year;
  }
}
