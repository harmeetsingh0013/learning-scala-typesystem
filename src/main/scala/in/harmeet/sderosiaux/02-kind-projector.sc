/*// All are same
type R1[A] = ({ type F[E] = Either[E, A]})#F[_]
type R2[A] = Either[?, A]
type R3[A] = Lambda[E => Either[E, A]]*/

trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
}

def makeListFunctor = new Functor[List] {
    override def map[A, B](fa : List[A])(f : A => B) = fa.map(f)
}

makeListFunctor.map(List(1, 2))(_ + 1)

def makeEitherFunctor[U] = new Functor[Either[?, U]] {
    override def map[A, B](fa : Either[A, U])(f : A => B) : Either[B, U] = fa match {
        case Left(value: A) => f(value).asLeft
        case Right(value: B) => value.asRight
    }
}