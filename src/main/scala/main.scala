import java.nio.file.{Files, Path}

@main def main(): Unit =
  check("1abc2", 12)
  check("pqr3stu8vwx", 38)
  check("a1b2c3d4e5f", 15)
  check("treb7uchet", 77)

  val input = Files.readString(Path.of("src", "2023.01.txt"))
  println(part1(input))

private def part1(input: String): Int =
  input.trim.split("\n").map { line =>
    val first = line.find(_.isDigit).getOrElse(0)
    val last = line.findLast(_.isDigit).getOrElse(0)
    s"$first$last".toInt
  }.sum

private def check(str: String, res: Int): Unit =
if (part1(str) != res)
    throw new RuntimeException(s"Assertion failed: $str is not $res")

