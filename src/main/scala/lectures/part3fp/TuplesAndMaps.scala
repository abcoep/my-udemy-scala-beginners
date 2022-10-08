package lectures.part3fp

object TuplesAndMaps extends App {
	// tuples: finite ordered lists
	val aTuple = Tuple2(2, "Hello, Scala")
	val coolTuple = (3, "Hello, World")

	println(coolTuple._1)
	println(coolTuple.copy(_2 = "Goodbye Java"))
	println(coolTuple.swap)

	// Maps
	val aMap: Map[String, Int] = Map()
	// throws exception if invalid key is accessed without the withDefaultValue
	val phoneBook = Map(("Jim", 555), ("jim", 777), "Amit" -> 999, "AMIT" -> 333).withDefaultValue(-1)
	println(phoneBook)
	if (phoneBook.contains("Jim")) println(phoneBook("Jim"))
	else println(phoneBook("NA"))

	// add a pairing
	val newPairing = "Mary" -> 678
	val newPhonebook = phoneBook + newPairing
	println(newPhonebook)

	// functions on maps
	// map, flatMap, filter
	println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

	// filterKeys
	println(phoneBook.view.filterKeys(_.startsWith("J")).toMap)
	// mapValues
	println(phoneBook.view.mapValues("+91" + _).toMap)

	// conversions to other collections
	println(phoneBook.toList)
	println(List("Daniel" -> 555).toMap)
	val names = List("Bob", "James", "Angela", "Mary", "Jim")
	println(names.groupBy(_.charAt(0)))
}
