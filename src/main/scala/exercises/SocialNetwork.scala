package exercises

import lectures.part2oop.Person.person

import scala.collection.mutable

case class SocialNetwork(persons: Seq[String]) {
	val network: mutable.Map[String, mutable.Set[String]] = mutable.Map(persons.map(_ -> mutable.Set[String]()) : _*).withDefaultValue(mutable.Set[String]())

	def add(person: String): SocialNetwork = {
		network(person) = mutable.Set[String]()
		this
	}

	def add(person: Person): SocialNetwork = add(person.toString)

	def remove(person: String): SocialNetwork = {
		network(person).foreach(network(_).remove(person))
		network.remove(person)
		this
	}

	def remove(person: Person): SocialNetwork = remove(person.toString)

	def friend(person1: String, person2: String): SocialNetwork = {
		network.getOrElseUpdate(person1, mutable.Set[String]()).add(person2)
		network.getOrElseUpdate(person2, mutable.Set[String]()).add(person1)
		this
	}

	def friend(person1: Person, person2: Person): SocialNetwork = friend(person1.toString, person2.toString)

	def unfriend(person1: String, person2: String): SocialNetwork = {
		if (network.contains(person1) && network.contains(person2)) {
			network(person1).remove(person2)
			network(person2).remove(person1)
		}
		this
	}

	def unfriend(person1: Person, person2: Person): SocialNetwork = unfriend(person1.toString, person2.toString)

	def mostFriends: (String, Set[String]) = {
		val account: (String, mutable.Set[String]) = network.maxBy[Int](_._2.size)
		(account._1, account._2.toSet)
	}


	override def toString: String = network.toString

}

enum Person {
	case Amit, Daniel, Jim, Aditya, Sam, John, Mike, Axle
}

object SocialNetwork extends App {
	val myNetwork = SocialNetwork(Seq(Person.Amit, Person.Daniel, Person.Jim, Person.Aditya, Person.Sam).map(_.toString))

	myNetwork.friend(Person.Amit, Person.Daniel)
	myNetwork.friend(Person.Amit, Person.Aditya)
	.friend(Person.Daniel, Person.Jim)
	myNetwork.friend(Person.Daniel, Person.Sam)
	myNetwork.friend(Person.Jim,Person.Sam)
	myNetwork.add(Person.John)
	myNetwork.friend(Person.Mike, Person.Axle)
	myNetwork.friend(Person.Mike, Person.John)

	println(myNetwork)

	myNetwork.unfriend(Person.Daniel, Person.Mike)
	myNetwork.unfriend(Person.Mike, Person.Axle)

	println(myNetwork)

	myNetwork.remove(Person.Sam)
	myNetwork.remove(Person.Axle)

	println(myNetwork)

	println(myNetwork.mostFriends)

}
