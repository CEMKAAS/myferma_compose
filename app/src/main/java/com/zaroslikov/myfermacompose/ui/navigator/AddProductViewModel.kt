package com.zaroslikov.myfermacompose.ui.navigator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.zaroslikov.myfermacompose.data.FermaRepository
import com.zaroslikov.myfermacompose.data.ferma.AddTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Calendar

class AddProductViewModel(
    savedStateHandle: SavedStateHandle,
    private val fermaRepository: FermaRepository
) : ViewModel() {

//    private var itemUiState by mutableStateOf(AddDetails())


//    val itemId: Int = checkNotNull(savedStateHandle[AddProductDestination.itemIdArg])

//    fun uiState(): Flow<List<AddTable>> = fermaRepository.getAddProduct(itemId)
//    fun uiState(): Flow<List<AddTable>> = fermaRepository.getAddProduct(itemId)

//    suspend fun insertAddTable(addTable: AddTable) {
//        fermaRepository.insertAdd(addTable)
//    }

//    val sd: StateFlow<HomeUiState> =
//        fermaRepository.getAddProductAll().map { HomeUiState(it) }.stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
//            initialValue = HomeUiState()
//        )

//    suspend fun updateHome (homeUiState: HomeUiState)

//    fun getTable() = fermaRepository.getAddProduct(itemId).asLiveData(viewModelScope.coroutineContext)

//    val uiState2: LiveData<List<AddTable>> = fermaRepository.getAddProductAll2().asLiveData()
//
//    val items = fermaRepository.getAddProductAll2()
//
//    fun addItem(item: AddTable) = viewModelScope.launch(Dispatchers.IO) {
//        fermaRepository.insertAdd(item)
//    }
//
//    fun addItem2(item: AddTable) = viewModelScope.launch(Dispatchers.IO) {
//        fermaRepository.insertAdd2(item)
//    }

    fun itemNeco() : Flow<List<AddTable>> = fermaRepository.getAddProductAllNeco()

    fun insertNeco() = viewModelScope.launch {

        val calendar = Calendar.getInstance()
        fermaRepository.insertAdd(
            AddTable(
                id = 0,
                title = "dsd",
                count = 0.0,
                calendar[Calendar.DAY_OF_MONTH],
                (calendar[Calendar.MONTH] + 1),
                calendar[Calendar.YEAR],
                priceAll = "0",
                idPT = 1

        ))
    }

//    val todoList : LiveData<List<AddTable>> = fermaRepository.getAddProductAll()

//    fun insertIt() = viewModelScope.launch {
//
//        fermaRepository.insertAdd(itemUiState.toItem())
//
//    }

//    companion object {
//        private const val TIMEOUT_MILLIS = 1_000L
//    }

}

data class HomeUiState(val itemList: List<AddTable> = listOf())


data class AddDetails(
    var id: Int = 0,
    var title: String = "",
    var count: Double = 0.0,
    var day: Int = 1,
    var mount: Int = 1,
    var year: Int = 1,
    var priceAll: String = "",
    val idPT: Int = 1
)

fun AddDetails.toItem(): AddTable = AddTable(
    id = id,
    title = title,
    count = count,
    day = day,
    mount = mount,
    year = year,
    priceAll = priceAll,
    idPT = idPT
)

fun AddTable.toItemDetal(): AddDetails = AddDetails(
    id = id,
    title = title,
    count = count,
    day = day,
    mount = mount,
    year = year,
    priceAll = priceAll,
    idPT = idPT
)