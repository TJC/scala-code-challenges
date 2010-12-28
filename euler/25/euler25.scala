import Stream.cons

def fib : Stream[BigInt] = {
    def fibi(a: BigInt, b: BigInt) : Stream[BigInt] =
        cons(a, fibi(b, a+b))

    fibi(1,1)
}

val term = fib.takeWhile(_.toString.size < 1000).size + 1

println(term)

