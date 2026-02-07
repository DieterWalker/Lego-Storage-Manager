package com.example.legostoragemanager

import android.app.Application
import com.example.legostoragemanager.data.AppContainer
import com.example.legostoragemanager.data.AppDataContainer

class LegoStorageManagerApplication : Application() {
    /**
     * Instance AppContainer được các lớp khác sử dụng để truy cập các dependency.
     */
    lateinit var container: AppContainer

    override fun onCreate(){
        super.onCreate()
        container = AppDataContainer(context = this)
    }
}