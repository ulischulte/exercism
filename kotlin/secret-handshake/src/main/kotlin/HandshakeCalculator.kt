object HandshakeCalculator {
    private const val REVERSE_SIGNAL_POSITION = 4

    fun calculateHandshake(number: Int): List<Signal> {
        val handshakeSignals = number.convertToSignals()
        return if (isReverseSignalPresent(number))
            handshakeSignals.reversed()
        else
            handshakeSignals
    }

    private fun Int.convertToSignals(): List<Signal> =
        Signal.values().filterIndexed { index, _ ->
            this and (1 shl index) != 0
        }

    private fun isReverseSignalPresent(number: Int): Boolean =
        number and (1 shl REVERSE_SIGNAL_POSITION) != 0
}
