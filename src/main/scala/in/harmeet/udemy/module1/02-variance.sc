abstract class SuperHero { val team: String }

abstract class Marvel extends SuperHero

case class DrStrange(team: String) extends Marvel
case class Hulk(team: String) extends Marvel

abstract class DC extends SuperHero

case class BatMan(team: String) extends DC
case class Flash(team: String) extends DC

val batMan = BatMan("JusticeLeague")
val hulk = Hulk("Avengers")

case class Tower[T](superHero: T) {
    override def toString : String = s"This is the ${superHero} tower"
    def helpMe : T = superHero
}

def callingToTheTower(tower: Tower[SuperHero]): String = {
    s"From tower ${tower.helpMe.team}, hero's will be come for save the day"
}

val tower1 = Tower(batMan)
val tower2 = Tower(hulk)

//val team1 = callingToTheTower(tower1)
//val team2 = callingToTheTower(tower2)