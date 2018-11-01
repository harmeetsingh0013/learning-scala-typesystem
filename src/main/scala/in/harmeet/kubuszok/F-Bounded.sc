trait Number {
    def +(number: Number): Number
    def *(number: Number): Number
}

class Int extends Number {
    override def +(number : Number) : Number = number

    override def *(number : Number) : Number = number

    override def toString : String = "Int"
}

class Double extends Number {
    override def +(number : Number) : Number = number

    override def *(number : Number) : Number = number

    override def toString : String = "Double"
}

val a: Int = new Int
val b: Int = new Int

val c : Number = a + b // But here we lost the information, what actual number is

// What are the alternatives for this.???