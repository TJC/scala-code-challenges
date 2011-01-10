// What is the value of the first triangle number to have over five hundred
// divisors?

import Stream.cons
import scala.math._

def triangles : Stream[Long] = {
    def _triangle(count: Long, accum: Long) : Stream[Long] =
        cons( accum + count, _triangle(count + 1, accum + count) )

    _triangle(1, 0)
}

// def divisors(x: Long) = (1L to x).filter(i => x%i == 0)

// not valid for x<4
def numdivisors(x: Long) : Int = {
    var count = 1
    val root = sqrt(x).toLong
    for (i <- 2L to root)
        if (x%i == 0)
            count += 2
    if (x == root*root) count += 1
    
    count
}

triangles.dropWhile(numdivisors(_) <= 500).take(1).print
