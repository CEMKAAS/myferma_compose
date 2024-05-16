package com.zaroslikov.myfermacompose.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.zaroslikov.myfermacompose.data.ferma.AddTable
import com.zaroslikov.myfermacompose.data.ferma.ExpensesTable
import com.zaroslikov.myfermacompose.data.ferma.ProjectTable
import com.zaroslikov.myfermacompose.data.ferma.SaleTable
import com.zaroslikov.myfermacompose.data.ferma.WriteOffTable
import com.zaroslikov.myfermacompose.data.incubator.AiringTable
import com.zaroslikov.myfermacompose.data.incubator.DampTable
import com.zaroslikov.myfermacompose.data.incubator.IncubatorTable
import com.zaroslikov.myfermacompose.data.incubator.OverTable
import com.zaroslikov.myfermacompose.data.incubator.TempTable

@Database(
    entities = [ ProjectTable::class, AddTable::class, SaleTable::class, WriteOffTable::class, ExpensesTable::class, IncubatorTable::class, TempTable::class, OverTable::class, DampTable::class, AiringTable::class],
    version = 1,
    exportSchema = false
)
abstract class FermaDatabase : RoomDatabase() {

    abstract fun fermaDao(): FermaDao

    companion object {
        @Volatile
        private var Instance: FermaDatabase? = null

        fun getDatabase(context: Context): FermaDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, FermaDatabase::class.java, "item_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}