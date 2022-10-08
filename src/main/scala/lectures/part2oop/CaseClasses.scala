package lectures.part2oop

object CaseClasses extends App {
	case class Person(name: String, age: Int)
	// 1. CC (case class) parameters are fields
	val jim = new Person("Jim", 34)
	println(jim.name)

	// 2. a good default toString that shows fields
	println(jim)

	// 3. equals and hashCode implemented OOTB
	val jim2 = new Person("Jim", 34)
	println(jim == jim2)

	// 4. handy copy method
	val olderJim = jim.copy(age = 45)
	println(olderJim)

	// 5. default companion object
	val aPerson = Person
	val mary = Person("Mary", 23)

	// 6. are serializable - important for Akka for sending objects over network

	// 7. have extractor patterns => they can be used in Pattern Matching

	// Case object
	case object UnitedKingdom {
		def name: String = "The UK of GB and NI"
	}

}
