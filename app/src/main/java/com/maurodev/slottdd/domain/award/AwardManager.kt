package com.maurodev.slottdd.domain.award

/**
 * En esta clase va a estar la logica mas generica para la generacion de premios
 */
class AwardManager {

    // Este dato maneja el tipo de operacion y el resultado del slot.
    private var resultValue: Pair<Float, String>? = null

    fun init(values: MutableList<Int>, bet: Float): Pair<Float, String> =
        paymentAlgorithms(values, bet)


    /**
     * Esta funcion busca valores continuos iguales.
     *
     * Reglas falsas :
     * 3 coincidencias devuelve el pago.
     * 4 coincidencias multiplica por 3.
     * 5 coincidencias multiplica por 30.
     * // Cuanto mas compleja sea esta funcion hay que hacerla clase.
     */
    private fun paymentAlgorithms(values: MutableList<Int>, bet: Float): Pair<Float, String> {
        var coincidence = 0
        val firstValue = values[0]

        values.forEach {
            if (firstValue == it) coincidence++
        }

        val award: Pair<Float, String> = when (coincidence) {
            in MIN_RANGE_WITHOUT_AWARD..MAX_RANGE_WITHOUT_AWARD -> buildingPair(bet, DECREASE)
            THREE_COINCIDENCES -> buildingPair(bet, DECREASE)
            FOUR_COINCIDENCES -> buildingPair(bet * MULTIPLIED_BY_THREE, INCREASE)
            FIVE_COINCIDENCES -> buildingPair(bet * MULTIPLIED_BY_THIRTY, INCREASE)
            else -> {
                buildingPair(bet, DECREASE)
            }
        }
        return award
    }

    private fun buildingPair(resultAward: Float, operation: String) =
        Pair(resultAward, operation)

    companion object {
        private const val MIN_RANGE_WITHOUT_AWARD = 0
        private const val MAX_RANGE_WITHOUT_AWARD = 2
        private const val THREE_COINCIDENCES = 3
        private const val FOUR_COINCIDENCES = 4
        private const val FIVE_COINCIDENCES = 5
        private const val MULTIPLIED_BY_THREE = 3
        private const val MULTIPLIED_BY_THIRTY = 30
        private const val INCREASE = "increase"
        private const val DECREASE = "decrease"

    }
}