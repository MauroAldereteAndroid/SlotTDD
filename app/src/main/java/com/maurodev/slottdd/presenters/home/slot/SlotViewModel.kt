package com.maurodev.slottdd.presenters.home.slot

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maurodev.slottdd.domain.SlotManager

class SlotViewModel : ViewModel() {

    private val slotManager = SlotManager() // TODO : DI

    val listReelLiveData = MutableLiveData<MutableList<Int>>()

    /**
     * Funcion para ejecutar el slot
     */
    fun executeSlot() {
        val result = slotManager.executeSlot()
        listReelLiveData.postValue(result)
    }
}