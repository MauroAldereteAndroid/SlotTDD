package com.maurodev.slottdd.presenters.home.home

import android.content.Context
import androidx.lifecycle.ViewModel
import com.maurodev.slottdd.data.repository.RoomModule
import com.maurodev.slottdd.data.wallet.WalletDatabase

class HomeViewModel : ViewModel() {

    private var roomInstance: WalletDatabase? = null

    /**
     * Se inicializa room en esta pantalla.
     */
    fun init(context: Context?) {
        context?.let {
            roomInstance = RoomModule.initRoom(it)
        }
    }

}