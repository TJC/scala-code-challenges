import scala.math._
import scala.io.Source

object eighteen {
    def main(args: Array[String]) = {
        val triangle = loadData("data.txt")
        val finalRow = reduce(triangle.reverse)

        finalRow.foreach(println)
    }

    def sumRows(one: List[Int], two: List[Int]) : List[Int] =
        one.zip(two).map{ case(a,b) => a+b }

    def pairMaxs(row: List[Int]) : List[Int] =
        row.zip(row.tail).map{ case (a,b) => max(a,b) }

    def reduce(rows: List[List[Int]]) : List[List[Int]] =
        rows match {
            case Nil => List()
            case row :: Nil => List(row)
            case row :: sub :: tail => reduce(
                sumRows(pairMaxs(row), sub) :: tail
            )
        }

    def loadData(file: String) =
        Source.fromFile("data.txt").getLines.map(
            _.split(" ").map(_.toInt).toList
        ).toList

}

