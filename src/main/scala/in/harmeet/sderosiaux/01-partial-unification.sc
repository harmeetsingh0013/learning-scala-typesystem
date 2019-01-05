/**
  * https://github.com/typelevel/general/issues/69
  * https://gist.github.com/djspiewak/7a81a395c461fd3a09a6941d4cd040f2
  * https://issues.scala-lang.org/browse/SI-2712
  * https://www.reddit.com/r/scala/comments/7ak9c5/ypartialunification/
  * https://github.com/scala/scala/pull/6309
  *
  */

def show[F[_], A](fa: F[A]) = println(fa)

show(List(1, 2, 3, 4, 5))
show(Some("Hello World"))

val error: Either[Error, String] = Left(new Error("Boom Boom !!"))
show(error)

type ErrorEither[A] = Either[Error, A]
val err: ErrorEither[String] = Left(new Error)
show(err) // This checked at compile time

type R1[A] = Either[_, A]
type R2[A] = ({ type F[E] =  Either[E, A]})#F[_]
type R3[A] = Either[E, A] forSome { type E }

show(Right(5): R1[Int])
show(Right("Hello"): R2[String])
show(Left(5): R3[String])
