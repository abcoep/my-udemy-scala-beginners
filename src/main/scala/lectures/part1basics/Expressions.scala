package lectures.part1basics

import scala.language.postfixOps

object Expressions extends App {

	// Expression
	val x = 1 + 2
	println(1 == x)

	// Instructions (Do) vs Expressions (Value)
	// Instrucions are executed while Expressions are evaluated

	val aCondition = true
	// if "Expression" - returns value
	val aConditionedValue = if (aCondition) 5 else 3
	println(aConditionedValue)

	var i = 0
	// Never use while loops
	while (i < 10) {
		println(i)
		i += 1
	}

	// EVERYTHING IN SCALA IS AN EXPRESSION!

	val aWeirdValue = (i = 3) // Unit - Void
	println(aWeirdValue)

	// Code blocks
	val aCodeBlock = {
		val y = 2
		val z = y + 1

		// Value of the block is the value of the last expression i.e. the below expression
		if (z > 2) "hello" else "goodbye"
	}
	println(aCodeBlock)
}
