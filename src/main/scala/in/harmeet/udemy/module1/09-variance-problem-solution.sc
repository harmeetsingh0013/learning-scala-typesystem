import com.sun.javafx.css.converters.EffectConverter.DropShadowConverter

abstract class SuperHero { val team: String }

abstract class Marvel extends SuperHero

case class DrStrange(team: String) extends Marvel
case class Hulk(team: String) extends Marvel

abstract class DC extends SuperHero

case class BatMan(team: String) extends DC
case class Flash(team: String) extends DC

case class FightClub[T <: SuperHero](s1: T, s2: T) {
    override def toString : String =
        s"${s1} and ${s2} start fight ... "
}

val teams1: FightClub[SuperHero] = FightClub(BatMan("JusticeLeague"), Hulk("Avengers"))

// Fans of DC and Marvel always fight for best, that's why for conclusion
// So, they create a game where you can select your hero and
// Pass any opponent super hero for fight

case class GameFight[+F <: SuperHero](player: F) {
    override def toString : String =
        s"${player} Ready ... "

//    def fight(opponent: F) = FightClub(player, opponent)
}

// For solving these types of problems Scala type system provide us a way

/*
case class GameFight[+F <: SuperHero](player: F) {
    override def toString : String =
        s"${player} Ready ... "

    def fight[M >: F <: SuperHero](opponent: M) = FightClub(player, opponent)
}

val game1: FightClub[SuperHero] =
    GameFight(DrStrange("Avengers")).fight(BatMan("JusticeLeague"))*/
