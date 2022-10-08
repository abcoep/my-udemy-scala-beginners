package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {

	// Also an Expression, everything is an Expression
	// Return type can be inferred, but best practice is to mention type explicitly
	def aFunction(a: String, b: Int) =
		a + " " + b

	println(aFunction("hello", 3))

	//Parameterless functions
	def aParameterlessFunction = 42
	// Can be called without parentheses
	println(aParameterlessFunction)

	// Recursive function needs type
	def aRepeatedFunction(a: String, n: Int): String = {
		if (n == 1) a
		else a + aRepeatedFunction(a, n - 1)
	}

	println(aRepeatedFunction("hello ", 3))

	def aBigFunction(n: Int): Int = {
		def aSmallFunction(a: Int, b: Int): Int = a + b

		aSmallFunction(n, n - 1)
	}

	def factorial(n: Short): BigInt = {
		@tailrec
		def fact(n: Int, acc: BigInt = 1): BigInt = {
			if (n < 2) acc
			else fact(n - 1, acc * n)
		}

		fact(n)
	}

	println(factorial(50))

	def fibonacci(n: Int): Long = {
		@tailrec
		def fibo(n: Int, a: Long = 0, b: Long = 1): Long = {
			if (n == 0) a
			else if (n == 1) b
			else fibo(n - 1, b, a + b)
		}
		fibo(n)
	}

	println("fibonacci(6): " + fibonacci(6))

	def isPrime(n: Int): Boolean = {
		val nHalf = n / 2

		@tailrec
		def isOddDivisible(oddFactor: Int = 3): Boolean = {
			if (oddFactor > nHalf) true
			else if ((n % oddFactor) == 0) false
			else isOddDivisible(oddFactor + 2)
		}

		if ((n % 2) == 0) false
		else isOddDivisible()
	}

	println("isPrime(1949): " + isPrime(1949))
	println("1950 isPrime(1950): " + isPrime(1950))
	println("isPrime(1953): " + isPrime(1953))
}
