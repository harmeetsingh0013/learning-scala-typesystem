trait Combine[T] {
    val item: T
    def combineWith(value: T): T
}

case class CombineInt(item: Int) extends Combine[Int] {
    override def combineWith(value : Int) : Int = item + value
}

val combineInt : Combine[Int] = CombineInt(10)
combineInt.combineWith(20)

// Problem: What if Combine is co-variance ???

/*

trait Combine[+T] {
    val item: T
    def combineWith(value: T): T
}

val combineInt : Combine[Any] = CombineInt(10)
combineInt.combineWith("twenty")

 */



