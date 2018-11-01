trait Number[T <: Number[_]] {
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

class User

/*class Float extends Number[User] {
    override def +(number : User) : User = number

    override def *(number : User) : User = number
}*/




