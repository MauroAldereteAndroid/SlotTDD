package com.maurodev.slottdd.domain.wallet

import android.util.Log

/**
 * Esta clase se encarga de realizar las sumas y restas de la wallet.
 */
class WalletAccountManager() {

    /**
     * Funcion que reedirije dependiendo el tipo de operacion que se realice.
     * @param operation incremento o decremento.
     * @param wallet monto actual de la wallet.
     * @param valueOperated valor que modifica a la wallet.
     * @return retorna el resultado, si es null ejecuta un log.
     */
    fun executeOperation(
        operation: String,
        wallet: Float,
        valueOperated: Float
    ): Float? = when (operation) {
        INCREASE -> increaseValue(wallet, valueOperated)
        DECREASE -> decreaseValue(wallet, valueOperated)
        else -> {
            Log.i("WalletAccountManager", "Return null executeOperation")
            null
        }
    }

    private fun increaseValue(wallet: Float, valueOperated: Float) =
        wallet + valueOperated

    private fun decreaseValue(wallet: Float, valueOperated: Float) =
        wallet - valueOperated

    companion object {
       private const val INCREASE = "increase"
       private const val DECREASE = "decrease"
    }
}