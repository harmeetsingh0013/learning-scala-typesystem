trait Number[T] {
    def +(number: T): T
    def *(number: T): T
}

class Int extends Number[Int] {
    override def +(number : Int) : Int = number

    override def *(number : Int) : Int = number
}

class Double extends Number[Double] {
    override def *(number : Double) : Double = number

    override def +(number : Double) : Double = number
}

val a = new Int
val b = new Int

val c = a + b

class Char extends Number[Char] {
    override def +(number : Char) : Char = number

    override def *(number : Char) : Char = number
}

val d = new Char
val e = new Double

//val f = d + e

class User

class Float extends Number[User] {
    override def +(number : User) : User = number

    override def *(number : User) : User = number
}

// Now the major problem is, User is no a type of number, but still we are to pass as a type param
// Second problem. there is a requirements, we need to add two number types, but now we only restricted with
// specific type.

