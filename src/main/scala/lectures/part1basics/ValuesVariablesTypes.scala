package lectures.part1basics

object ValuesVariablesTypes extends App {
	// Type is inferred from RHS
	val x = 32
	println(x)

	// val is immutable
	// comma is allowed but bad code
	val aString: String = "hello"; val bString = "world"

	val aBoolean = false
	val aChar = 'a'
	val aInt = x
	val aShort: Short = 23432
	// Default is Int and type inferrence doesn't work. Thus explicit long
	val aLong: Long = 234234234234
	val aFloat: Float = 2.02f
	val aDouble: Double = 4.143543534534523

	var aVar: Int = 4

	// side effects - be aware of them
	aVar = 5
}
