// http://projecteuler.net/index.php?section=problems&id=21

def min(a: Int, b: Int) = (a < b) match {
    case true => a
    case false => b
}

def max(a: Int, b: Int) = (a > b) match {
    case true => a
    case false => b
}

def divisors(x: Int) = (1 to max(1,x-1)).filter(i => x%i == 0)

def divsum(x: Int) = divisors(x).foldLeft(0)(_+_)

def isAmicable(a: Int, b: Int) =
    a != b && divsum(a) == b && divsum(b) == a


(1 until 10000).filter(i => isAmicable(i, divsum(i))).reduceLeft(_+_)

