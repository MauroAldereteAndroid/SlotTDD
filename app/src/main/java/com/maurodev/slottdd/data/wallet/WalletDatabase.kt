package com.maurodev.slottdd.data.wallet

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [WalletEntity::class], version = 1)
abstract class WalletDatabase : RoomDatabase() {
    companion object {

        private const val NAME_DATABASE = "wallet_database"

        fun instance(context: Context): WalletDatabase {
            return Room.databaseBuilder(
                context,
                WalletDatabase::class.java,
                NAME_DATABASE
            )
                .build()
        }
    }

    abstract fun getWalletDao(): WalletDAO
}