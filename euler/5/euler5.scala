
def hasFactorsTo(num: Int, max: Int) : Boolean =
    (2 to max).forall(i => num%i == 0)

println(
    (2 to 232792560).filter(hasFactorsTo(_, 20)).head
)

