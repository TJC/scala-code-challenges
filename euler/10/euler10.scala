
// Find the sum of all the primes below two million.
import scala.math._

def isPrime(x: Long) : Boolean = x match {
    case 1 => false
    case 2 => true
    case _ => !( (2L to ceil(sqrt(x)).toLong).exists(i => x%i == 0) )
}

println( (2L to 1999999L).filter(isPrime).reduceLeft(_+_) )

