package lectures.part2oop

object Inheritance extends App {

	// sealed limits extension only to classes present in the same file
	sealed class Animal {
		val habitat = "wild"
		// default public(no explicit 'public' keyword exists), can be protected or private
		def eat = println("munchmunch")

		// preventing overrides
		// 1. use final on member
		// 2. use final on the entire class
		// 3. seal the class
	}

	// Single class inheritance only
	class Cat extends Animal {
		override val habitat = "domestic"
		def slurp = {
			eat
			println("slurpslurp")
		}
	}

	val cat = new Cat
	cat.slurp

	// constructors
	class Person(name: String, age: Int) {
		def this(name: String) = this(name, 18)

	}
	class Adult(name:String, age: Int, idCard: String) extends Person(name)

	// overriding
	class Dog(override val habitat:String = "domestic") extends Animal {

		override def eat: Unit = {
			super.eat
			println("crunchcrunch")
		}
	}

	val dog = new Dog
	dog.eat
	println(dog.habitat)

	// type substitution
	val unknownAnimal: Animal = new Dog("K9")
	println(unknownAnimal.eat)
}
