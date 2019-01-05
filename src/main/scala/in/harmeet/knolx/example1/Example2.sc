trait Adder[T] {
    def sum(a: T, b: T): T
}

def sum[T](a: T, b: T)(implicit adder: Adder[T]): T = adder.sum(a, b)

implicit val integer = new Adder[Int] {
    override def sum(a: Int, b: Int): Int = a + b
}
sum(1, 3)

implicit val stringAdder = new Adder[String] {
    override def sum(a : String, b : String) : String = a + b
}

sum("One", "Two")

implicit val listAdder = new Adder[List[Int]] {
    override def sum(a : List[Int], b : List[Int]) : List[Int] =
        (a zip b).map { case (x, y) => x + y}
}
sum(List(1, 3, 4, 5), List(3, 3, 4, 5))