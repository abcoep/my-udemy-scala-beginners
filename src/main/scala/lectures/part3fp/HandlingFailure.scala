package lectures.part3fp

import scala.util.{Failure, Success, Try}

object HandlingFailure extends App {
	// create success and failure
	val aSuccess = Success(3)
	val aFailure = Failure(new RuntimeException("It's a failure"))

	println(aSuccess)
	println(aFailure)

	def unsafeMethod: String = throw new RuntimeException("NO STRING FOR YOU")

	val potentialFailure = Try(unsafeMethod)
	println(potentialFailure)

	val anotherPotentialFailure = Try {
		// code that might throw
	}

	// utilities
	println(potentialFailure.isSuccess)

	// orElse
	def backupMethod: String = "A valid result"
	val fallbackTry = Try(unsafeMethod).orElse(Try(backupMethod))
	println(fallbackTry)

	// IF you design the API
	def betterUnsafeMethod: Try[String] = Failure(new RuntimeException)
	def betterBackupMethod: Try[String] = Success("A valid result")
	val betterFallback = betterUnsafeMethod orElse betterBackupMethod

	// map, flatMap, filter
	println(aSuccess.map(_ * 2))
	println(aSuccess.flatMap(x => Success(x * 10)))
	println(aSuccess.filter(_ > 10))
}
