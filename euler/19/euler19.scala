import Stream.cons

case class myDate(day: Int, month: Int, year: Int) {
    val thirtys = List(4, 6, 9, 11)

    def next = (day,month) match {
        case (_, 2) => day match {
            case 29 => myDate(1, month+1, year)
            case 28 if ! isLeap(year) => myDate(1, month+1, year)
            case _ => myDate(day+1, month, year)
        }
        case (d, m) if thirtys.contains(m) => day match {
            case 30 => myDate(1, month+1, year)
            case _ => myDate(day+1, month, year)
        }
        case (d, m) => (day, month) match {
            case (31, 12) => myDate(1, 1, year+1)
            case (31, _) => myDate(1, month+1, year)
            case _ => myDate(day+1, month, year)
        }
    }

    def isLeap(y: Int) = y match {
        case (y) if y % 4 == 0 => true
        case _ => false
    }
}

object myDate {
    def dateseq(d: myDate) : Stream[myDate] = cons(d, dateseq(d.next))

    def epoch = myDate(1,1,1901)

    def finish = myDate(1,1,2001)

    def fullrange = myDate.dateseq(myDate.epoch).takeWhile(_ != finish)
}

object euler19 extends Application {
    // Date range starts on a wednesday, so idx=4 is Sunday

    val daycount =
      myDate.fullrange.zipWithIndex.
        filter { case(date,idx) => date.day==1 && (idx%7)==4 }.
        size

    println(daycount)
}

// We are given 1/1/1900=Monday, use this to determine 1/1/1901:
// myDate.dateseq(myDate(1,1,1900)).
//      takeWhile(_ != myDate(2,1,1901)).zipWithIndex.last.
//  foreach{ case (value,idx) => println(value, idx%7) }

