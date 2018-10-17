abstract class Fruit { def name: String }

class Orange extends Fruit {
    def name = "Orange"

    override def toString : String = name
}

class Apple extends Fruit {
    def name = "Apple"

    override def toString : String = name
}

abstract class Box[+A] {
    def isEmpty: Boolean
    def contains[B](item: B): Boolean
    def prepend[B >: A](item: B): BoxItem[B] = new BoxItem[B](item, this)
}

case class BoxItem[+A](item: A, next: Box[A]) extends Box[A] {
    override def isEmpty : Boolean = false

    override def contains[B](item : B) : Boolean = this.item == item || next.contains(item)
}

case class Emptybox[+A]() extends Box[A] {
    override def isEmpty : Boolean = true

    override def contains[B](item : B) : Boolean = false
}

val apple1 = new Apple
val apple2 = new Apple

val appleBox : BoxItem[Apple] = new BoxItem(apple1, new Emptybox)
appleBox.prepend(apple2)

val fruitBox : BoxItem[Fruit] = appleBox.prepend(new Orange)