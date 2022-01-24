package com.rogoz208.nasapicture.domain.repos

import com.rogoz208.nasapicture.domain.entities.NoteEntity

interface NotesRepo {

    fun getNotes(callback: (List<NoteEntity>) -> Unit)

    fun createNote(note: NoteEntity)

    fun deleteNote(uId: String)

    fun deleteNote(position: Int)

    fun updateNote(uId: String, note: NoteEntity)

    fun swapNotes(from: Int, to: Int)

}