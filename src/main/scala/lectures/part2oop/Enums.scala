package lectures.part2oop

object Enums {

	enum Permissions {
		case READ, WRITE, EXEC, NONE

		def openDocument(): Unit =
			if (this == READ) println("Opening document")
			else println("No read permission for document")
	}

	val somePermissions: Permissions = Permissions.READ

	enum PermissionsWithBits(bits: Int) {
		// Quite boilerplaty constructor enums as of now in Scala 3
		case READ extends PermissionsWithBits(4)
		case WRITE extends PermissionsWithBits(2)
		case EXEC extends PermissionsWithBits(1)
		case NONE extends PermissionsWithBits(0)
	}

	object PermissionsWithBits {
		def fromBits(bits: Int): PermissionsWithBits = // whatever
			PermissionsWithBits.NONE
	}

	// standard API
	val somePermissionsOrdinal: Int = somePermissions.ordinal
	val allPermissions: Any = PermissionsWithBits.values // array of all enum values
	val readPermission: Permissions = Permissions.valueOf("READ")

	def main(args: Array[String]): Unit = {
		somePermissions.openDocument()
		println(somePermissionsOrdinal)
		println(allPermissions)
	}
}
