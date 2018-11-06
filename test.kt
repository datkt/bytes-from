import datkt.bytes.bytesFrom
import datkt.tape.test

fun main(args: Array<String>) {
  test("bytesFrom(vararg bytes: Number): ByteArray") { t ->
    run {
      val bytes = bytesFrom(0xfe, 0xed, 0xbe, 0xef)
      t.equal(bytes[0].toInt() and 0xff, 0xfe)
      t.equal(bytes[1].toInt() and 0xff, 0xed)
      t.equal(bytes[2].toInt() and 0xff, 0xbe)
      t.equal(bytes[3].toInt() and 0xff, 0xef)
    }

    run {
      val bytes = bytesFrom(*arrayOf(0xfe, 0xed, 0xbe, 0xef))
      t.equal(bytes[0].toInt() and 0xff, 0xfe)
      t.equal(bytes[1].toInt() and 0xff, 0xed)
      t.equal(bytes[2].toInt() and 0xff, 0xbe)
      t.equal(bytes[3].toInt() and 0xff, 0xef)
    }
    t.end()
  }

  test("bytesFrom(bytes: ByteArray): ByteArray") { t ->
    val bytes = bytesFrom(bytesFrom(0xfe, 0xed, 0xbe, 0xef))
    t.equal(bytes[0].toInt() and 0xff, 0xfe)
    t.equal(bytes[1].toInt() and 0xff, 0xed)
    t.equal(bytes[2].toInt() and 0xff, 0xbe)
    t.equal(bytes[3].toInt() and 0xff, 0xef)
    t.end()
  }

  test("bytesFrom(bytes: Array<Number>): ByteArray") { t ->
    val bytes = bytesFrom(arrayOf(0xfe, 0xed, 0xbe, 0xef))
    t.equal(bytes[0].toInt() and 0xff, 0xfe)
    t.equal(bytes[1].toInt() and 0xff, 0xed)
    t.equal(bytes[2].toInt() and 0xff, 0xbe)
    t.equal(bytes[3].toInt() and 0xff, 0xef)
    t.end()
  }

  test("bytesFrom(bytes: String): ByteArray") { t ->
    val bytes = bytesFrom("feedbeef")
    t.equal(bytes[0].toInt() and 0xff, 0x66)
    t.equal(bytes[1].toInt() and 0xff, 0x65)
    t.equal(bytes[2].toInt() and 0xff, 0x65)
    t.equal(bytes[3].toInt() and 0xff, 0x64)

    t.equal(bytes[4].toInt() and 0xff, 0x62)
    t.equal(bytes[5].toInt() and 0xff, 0x65)
    t.equal(bytes[6].toInt() and 0xff, 0x65)
    t.equal(bytes[7].toInt() and 0xff, 0x66)
    t.end()
  }

  test("bytesFrom(size: Number): ByteArray") { t ->
    run {
      val bytes = bytesFrom(0)
      t.equal(bytes.size, 0)
    }

    run {
      val bytes = bytesFrom(16)
      t.equal(bytes.size, 16)
    }

    t.end()
  }

  test("bytesFrom(size: Char): ByteArray") { t ->
    run {
      val bytes = bytesFrom('0')
      t.equal(bytes.size, '0'.toInt())
    }

    run {
      val bytes = bytesFrom('a')
      t.equal(bytes.size, 0x61)
    }

    run {
      val bytes = bytesFrom('c')
      t.equal(bytes.size, 'c'.toInt())
    }

    t.end()
  }

  test("bytesFrom(bytes: Any? = null): ByteArray") { t ->
    t.equal(bytesFrom(null).size, 0)
    t.equal(bytesFrom("").size, 0)
    t.equal(bytesFrom(fun() { }).size, 0)
    t.end()
  }

  datkt.tape.collect()
}
