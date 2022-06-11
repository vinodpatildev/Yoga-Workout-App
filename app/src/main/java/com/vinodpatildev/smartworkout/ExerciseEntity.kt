package com.vinodpatildev.smartworkout

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "exercise-table")
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,

    val title:String = "",

    val time:String = ""
)
