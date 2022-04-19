import scala.util.Random
import scala.io.StdIn._

@main def hangman: Unit = 
  val (gameWin, word) = playGame()
  if (gameWin) {
    println("You have found the word! Congratulations! The word was " +word)
  }
  else {
    println("You ran out of attempts... The correct word was " +word)
  }

  
  



def getWord() : String = {
  val list = List("apple", "oranges", "pears", "bodywax", "fluffy", "jazz", " buzz", "rhythm", "pathetic", "pink", "blue", "red", "orange", "potato", "eccentric", "carpet", "sassy", "card", "between", "vanilla", "thyme", "time", "fox", "dog", "rat", "fair")
  list(Random.nextInt(list.length))
  
}

def getCharacters(x : String) : (List[Char], List[Char]) = {
  val characters = x.toList
  var underScores = List.fill(x.length)('_')
  (characters, underScores)
}

def playGame() : (Boolean, String) = {
  val word = getWord()
  var remainingWrongAttempts = 10
  var (toGuessLetters, guessedLetters) = getCharacters(word)
  while ((remainingWrongAttempts > 0) && (guessedLetters.contains('_'))) {
    println("You have " +remainingWrongAttempts +" possible mistakes left.")
    println(guessedLetters.mkString)
    println("What letter would you like to guess?")
    var guessingLetter = readChar()
    var correctGuessed = 0
    if toGuessLetters.contains(guessingLetter) then
      guessedLetters = toGuessLetters.zip(guessedLetters).map((a, b) => if guessingLetter == a then a else b)
      correctGuessed += 1
    if (correctGuessed == 1) {
      println("Correct! The letter " +guessingLetter + " was in the word.")
    }
    else {
      remainingWrongAttempts -= 1
      println("Nope, The letter " +guessingLetter + " was not in the word.")
    }
  }
  (remainingWrongAttempts != 0, word)
}
