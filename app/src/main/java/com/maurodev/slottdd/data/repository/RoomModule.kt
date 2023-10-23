package com.maurodev.slottdd.data.repository

import android.content.Context
import android.util.Log
import com.maurodev.slottdd.data.wallet.WalletDatabase

/**
 * Se crea la instancia de room
 */
object RoomModule {
    fun initRoom(context: Context): WalletDatabase {
        val result = WalletDatabase.instance(context)
        result?.let {
            Log.i(LOG, it.toString())
        }
        return result
    }

    private const val LOG = "ROOM"
}