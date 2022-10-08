package lectures.part4pm

import sun.jvm.hotspot.HelloWorld.e

object PatternsEverywhere extends App {
	try {
		// code
	} catch {
		case o: RuntimeException => "runtime"
		case npe: NullPointerException => "npe"
		case _ => "something else"
	}

	// catch is actually match
	/*try {
		// code
	} catch (e) {
		e match {
			case o: RuntimeException => "runtime"
			case npe: NullPointerException => "npe"
			case _ => "something else"
		}
	}*/

	val list = List(1, 2, 3, 4)
	val evenOnes = for {
		// Generators are also based on PM
		x <- list if x % 2 == 0
	} yield 10 * x

	val tuple = (1, 2, 3)
	// name binding of PM as assignment
	val (a, b, c) = tuple
	println(b)

	val head :: tail = list
	println(head)
	println(tail)

	// partial function
	val mappedList = list.map {
		case v if v % 2 == 0 => s"$v is even"
		case 1 => "the one"
		case _ => "something else"
	}
	// is same as
	val mappedList2 = list.map {
		x => x match {
			case v if v % 2 == 0 => s"$v is even"
			case 1 => "the one"
			case _ => "something else"
		}
	}
	println(mappedList)
}
