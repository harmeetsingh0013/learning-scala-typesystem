// infix notation quick recap

"Knoldus".charAt(4)

"Knoldus" charAt 4

4.+(9)

4 + 9

// Infix notation with types

trait Loves[T1, T2] {
    def loves(t1: T1, t2: T2) = s"$t1 loves $t2"
}

class RomeoAndJuliet(r: String, j: String) extends Loves[String, String] {
    def describe = loves(r, j)
}

new RomeoAndJuliet("Romeo", "Juliet").describe

// how can we with with infix notation

case class Person(name: String)

class HeerAndRanjha(h: Person, r: Person) extends (Person Loves Person) {
    def describe = loves(h, r)
}

new HeerAndRanjha(Person("Heer"), Person("Ranjha")).describe

def club(couple: (Person Loves Person)): Unit = {
    println(s"$couple is the best couple of this party ... ")
}

club(new HeerAndRanjha(Person("Heer"), Person("Ranjha")))