def sqr(x: Long) = x * x

val amount = 100L

def sumsqrs() = (1L to amount).map(sqr).reduceLeft(_+_)

def sqrsums() = sqr( (1L to amount).reduceLeft(_+_) )

println( sqrsums - sumsqrs )
