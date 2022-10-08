package exercises

import java.util
import java.util.Random
import scala.util.Try

class Connection {
	def connect = "Connected"

	def get(url: String): String = {
		val random = new Random(System.nanoTime())
		if (random.nextBoolean()) "<html>...</html>"
		else throw new RuntimeException("Connection interrupted")
	}
}

object Connection extends App {
	val config: Map[String, String] = Map(
		// fetched from properties
		"host" -> "176.45.23.1",
		"port" -> "80"
	)

	def renderHTML(page: String): Unit = println(page)

	val random = new Random(System.nanoTime())

	def apply(host: String, port: String): Connection = {
		if (random.nextBoolean()) new Connection
		else throw new RuntimeException("Someone else took the port")
	}

	val conn = Try(Connection(config("host"), config("port")))

	if (conn.isSuccess) {
		val page = Try(conn.get.get("abc.xyz.org"))
		if (page.isSuccess) renderHTML(page.get)
	}

}
