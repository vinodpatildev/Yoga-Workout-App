package com.vinodpatildev.smartworkout

import android.app.Application

class WorkoutApplication: Application() {
    val db by lazy{
        ExerciseDatabase.getInstance(applicationContext)
    }
}