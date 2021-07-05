package com.iyoboyi.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iyoboyi.notes.databinding.ActivityMainBinding
import com.iyoboyi.notes.models.Note
import com.iyoboyi.notes.models.NoteDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: NoteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    private fun saveNote(title: String, content: String) {
    val note = Note(id = 0, title, content)

    }
}