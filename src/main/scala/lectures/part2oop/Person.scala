package lectures.part2oop

object Person extends App {

	val person = new Person("Amit", 27)
	// println(person.name) -> name is parameter, not a field
	println(person.firstName)
	println(person.age)

	person.greet("Saurabh")
	person.greet()

	val person2 = new Person("defaultHuman")
	person2.greet()
}

// val changes parameter to class field
case class Person(name: String, val age: Int = 12) {

	val firstName = name

	def greet(name: String = "XYZ"): Unit = println(s"Hi $name, my name is ${this.name} and I'm $age yrs old")

	def greet(): Unit = println(s"My name is $name and I'm $age yrs old")

	// Auxiliary constructor - can call only another constructor
	def this(name: String) = {
		// println("Returns Unit, thus not valid")
		this(name, 18)
		// println("Returns Unit too, thus not valid")
	}
}
