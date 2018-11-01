import scala.reflect.ClassTag

// Another example of context bound in scala library is Arrays
/**
  * https://stackoverflow.com/questions/2982276/what-is-a-context-bound-in-scala
  *
  * Before scala 2.8 if we are sending primitive to arrays generic method
  * it converts it into BoxedAnyArray[T] because need to perform operations
  * which are not available in Java arrays like map, flatMap and more
  *
  */
def tabulate[T](len: Int, f: Int => T) = {
    val xs = new Array[T](len)
    for (i <- 0 until len) xs(i) = f(i)
    xs
}

/** After 2.8 it introduce ClassManifest which is now deprecated and
  * now require ClassTag for maintaining arrays type at runtime
  * and below is the syntax for creating generic arrays function
  */

def tabulate[T](len: Int, f: Int => T)(implicit m: ClassTag[T]) = {
    val xs = new Array[T](len)
    for (i <- 0 until len) xs(i) = f(i)
    xs
}

/**
  * This is the another syntactic sugar of above version code, which remove a lot of
  * boilerplate
  */
def tabulate[T: ClassTag](len: Int, f: Int => T) = {
    val xs = new Array[T](len)
    for (i <- 0 until len) xs(i) = f(i)
    xs
}