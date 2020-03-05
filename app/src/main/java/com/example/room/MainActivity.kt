package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.room.db.entities.Album
import com.example.room.db.entities.Singer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = App.instance.db
        val albumDao = db.albumDao()

        val album1 = Album(
            name = "Test album",
            year = 2020,
            genre = "Test genre",
            rating = 9,
            singer = Singer("Singer first name", "Singer surname")
        )

        val album2 = Album(
            name = "Test album 2",
            year = 2019,
            genre = "Test genre 2",
            rating = 9,
            singer = Singer("Singer2 first name", "Singer 2 surname")
        )

        albumDao.insert(album1)
        albumDao.insert(album2)

//        albumDao.deleteAll()

        val albums = albumDao.getAll()
        Log.d("gfgfgf", "$albums")
    }
}
