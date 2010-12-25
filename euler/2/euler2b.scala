
// Working, but not idiomatic Scala..

var prev = 0
var cur = 1
var next = 0
var total = 0

while (cur <= 4000000) {
    next = cur+prev
    prev = cur
    cur = next

    if (prev%2 == 0) {
        total += prev
    }
}

println(total)

// = 4613732 (correct)
