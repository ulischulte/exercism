import java.util.concurrent.atomic.AtomicInteger

class BankAccount {
  private val internalBalance = AtomicInteger(0)
  private var open: Boolean = true

  val balance : Int
    get() {
      check(open)
      return internalBalance.get()
    }

  fun adjustBalance(amount: Int) {
    check(open)
    internalBalance.addAndGet(amount)
  }

  fun close(){
    open = false
  }
}
