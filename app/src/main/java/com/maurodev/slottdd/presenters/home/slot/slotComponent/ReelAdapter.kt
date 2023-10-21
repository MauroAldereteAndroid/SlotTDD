package com.maurodev.slottdd.presenters.home.slot.slotComponent

import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import com.maurodev.slottdd.data.SlotValue

class ReelAdapter(private val mainLayout: LinearLayout) {

    private val listValue = SlotValue.values()
    private var layoutParams: LinearLayout.LayoutParams? = null
    private var linearLayout: LinearLayout? = null

    /**
     * Crea instancia de layoutParams y va agregando las vistas de acuerdo el listado.
     */
    fun addValuesToReel(list: MutableList<Int>?) {
        initParams()
        mainLayout.removeAllViews()
        linearLayout = LinearLayout(mainLayout.context)
        linearLayout?.orientation = LinearLayout.VERTICAL
        linearLayout?.layoutParams = layoutParams

        list?.forEach {
            when (it) {
                MAX_INDEX_ARRAY -> convertValue(0)
                else -> {
                    if (it >= 0 && it < listValue.size) {
                        convertValue(listValue[it].id)
                    }
                }
            }
        }
        mainLayout.addView(linearLayout)
    }

    /**
     * Inicializa los layoutParams para el linearLayout
     */
    private fun initParams() {
        layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
    }

    /**
     * Instancia el textView y lo configura para agregarlo al linearLayout.
     */
    private fun convertValue(value: Int) {
        val tv = TextView(mainLayout.context).apply {
            this.text = value.toString()
        }
        layoutParams?.weight = WEIGHT_TEXT_VIEW
        tv.layoutParams = layoutParams
        tv.gravity = Gravity.CENTER
        tv.width = WIDTH_TEXT_VIEW
        tv.height = HEIGHT_TEXT_VIEW
        linearLayout?.addView(tv)
    }


    companion object {
        const val WIDTH_TEXT_VIEW = 80
        const val HEIGHT_TEXT_VIEW = 150
        const val WEIGHT_TEXT_VIEW = 1f
        const val MAX_INDEX_ARRAY = 12
    }
}