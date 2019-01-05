// constraints

trait Food
trait FastFood extends Food
trait HealthyFood extends Food

class Burger extends FastFood
class Noodles extends FastFood

class Vegetables extends HealthyFood
class Fruits extends HealthyFood

case class Box(food: Food)

class Store {
    def orderYourFood(food: String): Box = food match {
        case "Burger" => Box(new Burger)
        case "Noodles" => Box(new Noodles)
        case "Vegetables" => Box(new Vegetables)
        case "Fruits" => Box(new Fruits)
    }

    def orderYourFastFood(fastFood: String): Box = fastFood match {
        case "Burger" => Box(new Burger)
        case _ => throw new RuntimeException
    }
}

val store = new Store
store.orderYourFood("Burger")
store.orderYourFood("Noodles")
store.orderYourFood("Vegetables")
store.orderYourFood("Fruits")

store.orderYourFastFood("Burger")
//store.orderYourFastFood("Noodles")
