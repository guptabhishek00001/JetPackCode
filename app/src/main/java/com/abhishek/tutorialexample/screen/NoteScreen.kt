package com.abhishek.tutorialexample.screen

import android.annotation.SuppressLint
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abhishek.tutorialexample.R
import com.abhishek.tutorialexample.component.NoteButton
import com.abhishek.tutorialexample.component.NoteInputText
import com.abhishek.tutorialexample.model.NoteModel
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("RememberReturnType")
@ExperimentalComposeUiApi
@Composable
fun NoteScreen(
    note:List<NoteModel>,
    onAddNotes:(NoteModel)->Unit,
    onRemoveNotes:(NoteModel)->Unit,
) {
    val context = LocalContext.current


    var name = rememberSaveable {
        mutableStateOf("")
    }

    var description = rememberSaveable {
        mutableStateOf("")
    }

    Column(modifier = Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally) {

        TopAppBar(title = {
            Text(text = stringResource(id = R.string.app_name))
        }, actions = {
            Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "ToolICon")
        },
            backgroundColor = Color.Gray)


        //Content
        Column(
            modifier = Modifier
                .padding(all = 10.dp)
                .fillMaxWidth()) {
            TextField(modifier = Modifier.fillMaxWidth(),value = name.value,
                onValueChange = { name.value = it },
                placeholder = { Text(text = "Enter user name") })

        }

        Column(
            modifier = Modifier
                .padding(all = 10.dp)
                .fillMaxWidth(),
        ) {
            TextField(modifier = Modifier.fillMaxWidth(),value = description.value,
                onValueChange = { description.value = it },
                placeholder = { Text(text = "Description") })
        }
        
        NoteButton(text = "Save", onClick = {
            if(name.value.isNotEmpty() && description.value.isNotEmpty()){

                //save note
                onAddNotes(NoteModel(name = name.value, description = description.value))
                name.value=""
                description.value=""
            }
        })

        Spacer(modifier = Modifier.padding(10.dp))

        LazyColumn(reverseLayout = true){

            items(note){notes->
                NoteRow(note = notes, onNoteClicked ={

                    onRemoveNotes(notes)

                } )
            }

        }

    }


}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteRow(modifier: Modifier= Modifier,
            note:NoteModel,
            onNoteClicked:(NoteModel)->Unit){

    Surface(modifier = Modifier.padding(10.dp).fillMaxWidth(),
            shape = RoundedCornerShape(10),
            color = Color(0xF4ECECE7),
            elevation = 5.dp) {

        Column(modifier.padding(10.dp).clickable {
            onNoteClicked(note)
        }) {

            Text(text = note.name, style = MaterialTheme.typography.h6)
            Text(text = note.description,style = MaterialTheme.typography.subtitle1)
            Text(text = note.entrtTime.format(DateTimeFormatter.ofPattern("EEE, d MMM")),style = MaterialTheme.typography.subtitle1)

        }



    }



}


@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun NotesScreen() {
    NoteScreen(note = emptyList(), onAddNotes = {}, onRemoveNotes = {})
}