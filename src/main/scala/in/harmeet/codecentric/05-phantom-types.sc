class Hacker {
    def hacksOn: Hacker = {
        println("Hacking , Hacking and Hacking")
        new Hacker
    }

    def drinkCoffee: Hacker = {
        println("Slurp.....")
        new Hacker
    }
}

val hacker = new Hacker
hacker.hacksOn.hacksOn // This should not compile, but it does!

