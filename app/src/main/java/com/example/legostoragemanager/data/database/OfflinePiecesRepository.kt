package com.example.legostoragemanager.data.database

import kotlinx.coroutines.flow.Flow

class OfflinePiecesRepository(private val piecesDao: PiecesDao): PiecesRepository {
    override fun getAllPiecesStream(): Flow<List<Pieces>> = piecesDao.getAllPieces()
    override fun getPiecesStream(id: Int): Flow<Pieces?> = piecesDao.getPieces(id)
    override suspend fun insertPiece(pieces: Pieces) = piecesDao.insert(pieces)
    override suspend fun updatePiece(pieces: Pieces) = piecesDao.update(pieces)
    override suspend fun deletePiece(pieces: Pieces) = piecesDao.delete(pieces)
}