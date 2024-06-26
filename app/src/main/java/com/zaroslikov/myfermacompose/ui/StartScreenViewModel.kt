package com.zaroslikov.myfermacompose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.zaroslikov.myfermacompose.FermaApplication
import com.zaroslikov.myfermacompose.data.FermaRepository
import com.zaroslikov.myfermacompose.data.ferma.ProjectTable
import kotlinx.coroutines.flow.Flow

class StartScreenViewModel(private val fermaRepository: FermaRepository) : ViewModel() {

    fun getFullSchedule(): Flow<List<ProjectTable>> {
        return fermaRepository.getItem()
    }

//    companion object {
//        val factory: ViewModelProvider.Factory = viewModelFactory {
//            initializer {
//                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as FermaApplication)
//                StartScreenViewModel(application.database.fermaDao())
//            }
//        }
//    }
}