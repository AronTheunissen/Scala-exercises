import java.util.Scanner
import scala.io.StdIn._
import math.Integral.Implicits.infixIntegralOps

@main def leap: Unit = 
  println("What year do you want to check for being a leap year?")
  val line = readLine()
  val year = line.filter(_.isDigit).toInt
  if (year % 400 == 0) println(" The year " +year +" is a leap year")
  else if (year % 100 == 0) println("The year " +year +" is not a leap year")
  else if (year % 4 == 0) println("The year " +year +" is a leap year")
  else println("The year " +year +" is not a leap year")

def msg = "I was compiled by Scala 3. :)"
