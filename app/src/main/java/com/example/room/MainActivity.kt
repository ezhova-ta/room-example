package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.room.db.entities.Album
import com.example.room.db.entities.Singer
import com.example.room.db.entities.Song
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = App.instance.db
        val albumDao = db.albumDao()
        val songDao = db.songDao()



        Log.d("dbDebug", "${albumDao.getAll()}")
        Log.d("dbDebug", "${songDao.getAll()}")
    }

    private fun createAlbum1(): Album {
        return Album(
            name = "Album1",
            year = 2020,
            genre = "Rock",
            rating = 9,
            singer = Singer("Singer1 first name", "Singer1 surname"),
            url = "https://www.apple.com/apple-music/2125/",
            publicationDate = Date()
        )
    }

    private fun createAlbum2(): Album {
        return Album(
            name = "Album2",
            year = 2020,
            genre = "Pop",
            rating = 9,
            singer = Singer("Singer2 first name", "Singer2 surname"),
            url = "https://www.apple.com/apple-music/47852/",
            publicationDate = Date()
        )
    }

    private fun createSong1(albumId: Long): Song {
        return Song(
            name = "Song1",
            durationInSeconds = 123L,
            albumId = albumId
        )
    }

    private fun createSong2(albumId: Long): Song {
        return Song(
            name = "Song2",
            durationInSeconds = 220L,
            albumId = albumId
        )
    }

    private fun createSong3(albumId: Long): Song {
        return Song(
            name = "Song3",
            durationInSeconds = 310L,
            albumId = albumId
        )
    }
}
