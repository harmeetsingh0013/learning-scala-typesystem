trait CompareT[T] {
    def >(compareT: T): Boolean
    def <(compareT: T): Boolean
}

def getInsert[T <: CompareT[T]](item: T, rest: List[T]): List[T] = rest match {
    case Nil => List(item)
    case head :: _ if item < head => item :: rest
    case head :: tail => head :: getInsert(item, tail)
}

def getSort[T <: CompareT[T]](items: List[T]): List[T] = items match {
    case Nil => Nil
    case head :: tail => getInsert(head, getSort(tail))
}

case class Distance(meters: Int) extends CompareT[Distance] {
    override def >(compareT : Distance) = this.meters > compareT.meters

    override def <(compareT : Distance) = this.meters < compareT.meters
}

val d1 = Distance(10)
val d2 = Distance(40)
val d3 = Distance(1)
val d4 = Distance(10)

getSort(List(d1, d2, d3, d4))