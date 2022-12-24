package com.vinodpatildev.smartworkout

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(exerciseEntity: ExerciseEntity)

    @Update()
    suspend fun update(exerciseEntity: ExerciseEntity)

    @Delete()
    suspend fun delete(exerciseEntity: ExerciseEntity)

    @Query("select * from `exercise-table`")
    fun fetchAllExercises(): Flow<List<ExerciseEntity>>

    @Query("select * from `exercise-table` where id=:id")
    fun fetchExerciseById(id:Int) : Flow<ExerciseEntity>
}