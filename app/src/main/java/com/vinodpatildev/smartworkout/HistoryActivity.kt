package com.vinodpatildev.smartworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.vinodpatildev.smartworkout.databinding.ActivityHistoryBinding
import com.vinodpatildev.smartworkout.databinding.RvHistoryItemViewBinding
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {
    private var binding: ActivityHistoryBinding? = null
    private var exerciseAdapter: ExerciseHistoryAdapter? = null
    private var exerciseDao: ExerciseDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.tbHistory)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            binding?.tbHistory?.setNavigationOnClickListener {
                finish()
                onBackPressed()
            }

            exerciseDao = (application as WorkoutApplication).db.exerciseDao()

            lifecycleScope.launch{
                exerciseDao!!.fetchAllExercises().collect{
                    val list= ArrayList(it)
                    setupHistoryExerciseRV(list, exerciseDao!!)
                }
            }
        }
    }

    private fun setupHistoryExerciseRV(list: ArrayList<ExerciseEntity>, exerciseDao:ExerciseDao) {

        exerciseAdapter = ExerciseHistoryAdapter(
            list,
            {itemId->
                updateExercise(itemId)
            },
            {itemId->
                deleteExercise(itemId)
            }
            )
        binding?.rvHistory?.adapter = exerciseAdapter
    }
    private fun updateExercise(id: Int){
        lifecycleScope.launch{
            exerciseDao?.fetchExerciseById(id)?.collect{
                exerciseDao!!.update(ExerciseEntity(id=id, title="Updated Data", time=System.currentTimeMillis().toString()))
            }
        }
    }
    private fun deleteExercise(id: Int){
        lifecycleScope.launch{
            exerciseDao?.fetchExerciseById(id)?.collect{
                exerciseDao!!.delete(it)
            }
        }
    }

}