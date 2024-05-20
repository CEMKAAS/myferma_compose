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
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class WarehouseViewModel(
    savedStateHandle: SavedStateHandle,
    private val fermaRepository: FermaRepository
) : ViewModel() {

    fun updateItemUiState(item: Item) {
        itemUiState = item.toItemDetal()
    }

    var itemUiState by mutableStateOf(ItemUiState())
        private set

    private val itemId: Int = checkNotNull(savedStateHandle[ItemEditDestination.itemIdArg])

    init {
        viewModelScope.launch {
            itemUiState = fermaRepository.getWareHouse(itemId)
//                .filterNotNull()
//                .first()
//                .toItemUiState(true)
        }
    }

//    fun getFullAdd(): Flow<List<AddTable>> {
//        return fermaRepository.getWareHouse(id=idProject)
//    }

}


data class ItemUiState(
    val itemDetails: Int = 0
)