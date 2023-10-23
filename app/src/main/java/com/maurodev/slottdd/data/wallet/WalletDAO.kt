package com.maurodev.slottdd.data.wallet

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface WalletDAO {
    @Insert
    suspend fun insertNewUser(walletEntity: WalletEntity): Long

    @Update
    suspend fun updateValueWallet(walletEntity: WalletEntity): Int

    @Query("SELECT * FROM wallet_account WHERE id = :walletId")
    suspend fun getWalletValue(walletId: Int): WalletEntity
}