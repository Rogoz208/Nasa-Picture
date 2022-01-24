package com.rogoz208.nasapicture.ui.screens.notes

import androidx.lifecycle.LiveData
import com.rogoz208.nasapicture.domain.entities.NoteEntity

interface NotesContract {

    interface ViewModel{
        val notesListLiveData: LiveData<List<NoteEntity>>
        val toastMessageLiveData: LiveData<String>

        fun onNoteClick(noteEntity: NoteEntity)
        fun onNoteMoved(from: Int, to: Int)
        fun onNoteSwiped(position: Int)
        fun updateNotes()
    }
}