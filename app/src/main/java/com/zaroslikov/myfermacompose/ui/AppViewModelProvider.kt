package com.zaroslikov.myfermacompose.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.zaroslikov.myfermacompose.FermaApplication
import com.zaroslikov.myfermacompose.ui.add.AddProjectViewModel
import com.zaroslikov.myfermacompose.ui.navigator.WarehouseViewModel


/**
 * Provides Factory to create instance of ViewModel for the entire Inventory app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {

        initializer {
            StartScreenViewModel(
                fermaApplication().container.fermaRepository
            )
        }

        initializer {
            AddProjectViewModel(fermaApplication().container.fermaRepository)
        }

        initializer {
            WarehouseViewModel(
                this.createSavedStateHandle(),
                fermaApplication().container.fermaRepository
            )
        }

    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [FermaApplication].
 */
fun CreationExtras.fermaApplication(): FermaApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as FermaApplication)
