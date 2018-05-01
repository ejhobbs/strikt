package assertions.assertions

import assertions.api.Assertion

/**
 * Asserts that all elements of the subject pass the assertions in [predicate].
 */
fun <T : Iterable<E>, E> Assertion<T>.all(predicate: Assertion<E>.() -> Unit) =
  apply {
    nested("all elements match predicate") { subject ->
      subject.forEach {
        expect(it, predicate)
      }
      if (allSucceeded) {
        success()
      } else {
        failure()
      }
    }
  }