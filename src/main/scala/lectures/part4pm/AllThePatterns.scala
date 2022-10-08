package lectures.part4pm

import exercises.MyList
import lectures.part2oop.Person

object AllThePatterns extends App {
	// 1. constants
	val x: Any = "Scala"
	val constants = x match {
		case 1 => "a number"
		case "Scala" => "The Scala"
		case true => "The Truth"
		case AllThePatterns => "A singleton object"
	}
	println(constants)

	// 2. match anything
	// 2.1 wildcard
	val matchAnything = x match {
		case _ => "matched anything"
	}
	println(matchAnything)

	// 2.2 variable
	val matchAVariable = x match {
		case something => s"I've found $something"
	}
	println(matchAVariable)

	// 3. tuples
	val aTuple = (1, 2)
	val matchATuple = aTuple match {
		case (1, 1) =>
		case (something, 2) => s"I've found $something with 2"
	}
	println(matchATuple)
	val nestedTuple = (1, (2, 3))
	val matchANestedTuple = nestedTuple match {
		case (_, (2, v)) => s"Got something with (2, $v)"
	}
	println(matchANestedTuple)

	// 4. case classes - constructor pattern
	val aPerson: Person = new Person("Dan", 38)
	val matchAList = aPerson match {
		case Person("Dan", _) => "This is Super Dan"
		case Person(name, age) if age < 21 => s"Hey this is $name and I'm $age"
		case _ => "Anonymous"
	}
	println(matchAList)

	// 5. list patterns
	val aStandardList = List(1, 2, 3, 42)
	val standardListMatching = aStandardList match {
		case List(1, _, _, _) => "This is the number 1 list"
		case List(1, _*) => "vararg number 1 list"
		case 1 :: List(_) => "infix number 1 list" // infix pattern
		case List(1, 2, 3) :+ 42 => "appended standard list"
	}
	println(standardListMatching)

	// 6. type specifiers
	val unknown: Any = 2
	val unknownMatch = unknown match {
		case list: List[Int] => // explicit type specifier
		case _ =>
	}

	// 7. name binding
	val nameBindingMatch = aStandardList match {
		case nonEmptyList @ List(_*) => s"${nonEmptyList} name bound list"
	}
	println(nameBindingMatch)

	// 8. multi-patterns
	val multiPattern = aStandardList match {
		case Seq(_*) | List(_*) => "Either a list or just a sequence"
		case x: Map[String, Int] => x.toString
	}

	// 9. Type erasure: Generics don't work with type matching it is not compatible with Java 1 types and the JVM, whichever version, is always backward compatible
	val nums = List(1, 2, 3)
	val numsMatch = nums match {
		// Generics i.e. [String] and [Int] are ignored and thus strList: List is matched
		case strList: List[String] => "a list of strings"
		case numList: List[Int] => "a list of numbers"
		case _ => ""
	}
	println(numsMatch)
}
