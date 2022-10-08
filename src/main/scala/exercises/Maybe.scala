package exercises

abstract class Maybe[+T] {
	def map[B](f: T => B): Maybe[B]
	def flatMap[B](f: T => Maybe[B]): Maybe[B]
	def filter(p: T => Boolean): Maybe[T]
}

case object Empty extends Maybe[Nothing] {
	def map[B](f: Nothing => B): Maybe[B] = Empty

	def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = Empty

	def filter(p: Nothing => Boolean): Maybe[Nothing] = Empty
}

case class AnObject[+T](value: T) extends Maybe[T] {
	def map[B](f: T => B): Maybe[B] = AnObject[B](f(value))

	def flatMap[B](f: T => Maybe[B]): Maybe[B] = f(value)

	def filter(p: T => Boolean): Maybe[T] =
		if (p(value)) this
		else Empty
}

object MaybeTest extends App {
	val just3 = AnObject(3)
	println(just3)
	println(just3.map(_ * 3))
	println(just3.flatMap(x => AnObject(x % 2 == 0)))
	println(just3.filter(_ % 2 == 0))
}
