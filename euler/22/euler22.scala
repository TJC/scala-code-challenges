val file = io.Source.fromFile("names.txt")
val names = file.mkString.split(",").toList.sorted

def scoreName(name: String) = {
    val aVal = 'A'.toInt - 1
    name.replace("\"","").toCharArray.map(c => c.toInt - aVal).reduceLeft(_+_)
}

// My original method:
val results =
    for (i <- 0 until names.size) yield scoreName(names(i)) * (i+1)

results.reduceLeft(_+_)

// More functional method found after consulting community:
names.zipWithIndex.foldLeft(0){(acc, next) =>
    val (name, i) = next
    acc + scoreName(name) * (i+1)
}

