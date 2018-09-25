abstract class SuperHero { val team: String }

abstract class Marvel extends SuperHero

case class DrStrange(team: String) extends Marvel
case class Hulk(team: String) extends Marvel

abstract class DC extends SuperHero

case class BatMan(team: String) extends DC
case class Flash(team: String) extends DC

abstract class Tower {
    type SH <: SuperHero
    val superHero: SH
    def teamName: String = s"I am ${superHero.team}"
}

class HulkTower(val superHero: Hulk) extends Tower {
    type SH = Hulk
}

val hulkTower : HulkTower = new HulkTower(Hulk("Avengers"))

val hulk1 = hulkTower.superHero

val hulk2: Hulk = hulkTower.superHero

val hulk3: hulkTower.SH = hulkTower.superHero

val hulk4: HulkTower#SH = hulkTower.superHero // This is called ype projection

// There is another way for creating different types of tower like HulkTower
// with Singleton object

object TowerOfHero{
    def apply[F <: SuperHero](f: F) = new Tower {
        override type SH = F
        override val superHero : SH = f
    }
}

// Notation Tower { type SH = DrStrange } called refinement of type
val drStrangeTower: Tower { type SH = DrStrange } = TowerOfHero(DrStrange("Avengers"))

val hulkTower2: Tower { type SH = Hulk } = TowerOfHero(Hulk("Avengers"))

val drStrange1  = drStrangeTower.superHero

val drStrange2: DrStrange = drStrangeTower.superHero

val drStrange3: drStrangeTower.SH  = drStrangeTower.superHero

val drStrange4: Tower#SH  = drStrangeTower.superHero

// Quiz ??????

//val dtStrange5: drStrangeTower.SH = hulkTower2.superHero

//val hulk5: HulkTower#SH = hulkTower2.superHero

//val hulk6: hulkTower.SH = hulkTower2.superHero

// Try with Batman ???