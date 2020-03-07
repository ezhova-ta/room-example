package com.example.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.room.db.dao.AlbumDao
import com.example.room.db.dao.SongDao
import com.example.room.db.entities.Album
import com.example.room.db.entities.Song

@Database(entities = [Album::class, Song::class], version = 2)
abstract class DB : RoomDatabase() {
    abstract fun albumDao(): AlbumDao
    abstract fun songDao(): SongDao
}