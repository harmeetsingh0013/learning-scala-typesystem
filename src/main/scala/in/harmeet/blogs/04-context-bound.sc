

/**
  * https://docs.scala-lang.org/sips/completed/scala-2-8-arrays.html
  * https://stackoverflow.com/questions/2982276/what-is-a-context-bound-in-scala
  * http://www.waitingforcode.com/scala-types/scala-context-bound/read
  */
// Context Bound is a syntactic sugar Or beautiful way to implement type class pattern
trait Adder[T] {
    def add(a: T, b: T): T
}

implicit val intAdder : Adder[Int] = new Adder[Int] {
    override def add(a: Int, b : Int) = a + b
}

implicit val stringAdder : Adder[String] = new Adder[String] {
    override def add(a: String, b : String) = a + b
}

def combine[T : Adder](a: T, b: T) : T = implicitly[Adder[T]].add(a, b)

combine("Harmeet", "Singh")
combine(8, 7)


// Most of common example of context bound in scala library

// Compare User based on the Age
case class User(name: String, age: Int)

implicit val userOrdering = new Ordering[User]
{
    override def compare(x : User, y : User) = x.age.compare(y.age)
}

val user1 = User("Harmeet", 29)
val user2 = User("Knoldus", 6)

def f[A : Ordering](a: A, b: A) = implicitly[Ordering[A]].compare(a, b)

f(user2, user1)