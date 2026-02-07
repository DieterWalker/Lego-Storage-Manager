package com.example.legostoragemanager.data.database

import kotlinx.coroutines.flow.Flow

interface PiecesRepository {
    fun getAllPiecesStream(): Flow<List<Pieces>>
    fun getPiecesStream(id: Int): Flow<Pieces?>
    suspend fun insertPiece(pieces: Pieces)
    suspend fun updatePiece(pieces: Pieces)
    suspend fun deletePiece(pieces: Pieces)
}