class A {
    type B >: List[Int]
    def foo(a: B) = a
}

val x = new A { type B = Traversable[Int] }

x.foo(Set(8))

//val y = new A { type B = Set[Int] }