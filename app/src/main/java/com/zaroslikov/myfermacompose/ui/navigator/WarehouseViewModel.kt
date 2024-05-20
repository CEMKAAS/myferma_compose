package com.zaroslikov.myfermacompose.ui.navigator

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.zaroslikov.myfermacompose.data.FermaRepository
import com.zaroslikov.myfermacompose.data.ferma.AddTable
import kotlinx.coroutines.flow.Flow

class WarehouseViewModel(
    savedStateHandle: SavedStateHandle,
    private val fermaRepository: FermaRepository
) : ViewModel() {


    private val itemId: Int = checkNotNull(savedStateHandle[ItemDetailsDestination.itemIdArg])


    val uiState: Flow<List<AddTable>> = fermaRepository.getWareHouse(itemId)


//    fun updateItemUiState(item: Item) {
//        itemUiState = item.toItemDetal()
//    }
//
//    var itemUiState by mutableStateOf(ItemUiState())
//        private set
//
//
//
//    init {
//        viewModelScope.launch {

//                .filterNotNull()
//                .first()
//                .toItemUiState(true)
//        }
//    }

//    fun getFullAdd(): Flow<List<AddTable>> {
//        return fermaRepository.getWareHouse(id=idProject)
//    }

}


data class ItemUiState(
    val itemDetails: Int = 0
)