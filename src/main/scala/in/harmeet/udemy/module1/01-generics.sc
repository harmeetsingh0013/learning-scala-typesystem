abstract class SuperHero { val team: String }

abstract class Marvel extends SuperHero

case class DrStrange(team: String) extends Marvel
case class Hulk(team: String) extends Marvel

abstract class DC extends SuperHero

case class BatMan(team: String) extends DC
case class Flash(team: String) extends DC

val batMan = BatMan("JusticeLeague")
val hulk = Hulk("Avengers")

def fight(superHero: SuperHero) = s"$superHero ready for fight"

fight(batMan)
fight(hulk)

// Problem without generics

case class Tower(superHero: SuperHero) {
    override def toString : String = s"This is the ${superHero.team} tower"
    def helpMe : SuperHero = superHero
}

val jlTower = Tower(batMan)
val avTower = Tower(hulk)

jlTower.helpMe
avTower.helpMe

// Solution with generics

case class Tower2[T](superHero: T) {
    override def toString : String = s"This is the ${superHero} tower"
    def helpMe = superHero
}

val jlTower2 : Tower2[BatMan] = Tower2(batMan)
val avTower2 : Tower2[Hulk] = Tower2(hulk)

jlTower2.helpMe
avTower2.helpMe