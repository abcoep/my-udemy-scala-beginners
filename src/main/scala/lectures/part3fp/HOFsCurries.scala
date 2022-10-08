package lectures.part3fp

import lectures.part2oop.MethodNotations.y

import scala.annotation.tailrec

object HOFsCurries extends App {
	val superFunc: (Int, (String, (Int => Boolean)) => Int) => (Int, Int) = null

	// function that applies a function n times over a value x
	// nTimes(f, n, x)
	// nTimes(f, 3, x) = f(f(f(x)))
	@tailrec
	def nTimes(f: Int => Int, n: Int, x: Int): Int =
		if (n <= 0) x
		else nTimes(f, n - 1, f(x))
		// or: else f(nTimes(f, n - 1, x)) -> not tail recursive

	val plusOne: Int => Int = _ + 1
	println(nTimes(plusOne, 10, 1))

	def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
		if (n <= 0) (x: Int) => x
		else (x: Int) => nTimesBetter(f, n - 1)(f(x))

	val plus10 = nTimesBetter(plusOne, 10)
	println(plus10(1))

	// curried function with multiple params
	def curriedFormatter(c: String)(x: Double): String = c.format(x)

	val standardFormat: (Double => String) = curriedFormatter("%4.2f")
	val preciseFormat: (Double => String) = curriedFormatter("%10.8f")
	// function type is mandatory, otherwise compiler sees it as missing arguments
	// val notAllowedFormat = curriedFormatter("%4.2f")

	println(standardFormat(Math.PI))
	println(preciseFormat(Math.PI))

	def toCurry[T](f: (T, T) => T): T => T => T = x => y => f(x, y)

	def fromCurry[T](f: T => T => T): (T, T) => T = (x, y) => f(x)(y)

	def compose[T](f: T => T, g: T => T): T => T = x => f(g(x))

	def reverseCompose[T](f: T => T, g: T => T): T => T = compose(g, f)

	println(toCurry[Int](_ + _)(3)(4))
	println(fromCurry[Int](toCurry[Int](_ + _))(3, 4))

	println(compose[Int](_ * 2, _ / 2)(5))
	println(reverseCompose[Int](_ * 2, _ / 2)(5))
}
