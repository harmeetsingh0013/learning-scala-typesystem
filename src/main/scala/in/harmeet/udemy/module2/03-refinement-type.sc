abstract class SuperHero { val team: String }

abstract class Marvel extends SuperHero

case class DrStrange(team: String) extends Marvel
case class Hulk(team: String) extends Marvel

abstract class DC extends SuperHero

case class BatMan(team: String) extends DC
case class Flash(team: String) extends DC

case class Tower[+F <: SuperHero](superHero: F)
val batManCave = Tower(BatMan("JusticeLeague"))
val hulkTower = Tower(Hulk("Avengers"))

def callingStarkTower(tower: Tower[Marvel]): Unit = {
    println(s"Method callingStarkTower: ${tower.superHero.team} Team Reporting...")
}

callingStarkTower(hulkTower)
//callingStarkTower(batManCave)

// So, how can we do this with type parameter
abstract class Tower2 {
    type SUPERHERO <: SuperHero
    val superHero: SUPERHERO
}

class BatManCave extends Tower2 {
    override type SUPERHERO = BatMan
    override val superHero = BatMan("JusticeLeague")
}

class HulkTower extends Tower2 {
    override type SUPERHERO = Hulk
    override val superHero = Hulk("Avengers")
}

def callingStarkTower2(tower: Tower2): Unit = {
    println(s"Method callingStarkTower2: ${tower.superHero.team} Team Reporting...")
}

callingStarkTower2(new HulkTower)
//callingStarkTower2(new BatManCave)

// How can we handle above issue with type parameters

def callingStarkTower3(tower: Tower2 { type SUPERHERO <: Marvel}): Unit = {
    println(s"Method callingStarkTower3: ${tower.superHero.team} Team Reporting...")
}


callingStarkTower3(new HulkTower)
//callingStarkTower3(new BatManCave)