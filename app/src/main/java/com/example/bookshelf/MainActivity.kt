package com.example.bookshelf

import android.app.Application
import com.example.bookshelf.di.AppContainer
import com.example.bookshelf.network.DefaultAppContainer

class MainActivity: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}