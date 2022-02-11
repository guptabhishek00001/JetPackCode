package com.abhishek.tutorialexample.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.abhishek.tutorialexample.model.NoteModel

@RequiresApi(Build.VERSION_CODES.O)
class NoteDataSorce {

    fun loadNotes(): List<NoteModel>{

        return listOf(

            NoteModel(name = "Abhi", description = "Kanpur"),
            NoteModel(name = "Abhi", description = "Kanpur"),
            NoteModel(name = "Abhi", description = "Kanpur"),
            NoteModel(name = "Abhi", description = "Kanpur"),
            NoteModel(name = "Abhi", description = "Kanpur"),
            NoteModel(name = "Abhi", description = "Kanpur"),
            NoteModel(name = "Abhi", description = "Kanpur"),
            NoteModel(name = "Abhi", description = "Kanpur"),
            NoteModel(name = "Abhi", description = "Kanpur")

        )
    }
}