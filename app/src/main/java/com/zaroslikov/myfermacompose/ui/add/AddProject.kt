package com.zaroslikov.myfermacompose.ui.add

import android.view.ContextThemeWrapper
import android.widget.CalendarView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.datepicker.MaterialDatePicker
import com.zaroslikov.myfermacompose.R
import com.zaroslikov.myfermacompose.data.ferma.ProjectTable
import com.zaroslikov.myfermacompose.ui.AppViewModelProvider
import com.zaroslikov.myfermacompose.ui.TopAppBarStart
import com.zaroslikov.myfermacompose.ui.navigator.AddProductSheet
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone


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
    val snackState = remember { SnackbarHostState() }
    val snackScope = rememberCoroutineScope()
    SnackbarHost(hostState = snackState, Modifier)
    val openDialog = remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()

    val confirmEnabled = remember {
        derivedStateOf { datePickerState.selectedDateMillis != null }
    }

    var name by rememberSaveable { mutableStateOf("") }
    var date by rememberSaveable { mutableStateOf("") }
    if (openDialog.value) {
        DatePickerDialogSample(openDialog, datePickerState)
    }

    Column(modifier = modifier.padding(5.dp, 5.dp)) {

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
//        val constraintsBuilder = CalendarConstraints.Builder()
//            .setValidator(DateValidatorPointBackward.now())
//            .build()
//
//        val datePicker = MaterialDatePicker.Builder.datePicker()
//            .setCalendarConstraints(constraintsBuilder)
//            .setTitleText("Выберите дату")
//            .setSelection(MaterialDatePicker.todayInUtcMilliseconds()) //Todo выбирать дату из EditText
//            .build()
//
//        titleData.editText!!.setOnClickListener {
//            datePicker.show(requireActivity().supportFragmentManager, "wer")
//            datePicker.addOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<Any?> { selection ->
//                val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
//                calendar.timeInMillis = selection as Long
//                val format = java.text.SimpleDateFormat("dd.MM.yyyy")
//                val formattedDate: String = format.format(calendar.time)
//                titleData.editText!!.setText(formattedDate)
//            })
//        }

        OutlinedTextField(
            value = date,
            onValueChange = { date = datePickerState.toString() },
            label = { Text("Дата начала проекта") },
            supportingText = {
                Text("Дата начала проекта")
            },
            readOnly = true,
            suffix = { Text(text = "₽") },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
            modifier = Modifier.clickable {
                scope.launch { openDialog.value = true }
            }.fillMaxWidth(),
        )

        Button(onClick = {
            openDialog.value = true
        }
        ) {
            Text(text = "Начать")
            //TODO Изображение
        }
//        DatePickerDialogSample()

//        OutlinedTextField(
//            value = text,
//            onValueChange = { text = it },
//            label = { Text("10 000") },
//            modifier = Modifier.fillMaxWidth(),
//            supportingText = {
//                Text("Укажите стартовый капитал")
//            },
//            suffix = { Text(text = "₽") },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
////            isError = () TODO
//        )

//        OutlinedTextField(
//            value = text,
//            onValueChange = { text = it },
//            label = { Text("Птицеводство") },
//            modifier = Modifier.fillMaxWidth(),
//            supportingText = {
//                Text("Выберите картинку")
//            },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
////            isError = () TODO
//        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                scope.launch {
                    viewModel.insertTable(
                        ProjectTable(
                            id = 0,
                            titleProject = name,
                            dateBegin = date,
                            dateFinal = date,
                            picture = R.drawable.moroska,
                            status = 0,
                            mode = 1
                        )
                    )
                }
                navController.navigate("Start")
            }) {
                Text(text = "Начать")
                //TODO Изображение
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDialogSample(openDialog: MutableState<Boolean>, datePickerState: DatePickerState) {
    // Decoupled snackbar host state from scaffold state for demo purposes.

    // TODO demo how to read the selected date from the state.
    DatePickerDialog(
        onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            // button. If you want to disable that functionality, simply use an empty
            // onDismissRequest.
            openDialog.value = false
        },
        confirmButton = {
            TextButton(
                onClick = {
                    openDialog.value = false
//                        scope.launch {
//                            snackState.showSnackbar(
//                                "Selected date timestamp: ${datePickerState.selectedDateMillis}"
//                            )
//                        }
                },
//                    enabled = confirmEnabled.value
            ) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    openDialog.value = false
                }
            ) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}


//@Preview(showBackground = true)
//@Composable
//fun AddProjectPrewie() {
//    AddProjectContainer(modifier = Modifier.fillMaxSize(), navController = rememberNavController())
//}