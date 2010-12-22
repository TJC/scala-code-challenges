
// Find the sum of all the primes below two million.
import scala.math._

def isPrime(x: Int) : Boolean = x match {
    case 1 => false
    case 2 => true
    case _ => !( (2 to ceil(sqrt(x)).toInt).exists(i => x%i == 0) )
}

println( (2 to 1999999).filter(isPrime).reduceLeft(_+_) )
