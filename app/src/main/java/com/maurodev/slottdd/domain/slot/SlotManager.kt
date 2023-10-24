package com.maurodev.slottdd.domain.slot

/**
 * Esta clase se encarga de manejar la logica e implementacion del slot.
 */
class SlotManager {

    private val shuffleMixer = ShuffleMixer()

    /**
     * Da la orden de ejecutar el slot y retorna al vm el listado de valores.
     */
    fun executeSlot() = shuffleMixer.obtainSlotFirstReel()
}