package com.example.room.db.entities

import androidx.room.Embedded
import androidx.room.Relation

data class SongWithAlbumName(
    @Embedded val song: Song,
    @Relation(
        entity = Album::class,
        parentColumn = "albumId",
        entityColumn = "id",
        projection = ["name"]
    ) val albumName: String
)