
def isPalin(x: Int) = x.toString.reverse == x.toString

def findPalins(max: Int) = for {
    x <- (1 to max)
    y <- (1 to max)
    if isPalin(x*y)
} yield (x*y)

findPalins(999).sorted.foreach(println)

// 906609
