package com.zaroslikov.myfermacompose.ui.navigator

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zaroslikov.myfermacompose.data.FermaRepository
import com.zaroslikov.myfermacompose.data.ferma.AddTable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WarehouseViewModel(
    savedStateHandle: SavedStateHandle,
    private val fermaRepository: FermaRepository
) : ViewModel() {


//    private val itemId: Int = checkNotNull(savedStateHandle[ItemDetailsDestination.itemIdArg])
//
//    fun uiState(): Flow<List<AddTable>> = fermaRepository.getWareHouse(itemId)

//    init {
//        viewModelScope.launch {
//            val calendar = Calendar.getInstance()
//            val timeIn =
//                calendar[Calendar.DAY_OF_MONTH].toString() + "." + (calendar[Calendar.MONTH] + 1) + "." + calendar[Calendar.YEAR]
//
//                fermaRepository.insertAdd(AddTable(0,"govno", 36.0,2,5,1996,"88",1))
//        }
//    }



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