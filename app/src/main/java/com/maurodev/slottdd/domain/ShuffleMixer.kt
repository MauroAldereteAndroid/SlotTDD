package com.maurodev.slottdd.domain

import kotlin.random.Random

/**
 * Se encarga de generar la lista de valores aleatorios para el reel.
 */
class ShuffleMixer {

    private var firstReel = mutableListOf<Int>()

    /**
     * Funcion encargada de retornar a clase externa el listado.
     * @return listado
     */
    fun obtainSlotFirstReel(): MutableList<Int> {
        firstReel = mutableListOf()
        generateValue()
        return firstReel
    }

    /**
     * Funcion encargada de llegar el listado con valores aleatorios.
     */
    private fun generateValue() {
        for (i in 0 until 5) {
            firstReel.add(Random.nextInt(MIN, MAX))
        }
    }

    companion object {
        private const val MIN = 2
        private const val MAX = 13
    }
}