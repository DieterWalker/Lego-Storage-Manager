package com.example.legostoragemanager.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

/**
 * Lớp Entity đại diện cho một hàng dữ liệu trong database
 * */
@Entity(tableName="Pieces")
data class Pieces (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: Double,
    val quantity: Int,
    val category: PiecesCategory,
    val color: String,
)

class PiecesCategoryConverter{
    @TypeConverters
    fun formPiecesCategoryToString(category: PiecesCategory): String {
        return category.name
    }

    @TypeConverters
    fun formStringToPiecesCategory(category: String): PiecesCategory {
        return PiecesCategory.valueOf(category)
    }
}