trait SimpleContainer {
    type A          // Abstract member

    def value: A
}

object IntContainer extends SimpleContainer{
    override type A = Int

    override def value = 13
}

trait OnlyNumberContainer extends SimpleContainer{
    type A <: Number

    def value: A
}

trait OnlyNumber {
    type A <: Number
}

val ints = new SimpleContainer with OnlyNumber{
    def value = 13
}