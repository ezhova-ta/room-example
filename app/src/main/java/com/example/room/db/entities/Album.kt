package com.example.room.db.entities

import androidx.room.*
import com.example.room.db.entities.Singer

@Entity
data class Album(
    @PrimaryKey(autoGenerate = true) var id: Long? = null,
    @ColumnInfo val name: String,
    @ColumnInfo val year: Int,
    @ColumnInfo val genre: String,
    @ColumnInfo val rating: Int,
    @Embedded val singer: Singer,
    @ColumnInfo val url: String?
)