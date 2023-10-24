package com.maurodev.slottdd.domain.award

/**
 * En esta clase va a estar la logica mas generica para la generacion de premios
 */
class AwardManager {

    fun init(values: MutableList<Int>, bet: Float): Float {
       return paymentAlgorithms(values, bet)
    }

    /**
     * Esta funcion busca valores continuos iguales.
     *
     * Reglas falsas :
     * 3 coincidencias devuelve el pago.
     * 4 coincidencias multiplica por 3.
     * 5 coincidencias multiplica por 30.
     * // Cuanto mas compleja sea esta funcion hay que hacerla clase.
     */
    private fun paymentAlgorithms(values: MutableList<Int>, bet: Float): Float {
        var coincidence = 0
        val firstValue = values[0]

        values.forEach {
            if (firstValue == it) coincidence++
        }

        val award = when (coincidence) {
            0, 1, 2 -> 0f
            3 -> bet * 1
            4 -> bet * 3
            5 -> bet * 30
            else -> {
                0f
            }
        }
        return award
    }
}