package exercises

case object PocketCalculator extends App {

	class OverflowException(private val message: String = "", private val cause: Throwable = None.orNull) extends Exception(message, cause)
	class UnderflowException(private val message: String = "", private val cause: Throwable = None.orNull) extends Exception(message, cause)
	class MathCalculationException(private val message: String = "", private val cause: Throwable = None.orNull) extends Exception(message, cause)

	def add(x: Int, y: Int): Int = {
		val sum: Int = x + y
		if (y > 0 && sum < x) throw new OverflowException(s"Sum of $x and $y is greater than Int.MaxValue (${Int.MaxValue})")
		else if (y < 0 && sum > x) throw new UnderflowException(s"Sum of $x and $y is lesser than Int.MinValue (${Int.MinValue})")
		else sum
	}

	def subtract(x: Int, y: Int): Int = add(x, -y)

	def multiply(x: Int, y: Int): Int = {
		def mult(a: Int, b: Int): Int = {
			if (b == 0) 0
			else try {
				add(a, mult(a, b - 1))
			} catch {
				case overflow: OverflowException => throw new OverflowException(s"Product of $x and $y is greater than Int.MaxValue (${Int.MaxValue}")
				case underflow: UnderflowException => throw new UnderflowException(s"Product of $x and $y is lesser than Int.MinValue (${Int.MinValue})")
			}
		}

		if (y < 0) mult(-x, -y)
		else mult(x, y)
	}

	def divide(x: Int, y: Int): Double =  {
		if (y == 0) throw new MathCalculationException("Division by 0")
		else x.toDouble / y
	}

//	val array = Array.ofDim[Int](Int.MaxValue)
//	println(add(Int.MaxValue, 1))
//	println(subtract(Int.MinValue, 1))
//	println(multiply(3, 2))
//	println(multiply(4, Int.MaxValue))
//	println(divide(Int.MinValue, 0))
}
