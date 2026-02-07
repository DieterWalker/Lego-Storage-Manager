package com.example.legostoragemanager.data

import android.content.Context
import com.example.legostoragemanager.data.database.LegoStorageManagerDatabase
import com.example.legostoragemanager.data.database.OfflinePiecesRepository
import com.example.legostoragemanager.data.database.PiecesRepository

/**
 * App container chịu trách nhiệm cung cấp và quản lý các dependency cho ứng dụng.
 */
interface AppContainer {
    val piecesRepository: PiecesRepository
}
/**
 * Implementation của [AppContainer].
 */
class AppDataContainer(private val context: Context) : AppContainer {
    override val piecesRepository: PiecesRepository by lazy {
        OfflinePiecesRepository(LegoStorageManagerDatabase.getDatabase(context).piecesDao())
    }
}

