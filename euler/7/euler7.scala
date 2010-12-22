
// Find the 10001st prime number

import scala.math._

def isPrime(x: Int) : Boolean = !( (2 to ceil(sqrt(x)).toInt).exists(i => x%i == 0) )

var i = 1
var n = 1

while (i < 10001) {
    n += 1
    while (! isPrime(n)) { n += 1 }
    i += 1
}
println(i + "th prime is: " + n)

