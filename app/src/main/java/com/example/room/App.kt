package com.example.room

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.room.db.DB

class App : Application() {
    companion object{
        lateinit var instance: App
            private set

        private const val DATABASE_NAME = "music_db"

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Album ADD COLUMN url TEXT")
            }
        }
    }

    lateinit var db: DB
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        assignValueToDbInstance()
    }

    private fun assignValueToDbInstance() {
        val dbBuilder = getDbBuilder()

        dbBuilder.addMigrations(MIGRATION_1_2)

        db = dbBuilder
            .allowMainThreadQueries()
            .build()
    }

    private fun getDbBuilder(): RoomDatabase.Builder<DB> {
        return Room.databaseBuilder(
            applicationContext,
            DB::class.java,
            DATABASE_NAME
        )
    }
}