package com.example.room.db.dao

import androidx.room.*
import com.example.room.db.entities.Album
import com.example.room.db.entities.AlbumWithSongs
import com.example.room.db.entities.BaseAlbumInfo

@Dao
interface AlbumDao {
    @Query("select * from Album")
    fun getAll(): List<Album>

    @Query("select * from Album where id = :id")
    fun getById(id: Long)

    @Query("select * from Album where name = :name")
    fun getByName(name: String)

    @Query("select name, genre from Album")
    fun getBaseAlbumsInfo(): List<BaseAlbumInfo>

    @Query("select * from Album")
    fun getAlbumWithSongsList(): List<AlbumWithSongs>

    @Insert
    fun insert(album: Album)

    @Insert
    fun insertAll(vararg albums: Album)

    @Update
    fun update(album: Album)

    @Delete
    fun delete(album: Album)
}