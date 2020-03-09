package com.example.room.db.dao

import androidx.room.*
import com.example.room.db.entities.Song
import com.example.room.db.entities.SongWithAlbumName

@Dao
interface SongDao {
    @Query("DELETE FROM Song")
    fun deleteAll()

    @Query("SELECT * FROM Song")
    fun getAll(): List<Song>

    @Query("SELECT * FROM Song WHERE id = :id")
    fun getById(id: Long): Song

    @Query("SELECT * FROM Song WHERE name = :name")
    fun getByName(name: String): Song

    @Query("SELECT * FROM Song WHERE durationInSeconds > 60")
    fun getSongsLongerMinute(): List<Song>

    @Transaction
    @Query("SELECT * FROM Song")
    fun getSongWithAlbumNameList(): List<SongWithAlbumName>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(song: Song): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(vararg song: Song): List<Long>

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun update(song: Song)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateAll(songs: List<Song>): Int

    @Delete
    fun delete(song: Song)

    @Delete
    fun deleteAll(songs: List<Song>): Int
}