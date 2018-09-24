//Type Constraints

sealed trait User { val id: Int }
case class Member(id: Int, name: String) extends User
case class Admin(id: Int, access: Set[String]) extends User

val data1 : Set[User] = Set(Member(1, "Harmeet"), Member(3, "Knoldus"))
val data2 : Set[User] = Set(Admin(1, Set("Dashboard")), Admin(3, Set("Admin")))
val data3 : Set[User] = Set(Member(1, "James"), Admin(3, Set("Admin")))

// Create a function takes user and return map from id -> user like Map[Int, User]

def byId(users: Set[User]): Map[Int, User] =
    users.map(u => u.id -> u).toMap

byId(data1)
byId(data2)
byId(data3)

// Create a generic method for doing the same thing

def byIdG1[U](users: Set[U])(getId: U => Int): Map[Int, U] =
    users.map(u => getId(u) -> u).toMap

byIdG1(data1)((u: User) => u.id)
byIdG1(data2)((u: User) => u.id)
byIdG1(data3)((u: User) => u.id)

// The problem with above code is, we always need to pass HOF manually
// So, how can we resole that issue.
// That time, Upper bound comes into the picture

def byIdG2[U <: User](users: Set[U]): Map[Int, U] =
    users.map(u => u.id -> u).toMap

byIdG2(data1)
byIdG2(data2)
byIdG2(data3)

// Symbol <: (less than equals to) denotes an upper bound in type parameters

// Lest take an example for Lower bound which is similar to upper bound
// The symbol of Lowe bound is >: (greater than equals to)

def recover[E, A, B >: A](either: Either[E, A])(f: E => B): Either[E, B] =
    either match {
        case Left(e) => Right(f(e))
        case Right(e) => Right(e)
    }

val data4: Either[String, Admin] = Right(Admin(13, Set("Admin")))
val data5: Either[String, Admin ] = Left("Access Denied")

//recover(data4)(_ => Member(0, "NoName"))
//recover(data5)(_ => Member(0, "NoName"))

// -------------------------------------------------------------------------

// <:< One type class is subclass the other
// For more details http://blog.bruchez.name/2015/11/generalized-type-constraints-in-scala.html

def tupleIfSubtype[T <: U, U] (t: T, u: U): (T, U) = (t, u)

tupleIfSubtype(Member(1, "Harmeet"), Admin(3, Set("Admin")))

tupleIfSubtype("Harmeet", 13)

// How to solve Any type Problem

def tupesIfSubtypeI1[T, U] (t: T, u: U)(implicit ev: T <:< U): (T, U) = (t, u)

//tupesIfSubtypeI1(Member(1, "Harmeet"), Admin(3, Set("Admin")))
//tupesIfSubtypeI1("Harmeet", 13)


def upcast[A, B](set: Set[A])(implicit ev: A <:< B): Set[B] =
    set.map(ev(_))

upcast(data1)
upcast(data2)
upcast(data3)

//implicit def a2b(int: Int): String = int.toString

//upcast[Int, String](Set(2, 3, 4, 5))

// -------------------------------------------------------------------------

// =:= type constructor

def update[A, B](set: Set[A])(f: A => B): Set[B] =
    set.map(f)

update(data1)((u: User) => Admin(u.id, Set("All")))

def updateI1[A, B](set: Set[A])(f: A => B)(implicit ev: A =:= B): Set[B] =
    set.map(f)

//updateI1(data1)((u: User) => Admin(u.id, Set("All")))

val data6 = Set(Member(1, "Harmeet"), Member(3, "Knoldus"))
updateI1(data6)(identity)

// another example

class Container[A](value: A) {

    def stringLength(implicit ev: A =:= String) : Int = value.length

    def addInt(implicit ev: A =:= Int): Int = value + 234
}

new Container("James").stringLength

//new Container(123).stringLength
