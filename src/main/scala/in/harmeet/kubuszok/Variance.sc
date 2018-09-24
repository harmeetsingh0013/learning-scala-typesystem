// without co-variance problem

/*sealed trait Option[T]
case class Some[T](t: T) extends Option[T]
case object None extends Option[Nothing]*/

//val value: Option[String] = None

// Resolution
sealed trait Option[+T]
case class Some[T](t: T) extends Option[T]
case object None extends Option[Nothing]

val value: Option[String] = None

// Without contra-variance

sealed trait User { val id: Int }
case class Member(id: Int, name: String) extends User
case class Admin(id: Int, access: Set[String]) extends User

trait Consumer[T] {
    def consume(value: T): Unit
}

val members: List[Member] = List(Member(13, "knoldus"))
def consumer: Consumer[User]

members.foreach(consumer.consume)

// Resolution

/*
trait Consumer[-T] {
    def consume(value: T): Unit
}

val members: List[Member] = List(Member(13, "knoldus"))
def consumer: Consumer[User] = new Consumer[User] {
    override def consume(value : User) : Unit = println(value)
}

members.foreach(consumer.consume(_))*/
