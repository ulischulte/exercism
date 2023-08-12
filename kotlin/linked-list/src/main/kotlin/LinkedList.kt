data class Node<T>(val value: T, var previous: Node<T>? = null, var next: Node<T>? = null)

class Deque<T> {

  private var head: Node<T>? = null
  private var tail: Node<T>? = null

  fun push(value: T) {
    Node(value, next = this.head).apply {
      if (head == null) {
        tail = this
      } else {
        head?.previous = this
      }
      head = this
    }
  }

  fun pop(): T? = head?.value.apply {
    head = head?.next
  }

  fun shift(): T? = tail?.value.apply {
    tail = tail?.previous
  }

  fun unshift(value: T) {
    Node(value, previous = tail).apply {
      if (tail == null) {
        head = this
      } else {
        tail?.next = this
      }
      tail = this
    }
  }

}
