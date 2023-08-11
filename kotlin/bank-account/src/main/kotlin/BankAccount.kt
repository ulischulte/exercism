class BankAccount {
  private var isOpen = true

  var balance: Int = 0
    private set
    get() {
      check(this.isOpen)
      return field
    }

  @Synchronized
  fun adjustBalance(amount: Int) {
    check(this.isOpen)
    balance += amount
  }

  fun close() {
    isOpen = false
  }
}
