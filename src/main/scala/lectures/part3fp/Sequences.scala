package lectures.part3fp

import scala.::
import scala.util.Random

object Sequences extends App {
	// Sequences
	val aSequence = Seq(1, 4, 3, 2)
	println(aSequence)
	println(aSequence.reverse)
	println(aSequence(2))
	println(aSequence ++ Seq(5, 6, 7))
	println(aSequence.sorted)

	// Ranges
	// until is end exclusive
	val aRange: Seq[Int] = 1 until 10
	println(aRange)
	aRange.foreach(println)
	// to is end inclusive
	val bRange: Seq[Int] = 10 to 20
	println(bRange)
	bRange.foreach(println)

	// lists
	val aList = List(1, 2, 3)
	val prepended = 4 :: aList
	println(prepended)
	// another way, and append
	println(5 +: prepended :+ 6)

	// fill
	val apples5 = List.fill(5)("apple")
	println(apples5)
	println(apples5.mkString("-|-"))

	// arrays
	val nums = Array(1, 2, 3, 4)
	val threeElems = Array.ofDim[String](3)
	threeElems.foreach(println)

	// mutation
	nums(2) = 0 // syntactic sugar for nums.update(2, 0)
	println(nums.mkString("Array(", ", ", ")"))

	// arrays and seq
	val numsSeq: Seq[Int] = nums // implicit conversion
	println(numsSeq)

	// vectors
	val vector: Vector[Int] = Vector(1, 2, 3)
	println(vector)

	// vectors vs lists
	val maxRuns = 1000
	val maxCapacity = 1000000
	def getWriteTime(coll: Seq[Int]): Double = {
		val r = new Random
		val times = for {
			it <- 1 to maxRuns
		} yield {
			val startTime = System.nanoTime()
			coll.updated(r.nextInt(maxCapacity), r.nextInt())
			System.nanoTime() - startTime
		}
		times.sum * 1.0 / maxRuns
	}

	val numList = (1 to maxCapacity).toList
	val numVector = (1 to maxCapacity).toVector

	// List:
	// keeps reference to tail
	// updating an elem in the middle takes time
	println(getWriteTime(numList))

	// Vector: beats List massively
	// depth of the tree is small
	// update needs to replace an entire 32-element chunk
	println(getWriteTime(numVector))
}
