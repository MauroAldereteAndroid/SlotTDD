package com.maurodev.slottdd.presenters.home.slot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.maurodev.slottdd.R
import com.maurodev.slottdd.domain.SlotManager

class SlotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slot)

        // Temp
        val button = findViewById<Button>(R.id.button_spin)
        val slot = SlotManager()
        button.setOnClickListener {
            val result = slot.executeSlot()
            println(result)
        }
    }
}