abstract class SuperHero { val team: String }

abstract class Marvel extends SuperHero

case class DrStrange(team: String) extends Marvel
case class Hulk(team: String) extends Marvel

abstract class DC extends SuperHero

case class BatMan(team: String) extends DC
case class Flash(team: String) extends DC

val batMan = BatMan("JusticeLeague")
val hulk = Hulk("Avengers")

case class Tower[T >: DrStrange](superHero: T) {
    override def toString : String = s"This is the ${superHero} tower"
    def helpMe : T = superHero
}

val tower1 = Tower(batMan)
val tower2 = Tower(hulk)

// Quiz -------------------

// Change to specific types
/*val tower1 = Tower[BatMan](batMan)
val tower2 = Tower[Hulk](hulk)
val tower3 = Tower[DrStrange](DrStrange("Avengers"))*/

// Change to one level abstract

/*val tower1 = Tower[DC](batMan)
val tower2 = Tower[Marvel](hulk)
val tower3 = Tower[Marvel](DrStrange("Avengers"))*/

