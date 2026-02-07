package com.example.legostoragemanager.data.database

import kotlinx.coroutines.flow.Flow

/**
 * Repository chịu trách nhiệm thêm, sửa, xóa và lấy dữ liệu [Pieces] từ data source.
 * */
interface PiecesRepository {
    /**
     * Lấy tất cả dữ liệu từ datasource
     * */
    fun getAllPiecesStream(): Flow<List<Pieces>>
    /**
     * Lấy dữ liệu từ datasource trùng với [ID]
     * */
    fun getPiecesStream(id: Int): Flow<Pieces?>
    /**
     * Thêm dữ liệu vào datasource
     * */
    suspend fun insertPiece(pieces: Pieces)
    /**
     * Cập nhật dữ liệu từ datasource
     * */
    suspend fun updatePiece(pieces: Pieces)
    /**
     * Xóa dữ liệu khỏi datasource
     * */
    suspend fun deletePiece(pieces: Pieces)
}