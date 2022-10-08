package lectures.part3fp

object AnonymousFunctions extends App {
	// anonymous function / lambda
	val double: Int => Int = x => x * 2

	// multiple params to lambda
	val adder: (Int, Int) => Int = (a, b) => a + b

	// no params
	val doSomething: () => Int = () => 3

	println(doSomething)
	println(doSomething())

	// curly braces with lambdas
	val strToInt = { (str: String) =>
		str.toInt
	}

	// More syntactic sugar
	val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
	val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b
}
