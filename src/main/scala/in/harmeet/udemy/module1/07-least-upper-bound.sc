// Example 01, 02

// Following are the points why we require upper bounds
// -- If we need to access some generic property of the type
// -- Without lower bound we are not able to restrict with specific type hierarchy

abstract class SuperHero { val team: String }

abstract class Marvel extends SuperHero

case class DrStrange(team: String) extends Marvel
case class Hulk(team: String) extends Marvel

abstract class DC extends SuperHero

case class BatMan(team: String) extends DC
case class Flash(team: String) extends DC

val batMan = BatMan("JusticeLeague")
val hulk = Hulk("Avengers")

// First point
case class Tower[T <: SuperHero](superHero: T) {
    override def toString : String = s"This is the ${superHero.team} tower"
    def helpMe : T = superHero
}

val tower1 = Tower(batMan)
val tower2 = Tower(hulk)

// Second point
/*
case class Tower[T](superHero: T) {
    override def toString : String = s"This is the ${superHero} tower"
    def helpMe : T = superHero
}

Tower(10)*/
