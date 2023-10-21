package com.maurodev.slottdd.presenters.home.slot

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.maurodev.slottdd.databinding.ActivitySlotBinding
import com.maurodev.slottdd.presenters.home.slot.slotComponent.ReelAdapter

class SlotActivity : AppCompatActivity() {

    private lateinit var _vm: SlotViewModel
    private lateinit var _binding: ActivitySlotBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySlotBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        _vm = ViewModelProvider(this)[SlotViewModel::class.java]

        observers()

        _binding.buttonSpin.setOnClickListener { executeSlot() }
    }

    private fun observers() {
        _vm.listReelLiveData.observe(this) {
            val reelAdapter = ReelAdapter(_binding.layoutSlot)
            reelAdapter.addValuesToReel(it)
            println(it)
        }
    }

    private fun executeSlot() {
        _vm.executeSlot()
    }
}
