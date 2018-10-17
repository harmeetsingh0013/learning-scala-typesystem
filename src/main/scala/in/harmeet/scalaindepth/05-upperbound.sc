class A {
    type B <: Traversable[Int]
    def count(b: B) = b.foldLeft(0)(_ + _)
}

val x = new A { type B = List[Int] }
x.count(List(1, 2, 3, 4, 5, 5))

//x.count(Set(2, 3, 4, 5, 6))

val y = new A { type B = Set[Int] }
y.count(Set(2, 3, 4, 5, 6))