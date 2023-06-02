package com.example.busschedule

import android.app.Application
import com.example.busschedule.data.DatabaseBusSchedule

class BusScheduleApplication: Application() {
    val database: DatabaseBusSchedule by lazy { DatabaseBusSchedule.getDatabase(this) }
}