package com.rogoz208.nasapicture.ui.screens.notes.recycler

import androidx.recyclerview.widget.DiffUtil
import com.rogoz208.nasapicture.domain.entities.NoteEntity

class NotesDiffCallback(
    private val oldList: List<NoteEntity>,
    private val newList: List<NoteEntity>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].uId == newList[newItemPosition].uId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].title == newList[newItemPosition].title
            && oldList[oldItemPosition].details == newList[newItemPosition].details
    }
}