package lectures.part4pm

import scala.util.Random

object PatternMatching extends App {
	val random = new Random
	val x = random.nextInt(10)

	val desc = x match {
		case 1 => "the one"
		case 2 => "double or nothing"
		case 3 => "the perfect number 3"
		// wildcard match - provides safety, else will result into MatchError if no case matches.
		case _ => "something else"
	}

	println(x)
	println(desc)

	// 1. Decompose values
	// PM works good on case classes as it provides case class matching OTB
	case class Person(name: String, age: Int)
	val bob = Person("bob", 20)

	val greeting = bob match {
		// case class matching. If it's not a case class, cases below will not work.
		case Person(n, a) if a < 21 => s"Hey there, my name is $n and I am $a"
		case Person(n, a) => s"Hi, my name is $n and I am $a years old"
		case _ => "I don't know who I am"
	}
	println(greeting)

	// PM on sealed hierarchies
	// sealed classes limit the cases for match thus help in avoiding unmatched issues
	sealed class Animal
	case class Dog(breed: String) extends Animal
	case class Parrot(greeting: String) extends Animal

	val animal: Animal = Dog("Terra Nova")
	// below warning is due to Animal class being sealed
	animal match {
		case Dog(someBreed) => println(s"Matched a dog of $someBreed breed")
	}
}
