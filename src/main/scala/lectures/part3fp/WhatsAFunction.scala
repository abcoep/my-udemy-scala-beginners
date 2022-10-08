package lectures.part3fp

object WhatsAFunction extends App {
	val doubler = new MyFunction[Int, Int] {
		override def apply(element: Int): Int = element * 2
	}
	println(doubler(2))

	// function types => Function1[A, B], Function2[X], ...
	val strToIntConverter = new Function1[String, Int] {
		override def apply(str: String): Int = str.toInt
	}
	println(strToIntConverter("3") + 4)

	// function types can take upto 22 type parameters
	val adder: ((Int, Int) => Int) = (a: Int, b: Int) => a + b

	// ALL SCALA FUNCTIONS ARE OBJECTS
	val strConcat = new ((String, String) => String) {
		override def apply(a: String, b: String): String = a + b
	}

	println(strConcat("Hello ", "Scala"))

	// HOF (Higher Order Functions) - either receive func as parameter or return a func
	// Curried function - returns func
	val hofAdder = (x: Int) => (y: Int) => x + y

	println(hofAdder(1)(2))
}

trait MyFunction[A, B] {
	def apply(element: A): B
}
