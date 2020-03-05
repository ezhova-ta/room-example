package com.example.room

import android.app.Application
import androidx.room.Room
import com.example.room.db.DB

class App : Application() {
    companion object{
        private const val DATABASE_NAME = "music_db"

        lateinit var instance: App
            private set
    }

    lateinit var db: DB
        private set

    override fun onCreate() {
        super.onCreate()

        instance = this

        db = Room
            .databaseBuilder(applicationContext, DB::class.java, DATABASE_NAME)
            .allowMainThreadQueries()
            .build()
    }
}