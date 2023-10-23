package com.maurodev.slottdd.domain.wallet

import android.content.Context
import com.maurodev.slottdd.data.repository.WalletRepository
import com.maurodev.slottdd.data.wallet.WalletDatabase
import com.maurodev.slottdd.data.wallet.WalletEntity

class WalletUseCase(context: Context) {

    private var repository: WalletRepository? = null
    private var instance: WalletDatabase? = null
    private val walletAccountManager = WalletAccountManager()

    init {
        instance = WalletDatabase.instance(context)
        instance?.let { repository = WalletRepository(it) }

    }

    suspend fun obtainWalletValue(walletId: Int): WalletEntity? =
        repository?.getWalletAccount(walletId)

    suspend fun decreaseWallet(walletId: Int, valueOperated: Float): Boolean? {
        val walletValue = obtainWalletValue(walletId)?.wallet
        var result: Float? = null
        if (walletValue != null) {
            result = walletAccountManager.executeOperation(
                DECREASE,
                walletValue,
                valueOperated
            )
        }
        return repository?.updateWallet(WalletEntity(walletId, result!!))
    }

    suspend fun increaseWallet(walletId: Int, valueOperated: Float): Boolean? {
        val walletValue = obtainWalletValue(walletId)?.wallet
        var result: Float? = null
        if (walletValue != null) {
            result = walletAccountManager.executeOperation(
                INCREASE,
                walletValue,
                valueOperated
            )
        }
        return repository?.updateWallet(WalletEntity(walletId, result!!))
    }

    companion object {
        private const val INCREASE = "increase"
        private const val DECREASE = "decrease"
    }
}