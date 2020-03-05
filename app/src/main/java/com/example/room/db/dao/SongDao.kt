package com.example.room.db.dao

import androidx.room.*
import com.example.room.db.entities.Song

@Dao
interface SongDao {
    @Query("select * from Song")
    fun getAll(): List<Song>

    @Query("select * from Song where id = :id")
    fun getById(id: Long)

    @Query("select * from Song where name = :name")
    fun getByName(name: String)

    @Query("select * from Song where durationInSeconds > 60")
    fun getSongsLongerMinute(): List<Song>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(song: Song): Long

    @Insert
    fun insertAll(vararg song: Song): List<Long>

    @Update
    fun update(song: Song)

    @Update
    fun updateAll(songs: List<Song>): Int

    @Delete
    fun delete(song: Song)

    @Delete
    fun deleteAll(songs: List<Song>): Int
}