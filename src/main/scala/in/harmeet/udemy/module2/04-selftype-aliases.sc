case class Person(name: String) {
    case class LifePartner(name: String) {
        def describe: String = s"$name loves $name"
    }
}

val p1 = Person("Romeo")
val p1pt = p1.LifePartner("Juliet")

p1pt.describe

// How to resolve this problem

case class Person2(name: String) { outer =>
    case class LifePartner(name: String) {
        def describe: String = s"${outer.name} loves ${this.name}"
    }
}

val p2 = Person2("Romeo")
val p2pt = p2.LifePartner("Juliet")

p2pt.describe

// Self type for restrict dependencies

trait Loves {
    
}