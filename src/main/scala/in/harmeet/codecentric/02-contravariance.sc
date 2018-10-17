abstract class Fruit { def name: String }

class Orange extends Fruit { def name = "Orange" }

class Apple extends Fruit {
    def name = "Apple"
    def brand = "Kashmiri"
}

// create a concrete example

def wrapTheFruit(fruit: Fruit): String = {
    val apple = fruit.asInstanceOf[Apple]
    apple.brand
}

wrapTheFruit(new Apple)
//wrapTheFruit(new Orange)

// Create type system example

abstract class Box[+F <: Fruit] {
    def fruit: F
//    def contains(afruit: F) = afruit.name.equals(fruit.name)
}