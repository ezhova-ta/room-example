package com.example.room.db.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.room.db.entities.Singer

@Entity
data class Album(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo val name: String,
    @ColumnInfo val year: Int,
    @ColumnInfo val genre: String,
    @ColumnInfo val rating: Int,
    @Embedded val singer: Singer
)