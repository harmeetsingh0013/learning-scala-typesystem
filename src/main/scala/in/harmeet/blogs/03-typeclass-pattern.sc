// Type class pattern also based on adhoc polymorphism

// Type pattern V2
trait Adder[T] {
    def add(a: T, b: T): T
}

implicit val intAdder : Adder[Int] = new Adder[Int] {
    override def add(a: Int, b : Int) = a + b
}

implicit val stringAdder : Adder[String] = new Adder[String] {
    override def add(a: String, b : String) = a + b
}

def combine[T](a: T, b: T)(implicit adder: Adder[T]) : T = adder.add(a, b)

combine("Harmeet", "Singh")
combine(8, 7)

def combineV[T](a: T, b: T)(implicit adder: Adder[T]) : T =
    implicitly[Adder[T]].add(a, b)

//def combineV1[T](a: T, b: T) : T = implicitly[Adder[T]].add(a, b)