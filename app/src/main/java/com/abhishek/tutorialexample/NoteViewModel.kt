package com.abhishek.tutorialexample

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.abhishek.tutorialexample.data.NoteDataSorce
import com.abhishek.tutorialexample.model.NoteModel

@RequiresApi(Build.VERSION_CODES.O)
class NoteViewModel : ViewModel() {

    private var noteList = mutableStateListOf<NoteModel>()

    init {
        noteList.addAll(NoteDataSorce().loadNotes())
    }


    fun addNote(noteModel: NoteModel){
        noteList.add(noteModel)
    }

    fun deleteNote(noteModel: NoteModel){
        noteList.remove(noteModel)
    }

    fun getAllNotes():List<NoteModel>{
        return noteList
    }
}