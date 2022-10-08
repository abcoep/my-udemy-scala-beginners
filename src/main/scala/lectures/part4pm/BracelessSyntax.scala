package lectures.part4pm

object BracelessSyntax extends App {
	// if expressions
	val anIfExpr = if (2 > 3) "bigger" else "smaller"

	// java-style
	val anIfExprV2 =
		if (2 > 3) {
			"bigger"
		} else {
			"smaller"
		}

	val anIfExprV3 =
		if (2 > 3) "bigger"
		else "smaller"

    // scala 3
	val anIfExprV4 =
		if 2 > 3 then
			"bigger"
		else
			"smaller"

	val anIfExprV5 = if 2 > 3 then "bigger" else "smaller"
	println(anIfExprV5)

	// for comprehensions
	for
		n <- List(1, 2, 3)
	yield println(n)

	// match
	val matchedVal = 42 match
		case 1 => "the one"
		case 2 => "double or nothing"
		case _ => "something else"
	println(matchedVal)

	// methods
	def bracelessMethod(arg: Int): Int =
		val bla = 23
		val zzz = 65

		println(zzz)

		arg

	println(bracelessMethod(16))

	// class definition (same for traits, objects, enums, etc) - using colon
	class Animal:
		def eat: Unit =
			println("I'm eating")
		end eat

		def grow: Unit = println("I'm growing")
	end Animal
	// end token, works for everything - if, for, match, methods, classes, traits, etc.

	Animal().grow

	// anonymous classes
	val aSpecialAnimal = new Animal:
		override def eat: Unit = println("I'm special")
}
