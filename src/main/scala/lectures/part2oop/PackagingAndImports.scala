package lectures.part2oop

//import lectures.part1basics._
import lectures.part1basics.{CBNvsCBV, DefaultArgs => DA}

import java.util.Date
import java.sql.{Date => SQLDate}

object PackagingAndImports extends App {
	val write = new Writer("Arthur", "Conan Doyle", 1859)

	DA.savePicture()
	CBNvsCBV.calledByName(System.nanoTime())

	sayHello
	println(SPEED_OF_LIGHT)

	val date = new Date
	val sqlDate = new SQLDate(2022, 04, 01)
}
