val h1 = "Hello"
val h2 = "Hello"

def hello(h: h1.type ): String =
    s"$h"

hello(h1)
//hello(h2)

// Use for create DSL
val or = "or"
val to = "to"

object To {
    def be(o: or.type ) = this
    def not(t: to.type ) = this
    def be = "That is the question"
}

To be or not to be