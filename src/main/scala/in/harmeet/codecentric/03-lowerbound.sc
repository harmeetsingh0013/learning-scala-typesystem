// Lower bound is genereally used for handle convariant
// type parameter in the method arguments

abstract class Fruit { def name: String }

class Orange extends Fruit { def name = "Orange" }

class Apple extends Fruit { def name = "Apple" }

class Box[+T <: Fruit] {
    def replace[U >: T](fruit: U): Box[T] = { new Box[T] }
}

val fruit = new Box[Apple]

fruit.replace(new Orange)

// The most imporatant example is List[] in scala