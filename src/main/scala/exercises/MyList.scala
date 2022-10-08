package exercises

import lectures.part3fp.HOFsCurries

import scala.annotation.tailrec
import scala.language.postfixOps

object MyList extends App {
	val evenPredicate: Int => Boolean = _ % 2 == 0
	val list = new MyList[Int]()
	println(list.add(6543).add(1234).add(12))
	println(list.filter(evenPredicate))

	val sequencePairTransformer: Int => MyList[Int] = x => new MyList[Int]().add(x).add(x + 1)
	println(list.flatMap(sequencePairTransformer))

	println(list.sort(_ - _))
	val list2 = new MyList[Int].add(3).add(6)
	println(list.zipWith(list2, _ * _))
	println(list.fold("abc")(_ + _))

	val strList = new MyList[String].add("a").add("b").add("c")
	// for comprehension: works on custom class if map[A], flatMap[A] and filter are defined
	for {
		num <- list
		str <- strList
	} println(str + num)

}

class MyList[T >: Nothing] {
	case class Element(var value: T, var next: Element)

	private var head: Element = null
	private var tail: Element = null

	def isEmpty: Boolean = head == null

	def foreach(f: T => Any): MyList[Any] = {
		val computedList = new MyList[Any]
		var currentElem = head
		while (currentElem != null) {
			computedList.add(f(currentElem.value))
			currentElem = currentElem.next
		}
		computedList
	}

	def add(elem: T): MyList[T] = {
		val newElem = new Element(elem, null)

		if (isEmpty) head = newElem
		else tail.next = newElem
		tail = newElem

		this
	}

	def add(myList: MyList[T]): MyList[T] = {
		var currentElem = myList.head
		while (currentElem != null) {
			this.add(currentElem.value)
			currentElem = currentElem.next
		}
		this
	}

	def copy: MyList[T] = {
		val listCopy = new MyList[T]
		listCopy.add(this)
		listCopy
	}

	override def toString: String = {
		@tailrec
		def toString(elem: Element, acc: String): String = {
			if (elem == null) s"[$acc]"
			else toString(elem.next, s"$acc, ${elem.value}")
		}

		if (isEmpty) "[]"
		else toString(head.next, head.value.toString)
	}

	def filter(predicate: T => Boolean): MyList[T] = {
		val filteredList = new MyList[T]
		var currentElem = head
		while (currentElem != null) {
			if (predicate(currentElem.value)) filteredList.add(currentElem.value)
			currentElem = currentElem.next
		}
		filteredList
	}

	def map[A] (transformer: T => A): MyList[A] = {
		val mappedList = new MyList[A]
		var currentElem = head
		while (currentElem != null) {
			mappedList.add(transformer(currentElem.value))
			currentElem = currentElem.next
		}
		mappedList
	}

	def flatMap[A](transformer: T => MyList[A]): MyList[A] = {
		val flatMappedList = new MyList[A]
		var currentElem = head
		while (currentElem != null) {
			flatMappedList.add(transformer(currentElem.value))
			currentElem = currentElem.next
		}
		flatMappedList
	}

	def sort(compare: (T, T) => Int): MyList[T] = {
		val sortedList = copy
		if (!isEmpty) {
			var subListStartElem = sortedList.head
			while (subListStartElem != sortedList.tail) {
				var currentElem = subListStartElem.next
				while (currentElem != null) {
					if (compare(subListStartElem.value, currentElem.value) > 0) {
						val smallestElemValue = currentElem.value
						currentElem.value = subListStartElem.value
						subListStartElem.value = smallestElemValue
					}
					currentElem = currentElem.next
				}
				subListStartElem = subListStartElem.next
			}
		}
		sortedList
	}

	def zipWith[B](list: MyList[T], f: (T, T) => B):  MyList[B] = {
		val zippedList = new MyList[B]
		var list1CurrentElem = head
		var list2CurrentElem = list.head
		while (list1CurrentElem != null && list2CurrentElem != null) {
			zippedList.add(f(list1CurrentElem.value, list2CurrentElem.value))
			list1CurrentElem = list1CurrentElem.next
			list2CurrentElem = list2CurrentElem.next
		}
		zippedList
	}

	def fold[A](start: A)(f: (A, T) => A): A = {
		var foldedValue = start
		var currentElem = head
		while (currentElem != null) {
			foldedValue = f(foldedValue, currentElem.value)
			currentElem = currentElem.next
		}
		foldedValue
	}
}
