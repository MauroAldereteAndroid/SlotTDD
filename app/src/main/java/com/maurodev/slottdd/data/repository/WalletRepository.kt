package com.maurodev.slottdd.data.repository

import com.maurodev.slottdd.data.wallet.WalletDatabase
import com.maurodev.slottdd.data.wallet.WalletEntity

class WalletRepository(private val instance: WalletDatabase) {
    suspend fun createNewUser(walletEntity: WalletEntity): Boolean {
        val result = instance.getWalletDao().insertNewUser(walletEntity)
        return result != -1L
    }

    suspend fun getWalletAccount(walletId: Int): WalletEntity {
        return instance.getWalletDao().getWalletValue(walletId)
    }

    suspend fun updateWallet(walletEntity: WalletEntity): Boolean {
        val result = instance.getWalletDao().updateValueWallet(walletEntity)
        return result > 0
    }
}