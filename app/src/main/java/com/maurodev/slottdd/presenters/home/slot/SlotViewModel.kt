package com.maurodev.slottdd.presenters.home.slot

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maurodev.slottdd.domain.award.AwardManager
import com.maurodev.slottdd.domain.slot.SlotManager

class SlotViewModel : ViewModel() {

    private val slotManager = SlotManager() // TODO : DI
    private val awardManager = AwardManager() // TODO : DI

    val listReelLiveData = MutableLiveData<MutableList<Int>>()

    /**
     * Funcion para ejecutar el slot
     * De aca va al sistema de premios y
     * es el sistema de premios quien comunica a wallet el resultado.
     */
    fun executeSlot() {
        val result = slotManager.executeSlot()
        listReelLiveData.postValue(result)

        // Aca obtiene los valores de la lista y puede empezar la logica de premios.
        // Esta retornara otro liveData que animará y actualizara el premio en la ui.
        val award = awardManager.init(result, 20f) // El valor de la apuesta debe ser manual por usuario.
        Log.i("LINEA" , "premio = $ ${award.toInt()}")
    }
}