package lectures.part2oop

object AnonymousClasses extends App {

	abstract class Animal {
		def eat: Unit
	}

	// anonymous class - an extended class of specified class
	val funnyAnimal: Animal = new Animal {
		override def eat: Unit = println("heeheeeheeeheeheee")
	}

	println(funnyAnimal.getClass)

	class Person(firstName: String) {
		protected val name: String = name

		def sayHi: Unit = println(s"Hi, my name is $name, how can I help you?")
	}

	val jim = new Person("Jim") {
		override def sayHi: Unit = println(s"Hi, my name is $name, how can I be of service to you?")
	}
}
