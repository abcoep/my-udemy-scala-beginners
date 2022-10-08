package lectures.part1basics

object CBNvsCBV extends App {

	def calledByValue(x: Long): Unit = {
		println("by value: " + x)
		println("by value: " + x)
	}

	def calledByName(x: => Long): Unit = {
		println("by name: " + x)
		println("by name: " + x)
	}

	calledByValue(System.nanoTime())
	calledByName(System.nanoTime())

	def infiniteRec(): Int = 1 + infiniteRec()
	def printFirst(x: Int, y: => Int) = println(x)

	// Will cause StackOverflow
	// printFirst(infiniteRec(), 123)
	printFirst(123, infiniteRec())
}
