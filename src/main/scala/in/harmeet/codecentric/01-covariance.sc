abstract class Fruit { def name: String }

class Orange extends Fruit { def name = "Orange" }

class Apple extends Fruit { def name = "Apple" }

abstract class Box {
    def fruit: Fruit
    def contains(afruit: Fruit) = afruit.name.equals(fruit.name)
}

// Concrete way for creating the boxes of fruits
class OrangeBox (orange: Orange) extends Box {
    override def fruit : Fruit = orange
}

class AppleBox(apple: Apple) extends Box {
    override def fruit : Fruit = apple
}

// Create different boxes using type parameter
class Box1[F <: Fruit](ifruit: F) {
    def fruit: F = ifruit
    def contains(aFruit: Fruit) = aFruit.name == fruit.name
}

val appleBox : Box1[Apple] = new Box1[Apple](new Apple)
val orangeBox : Box1[Orange] = new Box1[Orange](new Orange)

//val anotherAppleBox: BoxT[Fruit] = new BoxT[Apple](new Apple)

// Handle polymorphic refrence for type objects
class Box2[+F <: Fruit](ifruit: F) {
    def fruit: F = ifruit
    def contains(aFruit: Fruit) = aFruit.name == fruit.name
}

val appleBox1 : Box2[Apple] = new Box2[Apple](new Apple)
val orangeBox1 : Box2[Orange] = new Box2[Orange](new Orange)

val anotherAppleBox1: Box2[Fruit] = new Box2[Apple](new Apple)