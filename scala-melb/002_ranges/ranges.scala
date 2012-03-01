/*

// This method works, but I'm trying to shrink it in the form further down..

def ranges(ints: Seq[Int]): Seq[(Int, Int)] = {
    ints.sorted.foldLeft( Seq[(Int,Int)]() )(
        (acc: Seq[(Int,Int)], n: Int) => acc match {
            case acc if (acc.nonEmpty) => acc.last match {
                case (a,z) if (z == n) => acc
                case (a,z) if (z+1 == n) => acc.init :+ (a, n)
                case _ => acc :+ (n,n)
            }
            case _ => acc :+ (n,n)
        }
    )
}

*/

def ranges(ints: Seq[Int]): Seq[(Int, Int)] = {
    ints.sorted.foldLeft( Seq[(Int,Int)]() )(
        (acc: Seq[(Int,Int)], n: Int) => acc match {
            // case Nil => acc :+ (n,n)
            case x :: (a,z) if (z == n) => acc
            case x :: (a,z) if (z+1 == n) => x :+ (a, n)
            case _ => acc :+ (n,n)
        }
    )
}

assert(ranges(Seq()) == Seq()) // empty
assert(ranges(Seq(1)) == Seq((1,1))) // single value
assert(ranges(Seq(1,2,3)) == Seq((1,3))) // single range
assert(ranges(Seq(1,2,3,9)) == Seq((1,3),(9,9))) // 1 range, 1 value
assert(ranges(Seq(1,2,3,7,8,9)) == Seq((1,3),(7,9))) // two ranges
assert(ranges(Seq(5,7,3)) == Seq((3,3),(5,5),(7,7))) // distinct values unordered
assert(ranges(Seq(6,4,5)) == Seq((4,6))) // range unordered

// vim: set ts=4 sw=4 et:
