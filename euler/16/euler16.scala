
// Using BigInt seems like cheating, almost..

val bignum = BigInt(2).pow(1000)
bignum.toString.toCharArray.map(_.toString.toInt).reduceLeft(_+_)

