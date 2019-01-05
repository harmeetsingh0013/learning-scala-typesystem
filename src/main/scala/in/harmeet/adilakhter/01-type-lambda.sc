/**
  * http://like-a-boss.net/2014/09/27/type-lambda-in-scala.html
  * https://www.protechtraining.com/blog/post/387?ncr=1
  * https://stackoverflow.com/questions/8736164/what-are-type-lambdas-in-scala-and-what-are-their-benefits
  * https://blog.adilakhter.com/2015/02/18/applying-scalas-type-lambda/
  */
trait Functor[A, +M[_]] {
    def map[B](f: A => B): M[B]
}

case class SeqFunctor[A](seq: Seq[A]) extends Functor[A, Seq] {
    override def map[B](f : A => B): Seq[B] = seq.map(f)
}

SeqFunctor(List(1, 2, 3, 4, 5)).map(_ * 10)

// What about with Map???
// Map contains two types of parameter

case class MapFunctor[K, V] (mapKV: Map[K, V]) extends
    Functor[V, ({ type L[a] = Map[K, a]})#L] {
    override def map[B](f : V => B): Map[K, B] = mapKV.map {
        case (k, v) => (k, f(v))
    }
}

MapFunctor(Map(1 -> 1, 2 -> 2, 3 -> 3)).map(_ * 10)

case class MapFunctor1[K, V](mapKV: Map[K, V]) {
    type Alias[A] = Map[K, A]
    def functor[B] = new Functor[V, Alias] {
        override def map[B](f : V => B): Alias[B] = mapKV.map {
            case (k, v) => (k, f(v))
        }
    }
}

MapFunctor1(Map(1 -> 1, 2 -> 2, 3 -> 3)).functor.map(_ * 10)

case class ReadableMapFunctor[K, V](mapKV: Map[K, V]){
    def functor[B] = {
        type `Map[K]`[B] = Map[K, B]
        new Functor[V, `Map[K]`] {
            override def map[B](f : V => B) : `Map[K]`[B] = mapKV.map {
                case (k, v) => (k, f(v))
            }
        }
    }
}

ReadableMapFunctor(Map(1 -> 1, 2 -> 2, 3 -> 3)).functor.map(_ * 10)

