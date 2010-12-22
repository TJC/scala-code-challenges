
// Find the sum of all the primes below two million.
import scala.math._

def isPrime(x: Int) : Boolean = x match {
    case 1 => false
    case 2 => true
    case _ => !( (2 to ceil(sqrt(x)).toInt).exists(i => x%i == 0) )
}

// Need to find a better way of handling this; if I call it the same
// name as isPrime, but try to dispatch to it with toInt, then it goes
// recursive.
def isBigPrime(x: BigInt) : Boolean = isPrime(x.toInt)

println( (BigInt(2) to BigInt(1999999)).filter(isBigPrime).reduceLeft(_+_) )

