package com.iyoboyi.notes.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iyoboyi.notes.databinding.NoteItemBinding
import com.iyoboyi.notes.models.Note

class NoteAdapter(val notes: List<Note>) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>()  {

    class NoteViewHolder(val binding: NoteItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(note: Note){
            binding.idView.text = note.id.toString()
            binding.titleView.text = note.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.bind(note)
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}