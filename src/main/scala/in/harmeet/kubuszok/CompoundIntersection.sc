// Compound and intersection type

trait Str { def str: String }
trait Count { def count: Int }

def repeat(cd: Str with Count ): String =
    Iterator.fill(cd.count)(cd.str).mkString

val cd = new Str with Count {
    val str = "  James  "
    val count = 5
}

repeat(cd)

// it follows the mathematical definition
// x∈A∩B⟺x∈A∧x∈B⟺x∈B∧x∈A⟺x∈B∩A
// as The order of Composing type using with does not matter.

val sc: Str with Count
val cs: Count with Str

//repeat(sc) // work as expected
//repeat(cs)

/**  ---------------------------------------------------------------
              -----------------------------------------
     --------------------------------------------------------------- */

// Composing type with diamond problem

trait A { def value = 10 }
trait B extends A { override def value : Int = super.value * 2 }
trait C extends A { override def value : Int = super.value + 2 }
(new B with C ).value // ???
(new C with B ).value // ???

// How scala deals with this problem ???

trait X extends A with B with C

// is actually happens like

trait AnonymousB extends A {
    // B overrides A
    override def value : Int = super.value * 2
}

trait AnonymousC extends AnonymousB {
    // C overrides B
    override def value : Int = super.value + 2
}

trait X1 extends AnonymousC // X1 means X

val x1 = new X1{}.value

// Another one

trait Y extends A with C with B

trait AnonymousCY extends A {
    // C overrides A
    override def value : Int = super.value + 2
}

trait AnonymousBY extends AnonymousCY {
    // B overrides C
    override def value : Int = super.value * 2
}

trait Y1 extends AnonymousBY

val y1 = new Y1{}.value




