// Type class pattern also based on adhoc polymorphism

// Type pattern V1
trait Adder[T] {
    def add(a: T, b: T): T
}

val intAdder : Adder[Int] = new Adder[Int] {
    override def add(a: Int, b : Int) = a + b
}

val stringAdder : Adder[String] = new Adder[String] {
    override def add(a: String, b : String) = a + b
}

def combine[T](a: T, b: T)(adder: Adder[T]) : T = adder.add(a, b)

combine("Harmeet", "Singh")(stringAdder)
combine(8, 7)(intAdder)

// If we have some use case like this ???
class User
//combine(new User, new User)