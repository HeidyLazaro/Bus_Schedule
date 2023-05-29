package com.example.busschedule

import android.app.Application
import com.example.busschedule.data.DatabaseBusSchedule

class AppBusSchedule : Application() {
    val database: DatabaseBusSchedule by lazy {
        DatabaseBusSchedule.getDatabase(this) }
}