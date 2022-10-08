package lectures.part2oop

object AbstractDataTypes extends App {

	abstract class Animal {
		val habitat: String
		def eat: Unit
	}

	class Dog extends Animal {
		override val habitat: String = "domestic"
		def eat: Unit = println("crunchcrunch")
	}

	// traits vs abstract class
	// 1. do not have constructors
	// 2. multiple traits can be inherited but only one abstract class can be inherited
	// 3. describe behavior, abstract class describe entities
	trait Carnivore {
		def eat(animal: Animal): Unit
		val preferredMeal: String = "fresh meat"
	}

	trait ColdBlooded

	class Crocodile extends Animal with Carnivore with ColdBlooded {
		val habitat: String = "water"
		def eat: Unit = println("gumpgump")
		def eat(animal: Animal): Unit = {
			println(s"I'm a croc and I'm eating an animal from ${animal.habitat}")
			eat
		}
	}

	val dog = new Dog
	val croc = new Crocodile
	croc.eat(dog)
}
