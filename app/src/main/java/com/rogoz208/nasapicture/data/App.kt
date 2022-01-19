package com.rogoz208.nasapicture.data

import android.app.Application
import android.content.Context
import com.rogoz208.nasapicture.data.repos.MemoryCacheNotesRepoImpl
import com.rogoz208.nasapicture.data.retrofit.NasaPodApi
import com.rogoz208.nasapicture.data.retrofit.RetrofitNasaPodRepoImpl
import com.rogoz208.nasapicture.domain.entities.NoteEntity
import com.rogoz208.nasapicture.domain.repos.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val NASA_BASE_URL = "https://api.nasa.gov/"

class App : Application() {

    private val retrofit = Retrofit.Builder()
        .baseUrl(NASA_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var api: NasaPodApi = retrofit.create(NasaPodApi::class.java)

    val nasaPodRepo: NasaPodRepo by lazy { RetrofitNasaPodRepoImpl(api) }
    val notesRepo: NotesRepo by lazy { MemoryCacheNotesRepoImpl() }

    override fun onCreate() {
        super.onCreate()

        fillRepoByTestValues()
    }

    private fun fillRepoByTestValues() {
        notesRepo.createNote(NoteEntity("", "Заметка 1", "Текст тестовой заметки"))
        notesRepo.createNote(NoteEntity("", "Заметка 2", "Текст тестовой заметки"))
        notesRepo.createNote(NoteEntity("", "Заметка 3", "Текст тестовой заметки"))
        notesRepo.createNote(NoteEntity("", "Заметка 4", "Текст тестовой заметки"))
        notesRepo.createNote(NoteEntity("", "Заметка 5", "Текст тестовой заметки"))
        notesRepo.createNote(NoteEntity("", "Заметка 6", "Текст тестовой заметки"))
        notesRepo.createNote(NoteEntity("", "Заметка 7", "Текст тестовой заметки"))
        notesRepo.createNote(NoteEntity("", "Заметка 8", "Текст тестовой заметки"))
        notesRepo.createNote(NoteEntity("", "Заметка 9", "Текст тестовой заметки"))
        notesRepo.createNote(NoteEntity("", "Заметка 10", "Текст тестовой заметки"))
    }
}

val Context.app: App
    get() = applicationContext as App