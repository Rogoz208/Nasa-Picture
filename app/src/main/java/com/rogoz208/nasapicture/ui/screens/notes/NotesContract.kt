package com.rogoz208.nasapicture.ui.screens.notes

import androidx.lifecycle.LiveData
import com.rogoz208.nasapicture.domain.entities.NoteEntity

interface NotesContract {

    val notesListLiveData: LiveData<List<NoteEntity>>

    fun onNoteClick(noteEntity: NoteEntity)
    fun onNoteMoved(from: Int, to: Int)
    fun onNoteSwiped(position: Int)
    fun updateNotes()
}