// Type aliases
type L = List[Option[(Int, Double)]]

type T[A] = Option[Map[Int, A]]

val t: T[String] = Some(Map(13 -> "Harmeet Singh"))

//Lets create a HK Types
trait Functor[F[_]]

type f1 = Functor[Option]
type f2 = Functor[List]
//type f3 = Functor[Map]

type IntKeyMap[A] = Map[Int, A]
type f3 = Functor[IntKeyMap]

val cube = Math.pow(_: Double, 3)
cube(4)

/*
Scala uses the underscore in different (one could say inconsistent) ways
depending on the context. In this case (in the right hand side of the type alias
definition) what is implied is not partial application at all,
but rather “I don’t care what this type is”.
 */
//type f4 = Functor[Map[Int, _]]

// Type Lambda with projection
type f5 = Functor[({ type T[A] = Map[Int, A]})#T]

//def foo[A[_, _], B](functor: Functor[A[B, ?]]) // won't compile

// A and B are not in scope, it is not possible to create alias of Functor[A[B, ?]]
//type AB[C] = ({type AB[C] = A[]})

//def foo[A[_,_], B](functor: Functor[AB])

// But with the help of type lambda directly to the method, we can do that.
def foo[A[_,_], B](functor: Functor[({type AB[C] = A[B, C]})#AB])

// There are alternatives as well by using Surrounding classes
abstract class Foo[A[_, _], B] {
    type AB[C] = A[B, C]

    def apply(functor: Functor[AB]) = println(functor)
}

def foo1[A[_, _], B] = new Foo[A, B] { }