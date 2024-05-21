package com.zaroslikov.myfermacompose.ui.navigator

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.zaroslikov.myfermacompose.data.FermaRepository
import com.zaroslikov.myfermacompose.data.ferma.AddTable
import kotlinx.coroutines.flow.Flow

class AddProductViewModel(
    savedStateHandle: SavedStateHandle,
    private val fermaRepository: FermaRepository
) : ViewModel() {


    private val itemId: Int = checkNotNull(savedStateHandle[AddProductDestination.itemIdArg])
    fun uiState(): Flow<List<AddTable>> = fermaRepository.getWareHouse(itemId)

}