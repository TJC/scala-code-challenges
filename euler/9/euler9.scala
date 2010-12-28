
def sqr(x: Int) = x * x

def isCandidate(a: Int, b: Int, c: Int) = {
    (a + b + c == 1000) &&
    a < b && b < c && (sqr(a) + sqr(b) == sqr(c))
}

for (i <- (1 to 900))
    for (j <- (1 to 500))
        for (k <- (1 to 500))
            if (isCandidate(i,j,k)) println(i + ", " + j + ", " + k)

