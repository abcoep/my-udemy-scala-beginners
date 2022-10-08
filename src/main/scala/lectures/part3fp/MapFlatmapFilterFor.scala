package lectures.part3fp

object MapFlatmapFilterFor extends App {
	val list = List(1, 2, 3, 4)
	println(list)
	println(list.head)
	println(list.tail)

	println(list.map(_ + 1))

	println(list.filter(_ % 2 == 0))

	val toPair = (x: Int) => List(x, x + 1)
	println(list.flatMap(toPair))

	val chars = List('a', 'b', 'c', 'd')
	println(list.flatMap(num => chars.map(_ + num.toString)))

	val forCombinations = for {
		n <- list if n % 2 == 0
		c <- chars
	} yield c + n.toString
	println(forCombinations)

	for { n <- list } println(n)

	list.map { x => println(x * 2) }
}
