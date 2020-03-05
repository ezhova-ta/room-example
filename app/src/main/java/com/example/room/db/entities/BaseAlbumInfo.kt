package com.example.room.db.entities

import androidx.room.ColumnInfo

data class BaseAlbumInfo(
    @ColumnInfo val name: String,
    @ColumnInfo val genre: String
)