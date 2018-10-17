// path dependent types

class Outer {
    trait Inner
    def y = new Inner {}
    def foo(x: this.Inner) = null // this.Inner is called path dependent
    def bar(x: Outer#Inner) = null //Outer#Inner is called type projection
}

val x = new Outer

val y = new Outer

val xin = x.y

x.foo(xin)

x.bar(xin)


//y.foo(xin)

//y.bar(xin)

// Another Example

class Parent {
    class Child
    def kids = new Child
}

class ChildrenContainer(val p: Parent) {
    type ChildOfThisParentOnly = p.Child

    def admission(c: ChildOfThisParentOnly): Unit = {
        println(c)
    }

//    def registerName = admission(p.kids)
}

val parent1 = new Parent
val parent2 = new Parent

val kinderGarden = new ChildrenContainer(parent1)

//kinderGarden.admission(parent1.kids)
//kinderGarden.admission(parent2.kids)

// Another Example
// All path-dependent types are types projection

class AnotherClass(o: Outer) {

    def foo(inner: o.type#Inner) = null

    def bar(inner: Outer#Inner) = null

    foo(o.y)
}

//new AnotherClass(x).foo(x.y)
//new AnotherClass(x).bar(x.y)