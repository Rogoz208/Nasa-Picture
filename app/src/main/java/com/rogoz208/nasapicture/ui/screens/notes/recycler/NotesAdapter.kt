package com.rogoz208.nasapicture.ui.screens.notes.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rogoz208.nasapicture.domain.entities.NoteEntity

class NotesAdapter(private val onNoteClickListener: ((item: NoteEntity) -> Unit)) :
    RecyclerView.Adapter<NoteViewHolder>() {

    var data: List<NoteEntity> = ArrayList()
        get() = ArrayList(field)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(parent, onNoteClickListener = onNoteClickListener)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    private fun getItem(position: Int): NoteEntity {
        return data[position]
    }
}