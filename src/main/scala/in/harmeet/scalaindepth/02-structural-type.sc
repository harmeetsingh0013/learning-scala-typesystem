//Structural types are usually implemented with reflection. Reflection isn’t always available on
//every platform and it can lead to performance issues. It’s best to provide named interfaces
//rather than use structural types in the general case. However for nonperformance sensitive
//situations, they can be very useful

object Resources {
    type Resource = {
        def close(): Unit
    }

    def closeResource(r: Resource) = r.close()
}

Resources.closeResource(System.in)