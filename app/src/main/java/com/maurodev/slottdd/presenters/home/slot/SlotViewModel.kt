package com.maurodev.slottdd.presenters.home.slot

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maurodev.slottdd.domain.award.AwardManager
import com.maurodev.slottdd.domain.slot.SlotManager
import com.maurodev.slottdd.domain.wallet.WalletUseCase
import kotlinx.coroutines.launch

class SlotViewModel : ViewModel() {

    private val slotManager = SlotManager() // TODO : DI
    private val awardManager = AwardManager() // TODO : DI
    private var walletUseCase: WalletUseCase? = null

    val listReelLiveData = MutableLiveData<MutableList<Int>>()

    /**
     * Funcion para ejecutar el slot
     * De aca va al sistema de premios y
     * es el sistema de premios quien comunica a wallet el resultado.
     */
    fun executeSlot(context: Context) {
        val result = slotManager.executeSlot()
        val bet = 20f
        listReelLiveData.postValue(result)

        // El valor de la apuesta debe ser manual por usuario. new ticket
        val award = awardManager.init(result, bet)
        syncWallet(award, context)
    }

    /**
     * Funcion para obtener fichas nuevas con publicidad.
     * Temporalmente mientras dure el desarrollo ingresaran fichas sin publicidad.
     */
    fun obtainFreeCoins(context: Context) {
        val mockIncreaseCoins = Pair(10000f, "increase") // Temp mock
        syncWallet(mockIncreaseCoins, context)
    }

    /**
     * Actualiza el valor de la wallet, sea ganancia o perdida.
     */
    private fun syncWallet(award: Pair<Float, String>, context: Context) {
        viewModelScope.launch {
            walletUseCase = WalletUseCase(context)

            if (award.second == INCREASE) {
                walletUseCase?.increaseWallet(1, award.first)
            }

            if (award.second == DECREASE) {
                walletUseCase?.decreaseWallet(1, award.first)
            }
        }
    }

    companion object {
        private const val INCREASE = "increase"
        private const val DECREASE = "decrease"
    }
}