package exercises

trait Expr {
	override def toString: String
}

case class Number(n: Int) extends Expr {
	override def toString: String = n.toString
}
case class Sum(e1: Expr, e2: Expr) extends Expr {
	override def toString: String = s"$e1 + $e2"
}
case class Prod(e1: Expr, e2: Expr) extends Expr {
	def addParenthesisIfNeeded(e: Expr): String = {
		e match {
			case Sum(_, _) => s"($e)"
			case _ => e.toString
		}
	}

	override def toString: String = s"${addParenthesisIfNeeded(e1)} * ${addParenthesisIfNeeded(e2)}"
}

object Expr extends App {
	println(Prod(Number(1), Number(2)))
	println(Sum(Prod(Number(1), Number(2)), Number(3)))
	println(Prod(Sum(Number(1), Number(2)), Number(3)))
	println(Prod(Sum(Number(1), Number(2)), Sum(Number(3), Number(4))))
	println(Prod(Prod(Number(1), Number(2)), Sum(Number(3), Number(4))))
}
