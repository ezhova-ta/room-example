package com.example.room.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Transaction
import com.example.room.db.entities.Album
import com.example.room.db.entities.Song

@Dao
abstract class AlbumSongDao {
    @Insert
    abstract fun insertAlbum(album: Album): Long

    @Insert
    abstract fun insertSong(song: Song)

    @Transaction
    fun insertAlbumWithSong(album: Album, song: Song) {
        val insertedAlbumId = insertAlbum(album)
        song.albumId = insertedAlbumId
        insertSong(song)
    }
}