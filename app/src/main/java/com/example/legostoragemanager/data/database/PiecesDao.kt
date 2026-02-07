package com.example.legostoragemanager.data.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

interface PiecesDao {
    @Query(value = "SELECT * FROM Pieces ORDER BY name ASC")
    fun getAllPieces(): Flow<List<Pieces>>

    @Query(value = "SELECT * FROM Pieces WHERE id = :id")
    fun getPieces(id: Int): Flow<Pieces>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pieces: Pieces)

    @Update
    suspend fun update(pieces: Pieces)

    @Delete
    suspend fun delete(pieces: Pieces)
}