package com.iyoboyi.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.iyoboyi.notes.adapters.NoteAdapter
import com.iyoboyi.notes.databinding.ActivityMainBinding
import com.iyoboyi.notes.models.Note
import com.iyoboyi.notes.models.NoteDatabase
import com.iyoboyi.notes.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: NoteDatabase
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var viewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //instantiating database
        database = NoteDatabase.getInstance(applicationContext)

        //instantiating viewModels
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.getNotes(database)

        //observe live data from view model
        viewModel.notesLiveData.observe(this, { notes ->

            // creating adapter
            noteAdapter = NoteAdapter(notes) {
                val intent = Intent(this@MainActivity, NotesDetailesActivity::class.java)
                intent.run {
                    putExtra("id", it.id)

                }
                startActivity(intent)
            }
// refreshing recycler view
            binding.notesRecycler.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = noteAdapter
            }
        })


        binding.saveButton.setOnClickListener {
            val title = binding.titleName.text.toString()
            val content = binding.contentName.text.toString()

            saveNote(title, content)
        }


    }

    private fun saveNote(title: String, content: String) {
        val note = Note(id = 0, title, content)
        viewModel.addNote(database, note)

    }

//    private val listener = object : NoteAdapter.OnNoteItemClickListener{
//        override fun onClick(note: Note){
//            val intent = Intent(this@MainActivity, NotesDetailesActivity::class.java)
//            intent.run{
//                putExtra("id", note.id)
//                startActivity(this)
//            }
//        }
//    }
}