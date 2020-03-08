package com.example.room.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.room.db.entities.Album
import com.example.room.db.entities.AlbumWithSongs
import com.example.room.db.entities.BaseAlbumInfo

@Dao
interface AlbumDao {
    @Query("DELETE FROM Album")
    fun deleteAll()

    @Query("SELECT * FROM Album")
    fun getAll(): LiveData<List<Album>>

    @Query("SELECT * FROM Album WHERE id = :id")
    fun getById(id: Long): Album

    @Query("SELECT * FROM Album WHERE name = :name")
    fun getByName(name: String): Album

    @Query("SELECT name, genre FROM Album")
    fun getBaseAlbumsInfo(): List<BaseAlbumInfo>

    @Transaction
    @Query("SELECT * FROM Album")
    fun getAlbumWithSongsList(): List<AlbumWithSongs>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(album: Album): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg albums: Album): List<Long>

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun update(album: Album)

    @Delete
    fun delete(album: Album)
}