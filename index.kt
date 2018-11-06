package datkt.bytes

/**
 * Converts a variadic array of 'Number' to a 'ByteArray'
 */
fun bytesFrom(vararg bytes: Number): ByteArray {
  return ByteArray(bytes.count()) { i -> bytes[i].toByte() }
}

/**
 * Converts a 'ByteArray' to a new 'ByteArray'
 */
fun bytesFrom(bytes: ByteArray): ByteArray {
  val copy: Array<out Number> = bytes.toList().toTypedArray()
  return bytesFrom(copy)
}

/**
 * Converts an 'Array' of 'Number' to a 'ByteArray'
 */
fun bytesFrom(bytes: Array<out Number>): ByteArray {
  return bytesFrom(*bytes)
}

/**
 * Converts a 'String' to a 'ByteArray'
 */
fun bytesFrom(bytes: String): ByteArray {
  return bytes.toUtf8()
}

/**
 * Converts a 'Number' to a 'ByteArray'
 */
fun bytesFrom(size: Number): ByteArray {
  return ByteArray(size.toInt())
}

/**
 * Converts a 'Char' to a 'ByteArray'
 */
fun bytesFrom(size: Char): ByteArray {
  return ByteArray(size.toInt())
}

/**
 * Converts an 'Any?' to an empty 'ByteArray'
 */
fun bytesFrom(bytes: Any? = null): ByteArray {
  return ByteArray(0)
}
