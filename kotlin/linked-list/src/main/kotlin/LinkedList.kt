data class Node<T>(val value: T, var previous: Node<T>?, var next: Node<T>?)

class Deque<T> {

  private var head: Node<T>? = null
  private var tail: Node<T>? = null

  fun push(value: T) {
    val newNode = Node(value, previous = null, next = head)
    if (head != null) {
      head?.previous = newNode
    } else {
      tail = newNode
    }
    head = newNode
  }

  fun pop(): T? {
    val oldHead = head
    head = head?.next
    return oldHead?.value
  }

  fun shift(): T? {
    val oldTail = tail
    tail = tail?.previous
    return oldTail?.value
  }

  fun unshift(value: T) {
    val newNode = Node(value, previous = tail, next = null)
    if (tail != null) {
      tail?.next = newNode
    } else {
      head = newNode
    }
    tail = newNode
  }

  fun isEmpty() = head == null

}
