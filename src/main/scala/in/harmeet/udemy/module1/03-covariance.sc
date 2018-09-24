abstract class SuperHero { val team: String }

abstract class Marvel extends SuperHero

case class DrStrange(team: String) extends Marvel
case class Hulk(team: String) extends Marvel

abstract class DC extends SuperHero

case class BatMan(team: String) extends DC
case class Flash(team: String) extends DC

val batMan = BatMan("JusticeLeague")
val hulk = Hulk("Avengers")

case class Tower[+T](superHero: T) {
    override def toString : String = s"This is the ${superHero} tower"
    def helpMe : T = superHero
}

def callingToTheTower(tower: Tower[SuperHero]): String = {
    s"From tower ${tower.helpMe.team}, hero's will be come for save the day"
}

val tower1 : Tower[DC] = Tower(batMan)
val tower2 : Tower[Marvel] = Tower(hulk)

val team1 = callingToTheTower(tower1)
val team2 = callingToTheTower(tower2)

// Covariance Flips without generics

def dialHeroCode(code: Int): SuperHero = code match {
    case 131 => BatMan("JusticeLeague")
    case 132 => Flash("JusticeLeague")
    case 133 => Hulk("Avengers")
    case 134 => DrStrange("Avengers")
}

val hero1 = dialHeroCode(133)
val hero2 = dialHeroCode(134)

// Covariance Flips with Generics

case class City[+T](name: String, superHero: T) {
    def calling: T = superHero
}

def dialHeroCode2(code: Int): City[SuperHero] = code match {
    case 131 => City("Gotham", BatMan("JusticeLeague"))
    case 132 => City("", Flash("JusticeLeague"))
    case 133 => City("", Hulk("Avengers"))
    case 134 => City("", DrStrange("Avengers"))
}

val hero21 = dialHeroCode2(131).superHero
val hero22 = dialHeroCode2(132).superHero