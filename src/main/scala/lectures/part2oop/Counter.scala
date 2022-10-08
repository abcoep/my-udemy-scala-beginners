package lectures.part2oop

// Companion object - can access class's hidden members and all its members are static
object Counter extends App {
	// object Counter, thus can't access class Counter methods
	// val counter = Counter
	val counter = Counter()

	println("current count: " + counter.currentCount())

	counter.increment()
	counter.increment(10)

	println("current count: " + counter.currentCount())

	counter.decrement()
	counter.decrement(5)

	println("current count: " + counter.currentCount())
}

class Counter(var count: Int = 0) {
	def currentCount(): Int = count

	def increment(amount: Int = 1): Unit = count += amount

	def decrement(amount: Int = 1): Unit = count -= amount
}
