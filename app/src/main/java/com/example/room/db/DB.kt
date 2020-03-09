package com.example.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.room.db.converters.DateTimestampConverter
import com.example.room.db.dao.AlbumDao
import com.example.room.db.dao.SongDao
import com.example.room.db.entities.Album
import com.example.room.db.entities.Song

@Database(entities = [Album::class, Song::class], version = 3)
@TypeConverters(DateTimestampConverter::class)
abstract class DB : RoomDatabase() {
    abstract fun albumDao(): AlbumDao
    abstract fun songDao(): SongDao
}