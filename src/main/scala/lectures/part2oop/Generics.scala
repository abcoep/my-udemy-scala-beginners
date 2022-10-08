package lectures.part2oop

import scala.annotation.tailrec

object Generics extends App {

	class MyList[+A] {
		class Element[+B >: A](val value: B, var next: Element[Any])

		private var head = new Element(null, null)
		private var tail = head

		def isEmpty: Boolean = head.value == null

		def add[B >: A](element: B): MyList[B] = {
			val newElem: Element[B] = new Element[B](element, null)

			if (isEmpty) head = newElem
			else tail.next = newElem
			tail = newElem

			this
		}

		override def toString: String = {
			@tailrec
			def toString[B >: A](elem: Element[B], acc: String): String = {
				if (elem == null) s"[$acc]"
				else toString(elem.next, s"$acc, ${elem.value}")
			}

			if (isEmpty) "[]"
			else toString(head.next, head.value.toString)
		}
	}

	val list = MyList()
	println(list.add(1, 1.234, "abcd"))
	println(list.add(1).add(1.234).add("abcd"))

	class MyMap[Key, Value]

	val intList = MyList[Int]
	val strList = new MyList[String]

	object MyList {
		def empty[A]: MyList[A] = new MyList[A]
	}

	val emptyIntList = MyList.empty[Int]

	// variance problem
	class Animal
	class Cat extends Animal
	class Dog extends Animal

	// COVARIANCE (+A): List[Animal] can be assigned a List[Cat] i.e. List[Cat] extends List[Animal]
	class CovariantList[+A]
	val animal: Animal = new Cat
	val covariantAnimalList: CovariantList[Animal] = new CovariantList[Cat]
	// animalList.add(new Dog) ??? HARD QUESTION - possible but pollutes list

	// INVARIANCE (A): List[Animal] cannot be assigned List[Cat], only to List[Animal]
	class InvariantList[A]
	// val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat]
	val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

	// CONTRAVARIANCE (-A): List[Cat] can be assigned a List[Animal]
	class ContravariantList[-A]
	val contravariantCatList: ContravariantList[Cat] = new ContravariantList[Animal]

	// bounded types
	class Cage[A <: Animal] (animal: A)
	val cage: Cage[Dog] = new Cage[Dog](new Dog)
}
