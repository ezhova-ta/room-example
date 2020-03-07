package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.room.db.entities.Album
import com.example.room.db.entities.Singer
import com.example.room.db.entities.Song

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = App.instance.db
        val albumDao = db.albumDao()
        val songDao = db.songDao()

        val album = Album(
            name = "Test album",
            year = 2020,
            genre = "Test genre",
            rating = 9,
            singer = Singer("Singer first name", "Singer surname")
        )

        val albumId = albumDao.insert(album)

        val song1 = Song(name = "Song1", durationInSeconds = 123L, albumId = albumId)
        val song2 = Song(name = "Song2", durationInSeconds = 220L, albumId = albumId)

        songDao.insertAll(song1, song2)
        val songs =  songDao.getSongWithAlbumNameList()
//        val albumWithSongsList = albumDao.getAlbumWithSongsList()

        Log.d("gfgfgf", "$songs")
    }
}
