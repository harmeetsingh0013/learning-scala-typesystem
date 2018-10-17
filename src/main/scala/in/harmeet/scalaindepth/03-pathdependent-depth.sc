trait Observable {
    type Handle

    var callbacks = Map[Handle, this.type => Unit]()

    def observe(callback: this.type => Unit): Handle = {
        val handle = createHandle(callback)
        callbacks += (handle -> callback)
        handle
    }
    // The type
    // this.type is a mechanism in Scala to refer to the type of the current object

    def unobserve(handle: Handle): Unit = {
        callbacks -= handle
    }

    def createHandle(function: this.type => Unit): Handle

    def notifyListeners(): Unit = for(callback <- callbacks.values) callback(this)
}

trait DefaultHandlers extends Observable {
    override type Handle = (this.type  => Unit)

    override def createHandle(callback : this.type => Unit) : Handle = callback
}

class IntStore(private var value: Int) extends Observable with DefaultHandlers {
    def get: Int = value
    def set(newValue: Int) = {
        value = newValue
        notifyListeners()
    }

    override def toString : String = s"IntStore( $value )"
}

val x = new IntStore(22)

x.observe(println)