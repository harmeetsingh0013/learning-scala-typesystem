/**
http://blog.jaceklaskowski.pl/2015/05/15/ad-hoc-polymorphism-in-scala-with-type-classes.html
https://blog.codecentric.de/en/2017/02/ad-hoc-polymorphism-scala-mere-mortals/

  */


// problem with overloading
def combine(a: Int, b: Int) : Int = a + b

def combine(a: String, b: String) : String = a + b

// What is the solution
// Basic adhoc polymorphism
def combineG[T](a: T, b: T) = (a, b) match {
    case (text1: String, text2: String) =>
        println("Strings are concatenate")
        text1 + text2
    case (value1: Int, value2: Int) =>
        println("Integer values are plus")
        value1 + value2
    case _ =>
        println("unknown type")

}

combineG("Harmeet", "Singh")
combineG(8, 7)

// The problem with generics Or adhoc polymorphism
class User

combineG(new User, new User)

// Is the common trait is solution ???
trait Adder[T] {
    def add(other: T): T
}

def combineA[T <: Adder[T]](a: T, b: T) = ???

//combineA(8 , 7)


