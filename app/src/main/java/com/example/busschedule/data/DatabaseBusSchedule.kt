package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(BusSchedule::class), version = 1, exportSchema = false)
abstract class DatabaseBusSchedule : RoomDatabase(){

    abstract fun busScheduleDao(): DaoBusSchedule

    companion object {
        @Volatile
        private var INSTANCE: DatabaseBusSchedule? = null

        fun getDatabase(context: Context): DatabaseBusSchedule {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    DatabaseBusSchedule::class.java,
                    "busschedule_database"
                )
                    .createFromAsset("database/bus_schedule.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }

}