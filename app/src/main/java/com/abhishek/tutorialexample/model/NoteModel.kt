package com.abhishek.tutorialexample.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
data class NoteModel  constructor(
    var id:UUID = UUID.randomUUID(),
    var name:String,
    var description:String,
    var entrtTime: LocalDateTime = LocalDateTime.now()

)
