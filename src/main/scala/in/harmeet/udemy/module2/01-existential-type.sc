// how can we create declare the List without generics

//def customList(list: List) = list.length

// For this, we have existential type in scala

import language.existentials

def customList(list: List[T forSome { type T}]) : Int = list.length

// short cut for this definition
def customList2(list: List[_]) : Int = list.length

abstract class SuperHero { val team: String }

abstract class Marvel extends SuperHero

case class DrStrange(team: String) extends Marvel
case class Hulk(team: String) extends Marvel

abstract class DC extends SuperHero

case class BatMan(team: String) extends DC
case class Flash(team: String) extends DC

def superHeroTeams[T <: SuperHero](superHero: List[T]) : Set[String] =
    superHero.map(_.team).toSet
def superHeroTeams2(superHero: List[T forSome { type T <: SuperHero}]) : Set[String] =
    superHero.map(_.team).toSet
def superHeroTeams3(superHero: List[_ <: SuperHero]) : Set[String] =
    superHero.map(_.team).toSet

val batMan = BatMan("JusticeLeague")
val hulk = Hulk("Avengers")
val strange = DrStrange("Avengers")
val flash = Flash("JusticeLeague")

superHeroTeams(List(batMan, hulk, flash, strange))
superHeroTeams2(List(batMan, hulk, flash, strange))
superHeroTeams3(List(batMan, hulk, flash, strange))