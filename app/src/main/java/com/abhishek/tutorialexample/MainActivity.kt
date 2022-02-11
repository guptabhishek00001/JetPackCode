package com.abhishek.tutorialexample

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.abhishek.tutorialexample.data.NoteDataSorce
import com.abhishek.tutorialexample.model.NoteModel
import com.abhishek.tutorialexample.screen.NoteScreen
import com.abhishek.tutorialexample.ui.theme.TutorialExampleTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorialExampleTheme {
                // A surface container using the 'background' color from the theme

                val context = LocalContext.current


                var notes = remember {
                    mutableStateListOf<NoteModel>()
                }
                Surface(color = MaterialTheme.colors.background) {
                    NoteScreen(note = notes, onAddNotes = {
                        notes.add(it)
                    }, onRemoveNotes = {
                        Toast.makeText(context, "clikced${it.name}", Toast.LENGTH_LONG).show()
                        notes.remove(it)
                    })
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TutorialExampleTheme {
    }
}