package lectures.part2oop

import scala.annotation.targetName
import scala.language.postfixOps

object MethodNotations extends App {

	class Person(val name: String, favoriteMovie: String, val age: Int) {
		def likes(movie: String): Boolean = movie == favoriteMovie

		@targetName("plus")
		def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

		@targetName("plus")
		def +(nickName: String): Person = new Person(s"$name ($nickName)", favoriteMovie, age)

		@targetName("age increment")
		def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

		@targetName("applaud")
		def unary_! : String = s"$name, you are awesome!"

		def learns(subject: String): String = s"$name learns $subject"

		def learnsScala: String = this learns "Scala"

		def isAlive: Boolean = true

		def apply(): String = s"Hi, my name is $name, I'm $age and I like $favoriteMovie"

		def apply(watchCount: Int = 1): String =
			s"$name watched $favoriteMovie $watchCount ${if (watchCount > 1) "times" else "time"}"

	}

	val mary = new Person("Mary", "Inception", 18)
	println(mary.likes("Inception"))
	// Infix/operator notation - single parameters only
	println(mary likes "Inception")

	val tom = new Person("Tom", "Ocean's Eleven", 21)
	println(mary + tom)
	println(mary.+(tom))
	// All operators are methods
	println(1.+(2))

	// Prefix notation
	val x = -1
	val y = 1.unary_-
	println(x == y)

	println(!mary)

	// Postfix notation - parameterless methods only
	println(mary isAlive)

	// apply
	println(mary.apply())
	println(mary())

	val rockstarMary = mary + "the rockstar"
	println(rockstarMary())

	println(+rockstarMary.age)
	println((+rockstarMary).age)

	println(rockstarMary learnsScala)

	println(rockstarMary(2))
}
