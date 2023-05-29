package com.example.busschedule.data

import android.content.ClipData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoBusSchedule {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: ClipData.Item)

    @Update
    suspend fun update(item: ClipData.Item)

    @Delete
    suspend fun delete(item: ClipData.Item)

    @Query(
        """
        SELECT * FROM schedule 
        ORDER BY arrival_time ASC    
        """
    )
    fun getAll(): Flow<List<BusSchedule>>

    @Query(
        """
        SELECT * FROM schedule 
        WHERE stop_name = :stopName 
        ORDER BY arrival_time ASC 
        """
    )
    fun getByStopName(stopName: String): Flow<List<BusSchedule>>
}