
// What is the largest prime factor of 600851475143 ?

import scala.math._

//val target = 13195L
val target = 600851475143L


def isPrime(x: Long) : Boolean = x match {
    case 1 => false
    case 2 => true
    case _ => !( (2 to ceil(sqrt(x)).toInt).exists(i => x%i == 0) )
}

def isFactor(x: Long, f: Long) : Boolean = x%f == 0
//    val r = x / f
//    return r * f == x
//}


var i = 2L
var cur = target
while (i < target) {
    if (isFactor(cur, i)) {
        println(i)
        cur = cur / i
    }
    i += 1
}

// Range() broke due to value too high
// (Long(1) until (target/2)).filter(isFactor(target, _)).foreach(println)
