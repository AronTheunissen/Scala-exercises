@main def hello: Unit = 
  val list = makeList()
  println("The list contains the following numbers: " +list)
  val highest = findHighest(list)
  println("The highest number in the list is " +highest)
  var (lowest, secondLowest) = findLowest(list)
  println("The lowest two numbers are " +lowest +" and " +secondLowest)
  var evenList = findEven(list)
  println("All values that are even are " +evenList)
  var (divideTwoList, divideThreeList, divideFiveList, restList) = splitList(list)
  println("Numbers divisible by two from the list are " +divideTwoList)
  println("Numbers divisible by three from the list are " +divideThreeList)
  println("Numbers divisible by five from the list are " +divideFiveList)
  println("Numbers not divisible by two, three or five from the list are " +restList)
  var sortedList = sortList(list)
  println("Sorting the numbers from the list makes it as follows: " +sortedList)


def makeList() : List[Int] = {
  val list = List.fill(10)(100).map(scala.util.Random.nextInt)
  return list
}

def findHighest(x : List[Int]) : Int = {
  var highest = 0
  for( a <- x){
    if (a > highest) highest = a
  }
  return highest
}

def findLowest(x : List[Int]) : (Int, Int) = {
  var lowest = 100
  var secondLowest = 100
  for( a <- x){
    if (a < lowest) {
    secondLowest = lowest 
    lowest = a
    }
    else if (a < secondLowest) secondLowest = a
  }
  return (lowest, secondLowest)
}

def findEven(x : List[Int]) : List[Int] = {
  val evenList = x.filter(y=>{y % 2 == 0})
  return evenList
}

def splitList(x : List[Int]) : (List[Int], List[Int], List[Int], List[Int]) = {
  val divideTwoList = x.filter(y=>{y % 2 == 0})
  val divideThreeList = x.filter(y=>{y % 3 == 0})
  val divideFiveList = x.filter(y=>{y % 5 == 0})
  val restList = x.filter(y=>{!((divideTwoList contains y) || (divideThreeList contains y) || (divideFiveList contains y)) })
  return (divideTwoList, divideThreeList, divideFiveList, restList)
}

def sortList(x : List[Int]) : List[Int] = {
  val sortedList = x.sorted
  return sortedList
}

