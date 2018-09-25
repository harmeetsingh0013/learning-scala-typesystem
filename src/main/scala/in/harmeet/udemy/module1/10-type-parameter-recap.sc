abstract class SuperHero { val team: String }

abstract class Marvel extends SuperHero

case class DrStrange(team: String) extends Marvel
case class Hulk(team: String) extends Marvel

abstract class DC extends SuperHero

case class BatMan(team: String) extends DC
case class Flash(team: String) extends DC

case class Tower[T <: SuperHero](superHero: T) {
    def teamName : String = superHero.team
}

val batMan = Tower(BatMan("JusticeLeague"))
val hulk = Tower(Hulk("Avengers"))

batMan.teamName
hulk.teamName

// What is we trying to access type directly like

//batMan.F
//hulk.F

// This is the same situation while we are declare parameter in class
// constructor

class Foo(x: Int) {
    val memberX: Int = x
}

//new Foo(9).x
new Foo(9).memberX

// The same problem with type as

//val superHero: batMan.F = batMan.superHero