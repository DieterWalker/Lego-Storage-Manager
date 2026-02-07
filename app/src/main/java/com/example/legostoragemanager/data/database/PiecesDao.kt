package com.example.legostoragemanager.data.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

interface PiecesDao {
    /**
     *  Lấy tất cả dự liệu trong bảng [Pieces]
     **/
    @Query(value = "SELECT * FROM Pieces ORDER BY name ASC")
    fun getAllPieces(): Flow<List<Pieces>>

    /**
     *  Lấy dự liệu trong bảng [Pieces] trùng khớp với [ID]
     **/
    @Query(value = "SELECT * FROM Pieces WHERE id = :id")
    fun getPieces(id: Int): Flow<Pieces>

    /**
     *  Thêm dữ liệu vào bảng
     **/
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pieces: Pieces)

    /**
     *  Cập nhật dữ liệu bảng
     **/
    @Update
    suspend fun update(pieces: Pieces)

    /**
     * Xóa dữ liệu khỏi bảng
     **/
    @Delete
    suspend fun delete(pieces: Pieces)
}