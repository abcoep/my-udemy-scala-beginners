package lectures.part2oop

object Exceptions extends App {
	val x: String = null
	// println(x.length)

	// val aWeirdValue: String = throw new NullPointerException

	// throwable classes extend the Throwable class
	// Exception and Error are the major Throwable types

	def getInt(withExceptions: Boolean): Int =
		if (withExceptions) throw new RuntimeException("No Int for you!")
		else 16

	val potentialFail = try {
		getInt(false)
	} catch {
		case e: RuntimeException => println("caught a Runtime Exception")
	} finally {
		// finally doesn't influence return type
		println("finally done")
	}
	println(potentialFail)

	// Custom exception
	class MyException extends Exception
	val exception = new MyException

	throw exception
}
