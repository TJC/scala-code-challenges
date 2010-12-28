
def fact(x: BigInt) = (x to BigInt(2) by -1).reduceLeft(_*_)

val bignum = fact(100)

bignum.toString.toCharArray.map(_.toString.toInt).reduceLeft(_+_)
    
