package com.example.room.db.entities

import androidx.room.Embedded
import androidx.room.Relation

data class AlbumWithSongs(
    @Embedded val album: Album,

    @Relation(parentColumn = "id", entityColumn = "albumId")
    val songs: List<Song>
)