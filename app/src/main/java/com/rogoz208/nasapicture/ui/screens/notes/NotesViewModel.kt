package com.rogoz208.nasapicture.ui.screens.notes

import androidx.lifecycle.*
import com.rogoz208.nasapicture.domain.entities.NoteEntity
import com.rogoz208.nasapicture.domain.repos.NotesRepo

class NotesViewModel(private val notesRepo: NotesRepo) : ViewModel(), NotesContract {

    override val notesListLiveData = MutableLiveData<List<NoteEntity>>()
    override val toastMessageLiveData = MutableLiveData<String>()

    init {
        updateNotes()
    }

    override fun updateNotes() {
        notesRepo.getNotes { notes ->
            notesListLiveData.postValue(notes)
        }
    }

    override fun onNoteClick(noteEntity: NoteEntity) {
        toastMessageLiveData.postValue("${noteEntity.title} is clicked")
    }

    override fun onNoteMoved(from: Int, to: Int) {
        notesRepo.swapNotes(from, to)
        updateNotes()
    }

    override fun onNoteSwiped(position: Int) {
        notesRepo.deleteNote(position)
        updateNotes()
    }

}