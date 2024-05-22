package com.zaroslikov.myfermacompose.ui.navigator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zaroslikov.myfermacompose.data.FermaRepository
import com.zaroslikov.myfermacompose.data.ferma.AddTable
import com.zaroslikov.myfermacompose.data.ferma.ProjectTable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class AddProductViewModel(
    savedStateHandle: SavedStateHandle,
    private val fermaRepository: FermaRepository
) : ViewModel() {

    var itemUiState by mutableStateOf(AddDetails())
        private set


    val itemId: Int = checkNotNull(savedStateHandle[AddProductDestination.itemIdArg])

//    fun uiState(): Flow<List<AddTable>> = fermaRepository.getAddProduct(itemId)
//    fun uiState(): Flow<List<AddTable>> = fermaRepository.getAddProduct(itemId)

//    suspend fun insertAddTable(addTable: AddTable) {
//        fermaRepository.insertAdd(addTable)
//    }

    val sd = fermaRepository.getAddProduct(itemId)

    fun insertIt() = viewModelScope.launch {
        fermaRepository.insertAdd(itemUiState.toItem())
    }


}

data class AddDetails(
    var id: Int = 1,
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