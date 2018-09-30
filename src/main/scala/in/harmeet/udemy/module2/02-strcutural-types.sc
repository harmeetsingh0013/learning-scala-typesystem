// Structural types mostly used with existential types
// rather than bound on the Type we can bound on the behavior as well

abstract class SuperHero { val team: String }

abstract class Marvel extends SuperHero

case class DrStrange(team: String) extends Marvel
case class Hulk(team: String) extends Marvel

abstract class DC extends SuperHero

case class BatMan(team: String) extends DC
case class Flash(team: String) extends DC

import language.reflectiveCalls

def superHeroTeams(superHeros: List[_ <: {def team: String}]) : Set[String] =
    superHeros.map(_.team).toSet

val batMan = BatMan("JusticeLeague")
val hulk = Hulk("Avengers")
val strange = DrStrange("Avengers")
val flash = Flash("JusticeLeague")

superHeroTeams(List(batMan, hulk, flash, strange))

// This is also called duck typing, "Quack Like A Duck, Walk Like A Duck,
// Swim Like A Duck than means Type is Duck"

// When Structural typing is require ??

val s: String = "Knoldus"
s.length
val any: Any = s
//any.length


// Structural types come into the picture
any.asInstanceOf[{def length(): Int}].length()

// You can also try with super hero types.
