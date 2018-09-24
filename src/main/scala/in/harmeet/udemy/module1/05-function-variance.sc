abstract class SuperHero { val team: String }

abstract class Marvel extends SuperHero

case class DrStrange(team: String) extends Marvel
case class Hulk(team: String) extends Marvel

abstract class DC extends SuperHero

case class BatMan(team: String) extends DC
case class Flash(team: String) extends DC

trait Movie {
    def description: String
}

case class Romantic(description: String) extends Movie
case class Action(description: String) extends Movie

def releaseMovie(f: Hulk => Movie) : Movie =
    f(Hulk("Avengers"))

val marvelMovie: Marvel => Movie =
    marvel => Action(s"${marvel.team} movie is always blockbuster")

releaseMovie(marvelMovie)

// The reason why Contra-variance allows super type only rather than subtype

/**

def releaseMovie(f: SuperHero => Movie) : Movie =
    f(Hulk("Avengers"))

val dcMovie: BatMan => Movie =
    dc => Action(s"${dc.team} movie is not look like blockbuster")

releaseMovie(dcMovie)

*/