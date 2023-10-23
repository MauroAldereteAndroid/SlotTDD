package com.maurodev.slottdd.data.wallet

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface WalletDAO {
    @Insert
    suspend fun insertNewUser(walletEntity: WalletEntity)
}