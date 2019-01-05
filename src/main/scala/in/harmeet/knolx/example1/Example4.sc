trait Food
trait FastFood extends Food
trait HealthyFood extends Food

class Burger extends FastFood
class Noodles extends FastFood

class Vegetables extends HealthyFood
class Fruits extends HealthyFood

case class Box(food: Food)

class Store {
    def orderYourFastFood[T >: Burger]: Box = Box(new Burger)
}

val store = new Store
store.orderYourFastFood[Burger]
//store.orderYourFastFood[Noodles]

