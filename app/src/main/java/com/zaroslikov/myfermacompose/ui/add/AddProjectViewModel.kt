package com.zaroslikov.myfermacompose.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.zaroslikov.myfermacompose.FermaApplication
import com.zaroslikov.myfermacompose.data.FermaDao
import com.zaroslikov.myfermacompose.data.FermaRepository
import com.zaroslikov.myfermacompose.data.ferma.ProjectTable
import com.zaroslikov.myfermacompose.ui.StartScreenViewModel
import kotlinx.coroutines.flow.Flow

class AddProjectViewModel(private val fermaRepository: FermaRepository) : ViewModel()  {

    suspend fun insertTable(item: ProjectTable) {
        fermaRepository.insert(item)
    }


//    companion object {
//        val factory: ViewModelProvider.Factory = viewModelFactory {
//            initializer {
//                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as FermaApplication)
//                AddProjectViewModel(application.database.fermaDao())
//            }
//        }
//    }
}