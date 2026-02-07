package com.example.legostoragemanager.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope

@Database(
    /** Các bảng có trong database  */
    entities = [Pieces::class],
    /** Version của database */
    version = 1,
    /** Không xuất file schema */
    exportSchema = false
)
@TypeConverters(
    PiecesCategoryConverter::class
)
abstract class LegoStorageManagerDatabase : RoomDatabase() {
    /**
     * Khai báo DAO cho Room tự sinh implementaion
     * */
    abstract fun piecesDao(): PiecesDao

        companion object {
            /**
             * Biến Instance để lưu database instance duy nhất (Singleton)
             * @Volatile đảm bảo mọi thread điều thấy giá trị mới nhất
             * */
            @Volatile
            private var Instance: LegoStorageManagerDatabase? = null

            /** Hàm lấy database instance*/
            fun getDatabase(context: Context): LegoStorageManagerDatabase {
                /**
                 * Nếu Instance đã tồn tại thì trả về luôn
                 * Nếu chưa có thì tạo mới trong khối synchronized
                 **/
                return Instance ?: synchronized(this) {
                    /** Tạo database bằng Room */
                    Room.databaseBuilder(
                        /** Context của app */
                        context = context,
                        /** Class database */
                        klass = LegoStorageManagerDatabase::class.java,
                        /** Tên database */
                        name = "lego_storage_manager_database"
                    )
                        .build()
                        .also { Instance = it }
                }
            }
        }
    }
}