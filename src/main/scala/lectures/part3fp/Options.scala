package lectures.part3fp

object Options extends App {
	val anOption: Option[Int] = Some(3)
	val noOption: Option[Int] = None

	println(anOption)
	// get is unsafe
	// println(noOption.get)
	println(noOption.getOrElse(anOption))

	// unsafe Some, safe Option
	def unsafeMethod: String = null
	// val result = Some(unsafeMethod) // WRONG
	val result = Option(unsafeMethod)
	println(result)

	// chained methods
	def backupMethod: String = "A valid result"
	val chainedResult = Option(unsafeMethod).orElse(Option(backupMethod))

	// Designing unsafe APIs
	def betterUnsafeMethod: Option[String] = None
	def betterBackupMethod: Option[String] = Some("A valid result")

	val betterChainedResult = betterUnsafeMethod orElse betterBackupMethod
}
