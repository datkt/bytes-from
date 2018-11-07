bytes-from
==========

Convert various arguments into a ByteArray.
This package is part of the [`datkt.bytes`][datkt-bytes] package.

## Installation

```sh
$ npm install @datkt/bytes-from
```

## Usage

```kotlin
import datkt.bytes.bytesFrom

fun main(args: Array<String>) {
  run { val bytes = bytesFrom(0xa, 0xb, 0xc, 0xd) } // or
  run { val bytes = bytesFrom(arrayOf(0xa, 0xb, 0xc, 0xd)) } // or
  run { val bytes = bytesFrom("hello") } // or
  run { val bytes = bytesFrom(32) }
}
```

## API

### `bytesFrom(vararg bytes: Number): ByteArray`

Converts a variadic array of `Number` to a `ByteArray`

```kotlin
val bytes = bytesFrom(0xfe, 0xed, 0xbe, 0xef)
```

```kotlin
val bytes = bytesFrom(*arrayOf(0xfe, 0xed, 0xbe, 0xef))
```

### `bytesFrom(bytes: ByteArray): ByteArray`

Converts a `ByteArray` to a new `ByteArray`

```kotlin
val bytes = bytesFrom(bytesFrom(0xfe, 0xed, 0xbe, 0xef))
```

### `bytesFrom(bytes: Array<out Number>): ByteArray`

Converts an `Array` of `Number` to a `ByteArray`

```kotlin
val bytes = bytesFrom(arrayOf(0xfe, 0xed, 0xbe, 0xef))
```

### `bytesFrom(bytes: String): ByteArray`

Converts a `String` to a `ByteArray`

```kotlin
val bytes = bytesFrom("feedbeef")
```

### `bytesFrom(size: Number): ByteArray`

Converts a `Number` to a `ByteArray`

```kotlin
val bytes = bytesFrom(16)
```

### `bytesFrom(size: Char): ByteArray`

Converts a `Char` to a `ByteArray`

```kotlin
val bytes = bytesFrom('a')
```

### `bytesFrom(bytes: Any? = null): ByteArray`

Converts an `Any?` to an empty `ByteArray`

```kotlin
val bytes = bytesFrom()
```

```kotlin
val bytes = bytesFrom(null)
```

```kotlin
val bytes = bytesFrom(fun() {  })
```

```kotlin
val bytes = bytesFrom(true)
```

## Prerequisites

* [Kotlin/Native](https://github.com/JetBrains/kotlin-native) and the
  `konanc` command line program.

## See Also

* https://github.com/datkt/bytes
* https://github.com/LinusU/buffer-from#readme

## License

MIT


[datkt-bytes]: https://github.com/datkt/bytes
