package com.rogoz208.nasapicture.data.repos

import com.rogoz208.nasapicture.domain.entities.NoteEntity
import com.rogoz208.nasapicture.domain.repos.NotesRepo
import java.util.*
import kotlin.collections.ArrayList

class MemoryCacheNotesRepoImpl : NotesRepo {

    private val cache: MutableList<NoteEntity> = mutableListOf()

    override fun getNotes(callback: (List<NoteEntity>) -> Unit) {
        callback(ArrayList<NoteEntity>(cache))
    }

    override fun createNote(note: NoteEntity) {
        val newId = UUID.randomUUID().toString()
        cache.add(note.copy(uId = newId))
    }

    override fun deleteNote(uId: String) {
        for (i in cache.indices) {
            if (cache[i].uId == uId) {
                cache.removeAt(i)
            }
        }
    }

    override fun updateNote(uId: String, note: NoteEntity) {
        deleteNote(uId)
        cache.add(note.copy(uId = uId))
    }
}