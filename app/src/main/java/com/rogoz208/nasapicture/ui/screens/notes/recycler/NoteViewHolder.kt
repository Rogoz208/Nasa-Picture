package com.rogoz208.nasapicture.ui.screens.notes.recycler

import android.view.*
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rogoz208.nasapicture.R
import com.rogoz208.nasapicture.databinding.ItemNoteViewHolderBinding
import com.rogoz208.nasapicture.domain.entities.NoteEntity

class NoteViewHolder(parent: ViewGroup, private val onNoteClickListener: (item: NoteEntity) -> Unit) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_note_view_holder, parent, false)
    ) {
    private val binding by viewBinding(ItemNoteViewHolderBinding::bind)

    fun bind(note: NoteEntity) {
        binding.titleTextView.text = note.title
        binding.detailTextView.text = note.details

        itemView.setOnClickListener { onNoteClickListener(note) }
    }
}
