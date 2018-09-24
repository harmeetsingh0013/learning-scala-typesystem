abstract class SuperHero {
    val team: String
    override def toString : String = s"$team Team"
}

abstract class Marvel extends SuperHero

case class DrStrange(team: String) extends Marvel
case class Hulk(team: String) extends Marvel

trait Power[T] {
    def superPower(superHero: T): String
}

object Wizard extends Power[DrStrange] {
    override def superPower(superHero : DrStrange) : String =
        s"DrStrange(${superHero.team}) has a Wizard power"
}

object Smash extends Power[Hulk] {
    override def superPower(superHero : Hulk) : String =
        s"Hulk(${superHero.team}) has a Smash power"
}

object SuperPower extends Power[Marvel] {
    override def superPower(superHero : Marvel) : String =
        s"Most of the Marvel Hero's has power"
}

object Courage extends Power[Any] {
    override def superPower(superHero : Any) : String =
        s"${superHero} needs courage rather than power"
}

def showSuperPower(power: Power[DrStrange]) : String = {
    power.superPower(DrStrange("Avengers"))
}

showSuperPower(Wizard)

// Contra-variance with generics

trait Power2[-T] {
    def superPower(superHero: T): String
}

object Wizard2 extends Power2[DrStrange] {
    override def superPower(superHero : DrStrange) : String =
        s"DrStrange(${superHero.team}) has a Wizard power"
}

object Smash2 extends Power2[Hulk] {
    override def superPower(superHero : Hulk) : String =
        s"Hulk(${superHero.team}) has a Smash power"
}

object SuperPower2 extends Power2[Marvel] {
    override def superPower(superHero : Marvel) : String =
        s"Most of the Marvel Hero's has power"
}

object Courage2 extends Power2[Any] {
    override def superPower(superHero : Any) : String =
        s"${superHero} needs courage rather than power"
}

def showSuperPower2(power: Power2[DrStrange]) : String = {
    power.superPower(DrStrange("Avengers"))
}

showSuperPower2(Wizard2)
showSuperPower2(SuperPower2)
showSuperPower2(Courage2)

// Contra-variance method parameter

class Comics(val name: String)

class Season(val no: Int, override val name : String) extends Comics(name)

class IronMan(override val no: Int, override val name : String) extends Season(no, name)

class Publisher[-T] {
    def publishComic(comic: T) = {
        s"Comic ${comic} comics is published"
    }
}

new Publisher[IronMan].publishComic(new IronMan(1, "Tales of Suspense"))
//new Publisher[IronMan].publishComic(new Season(1, "Tales of Suspense"))