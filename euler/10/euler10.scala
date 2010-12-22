
// Find the sum of all the primes below two million.
import scala.math._

def isPrime(x: Int) : Boolean = !( (2 to ceil(sqrt(x)).toInt).exists(i => x%i == 0) )

println( (2 to 1999999).filter(isPrime).reduceLeft(_+_) )
