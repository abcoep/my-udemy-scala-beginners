package lectures.part2oop

object NovelWriters extends App {

	val writer = new Writer("George", "Orwell", 1903)
	val novel = new Novel("Animal Farm", 1945, writer)

	println("Novel: " + novel.name)
	println("Year of release: " + novel.yearOfRelease)
	println("Author: " + novel.author.fullName())
	println("Author age: " + novel.authorAge())

	val ukrainianEdition = novel.copy(1947)
	println("Ukrainian edition release: " + ukrainianEdition.yearOfRelease)

	val dupWriter = new Writer("George", "Orwell", 1903)
	println(novel.isWrittenBy(dupWriter))
}

class Writer(val firstName: String, val surname: String, val year: Int) {
	def fullName(): String = firstName + " " + surname
}

class Novel(val name: String, val yearOfRelease: Int, var author: Writer) {
	def authorAge(): Int = yearOfRelease - author.year

	def isWrittenBy(author: Writer): Boolean = this.author == author

	def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)
}
