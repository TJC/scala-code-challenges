package tjc.euler

import scala.math._
import scala.Stream.cons

object common {

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

    def isPrime(x: Long) : Boolean = x match {
        case 1 => false
        case 2 => true
        case _ => !( (2L to ceil(sqrt(x)).toLong).exists(i => x%i == 0) )
    }

    def sumDigits(x: Long) =
        x.toString.toCharArray.map(_.toString.toInt).reduceLeft(_+_)

    def sumDigits(x: BigInt) =
        x.toString.toCharArray.map(_.toString.toInt).reduceLeft(_+_)

}
