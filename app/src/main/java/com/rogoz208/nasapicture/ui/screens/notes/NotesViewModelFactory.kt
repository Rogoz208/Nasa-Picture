package com.rogoz208.nasapicture.ui.screens.notes

import androidx.lifecycle.*
import com.rogoz208.nasapicture.domain.repos.NotesRepo

class NotesViewModelFactory(private val notesRepo: NotesRepo) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NotesViewModel(notesRepo) as T
    }
}