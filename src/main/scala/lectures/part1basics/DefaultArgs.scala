package lectures.part1basics

import scala.{+:, :+}

object DefaultArgs {

	def savePicture(format: String = "jpg", width: Short = 1920, height: Short = 1080): Unit =
		// S-Interpolator
		println(s"saving picture: format=$format, width=$width, height=$height, pixels=${width * height}")

	savePicture(height = 600, width = 800, format="png")

	// same as 'extends App'
	def main(args: Array[String]): Unit = {
		val a = " to "
		// Prepend and Append operators respectively
		println('a' +: a :+ 'z')

		val name1 = "Ramesh"
		val age1 = 10.234567
		val name2 = "Suresh"
		val age2 = 10.2

		// F-Interpolator - can check for type correctness as against S-Interpolator
		println(f"$name1%s's age is $age1%2.3f")
		println(f"$name2's age is $age2%1.3f yrs")

		// Raw-Interpolator
		println(raw"This is a \n newline")
		val aStr = "This is a \n newline"
		println(raw"$aStr")
		val escapedStr = "This is a \\n newline"
		println(raw"$escapedStr")
	}
}
