package com.example.room.db.entities

import android.graphics.Bitmap
import androidx.room.*

@Entity(
    indices = [Index(value = ["name", "albumId"], unique = true)],
    foreignKeys = [ForeignKey(
        entity = Album::class,
        parentColumns = ["id"],
        childColumns = ["albumId"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )]
)
data class Song(
    @PrimaryKey(autoGenerate = true) var id: Long? = null,
    @ColumnInfo val name: String,
    @ColumnInfo val durationInSeconds: Long,
    @ColumnInfo var albumId: Long
)