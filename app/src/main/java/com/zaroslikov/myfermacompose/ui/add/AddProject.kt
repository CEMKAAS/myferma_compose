package com.zaroslikov.myfermacompose.ui.add

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zaroslikov.myfermacompose.R
import com.zaroslikov.myfermacompose.data.ferma.ProjectTable
import com.zaroslikov.myfermacompose.ui.AppViewModelProvider
import com.zaroslikov.myfermacompose.ui.TopAppBarStart
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.TimeZone

//lateinit var xx: ByteArray

@Composable
fun AddProject(
    navController: NavController, navigateBack: () -> Unit,
    viewModel: AddProjectViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBarStart(title = "Мое Хозяйство", true, navigateUp = navigateBack)
        },
    ) { innerPadding ->
        AddProjectContainer(
            modifier = Modifier.padding(innerPadding),
            navController,
            scope = scope,
            viewModel = viewModel
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProjectContainer(
    modifier: Modifier,
    navController: NavController,
    scope: CoroutineScope,
    viewModel: AddProjectViewModel
) {

    //Календарь
    val format = SimpleDateFormat("dd.MM.yyyy")
    val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
    val formattedDate: String = format.format(calendar.timeInMillis)

    //Картинка
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
            imageUri = uri
        }
    val context = LocalContext.current
    val bitmap = remember { mutableStateOf<Bitmap?>(null) }

    //Дата
    var openDialog by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()

    //Текст
    var name by rememberSaveable { mutableStateOf("") }
    var date1 by remember { mutableStateOf(formattedDate) }

    if (openDialog) {
        DatePickerDialogSample(datePickerState, date1) { date ->
            date1 = date
            openDialog = false
        }
    }


    Column(modifier = modifier.padding(5.dp, 5.dp)) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            imageUri?.let {
                if (Build.VERSION.SDK_INT < 28) {
                    bitmap.value = MediaStore.Images
                        .Media.getBitmap(context.contentResolver, it)
                } else {
                    val source = ImageDecoder.createSource(context.contentResolver, it)
                    bitmap.value = ImageDecoder.decodeBitmap(source)
                }
            }

            if (imageUri == null) {
                Image(
                    painter = painterResource(R.drawable.baseline_add_photo_alternate_24),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(125.dp)
                        .clickable { launcher.launch("image/*") }
                )
            } else {
                bitmap.value?.let { btm ->
                    Image(
                        bitmap = btm.asImageBitmap(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(125.dp)
                            .clickable { launcher.launch("image/*") }
                    )
                }
            }


            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Название") },
                modifier = Modifier.fillMaxWidth(),
                supportingText = {
                    Text("Укажите название проекта")
                }
                //            isError = () TODO
            )
        }


        OutlinedTextField(
            value = date1,
            onValueChange = {},
            label = { Text("Дата начала проекта") },
            supportingText = {
                Text("Выберите дату начала проекта")
            },
            suffix = { Text(text = "₽") },
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    openDialog = true
                },
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
//                val sdsa = R.drawable.baseline_add_photo_alternate_24
//                val picture = if (imageUri != null) {
//                    val inputStream = imageUri?.let { context.contentResolver.openInputStream(it) }
//                    inputStream?.readBytes()
//                } else {
//                    intToBytes(sdsa)
//                }

//                val sdsa = R.drawable.baseline_add_photo_alternate_24

//                val picture = if (imageUri != null) {
//
//                } else {
//                    intToBytes(sdsa)
//                }


                val stream = ByteArrayOutputStream()
                bitmap.value?.compress(Bitmap.CompressFormat.PNG, 100, stream)
                val picture =  stream.toByteArray()



                scope.launch {
                    viewModel.insertTable(
                        ProjectTable(
                            id = 0,
                            titleProject = name,
                            dateBegin = date1,
                            dateFinal = date1,
                            picture = picture,
                            status = 0,
                            mode = 1
                        )
                    )
                }
                navController.navigate("Start")
            }) {
                Text(text = "Начать")
            }
        }
    }
}

fun intToBytes(i: Int): ByteArray =
    ByteBuffer.allocate(Int.SIZE_BYTES).putInt(i).array()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDialogSample(
    datePickerState: DatePickerState,
    dateToday: String,
    onDateSelected: (String) -> Unit
) {
    DatePickerDialog(
        onDismissRequest = {
            onDateSelected(dateToday)
        },
        confirmButton = {
            TextButton(
                onClick = {
                    val format = SimpleDateFormat("dd.MM.yyyy")
                    val formattedDate: String = format.format(datePickerState.selectedDateMillis)
                    onDateSelected(formattedDate)
                },
            ) { Text("Выбрать") }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDateSelected(dateToday)
                }
            ) { Text("Назад") }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}


//@Preview(showBackground = true)
//@Composable
//fun AddProjectPrewie() {
//    AddProjectContainer(
//        modifier = Modifier.fillMaxSize(),
//        navController = rememberNavController(),
//        scope = rememberCoroutineScope()
//    )
//}