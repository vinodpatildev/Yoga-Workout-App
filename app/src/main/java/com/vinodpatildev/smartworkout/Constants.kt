package com.vinodpatildev.smartworkout

object Constants {
    fun defaultExerciseList(): ArrayList<ExerciseModel>{
        val exerciseList = ArrayList<ExerciseModel>()
        var exercise:ExerciseModel? = null

        exercise = ExerciseModel(1,"Pranamasana",R.drawable.icon_1_pranamasana,false,false)
        exerciseList.add(exercise)

        exercise = ExerciseModel(2,"Hasta Uttanasana",R.drawable.icon_2_hasta_uttanasana,false,false)
        exerciseList.add(exercise)

        exercise = ExerciseModel(3,"Hasta Padasana",R.drawable.icon_3_hasta_padasana,false,false)
        exerciseList.add(exercise)

        exercise = ExerciseModel(4,"Ashwa Sandhalanasana",R.drawable.icon_4_ashwa_sandhalanasana,false,false)
        exerciseList.add(exercise)

        exercise = ExerciseModel(5,"Dandasana",R.drawable.icon_5_dandasana,false,false)
        exerciseList.add(exercise)

        exercise = ExerciseModel(6,"Ashtanga Namaskara",R.drawable.icon_6_ashtanga_namaskara,false,false)
        exerciseList.add(exercise)

        exercise = ExerciseModel(7,"Bhujangasana",R.drawable.icon_7_bhujangasana,false,false)
        exerciseList.add(exercise)

        exercise = ExerciseModel(8,"Adho Mukha Svanasana",R.drawable.icon_8_adho_mukha_svanasana,false,false)
        exerciseList.add(exercise)

        exercise = ExerciseModel(9,"Ashwa Sanchalanasana",R.drawable.icon_9_ashwa_sanchalanasana,false,false)
        exerciseList.add(exercise)

        exercise = ExerciseModel(10,"Hasta_Padasana",R.drawable.icon_10_hasta_padasana,false,false)
        exerciseList.add(exercise)

        exercise = ExerciseModel(11,"Hasta Uttanasana",R.drawable.icon_11_hasta_uttanasana,false,false)
        exerciseList.add(exercise)

        exercise = ExerciseModel(12,"Tadasana",R.drawable.icon_12_tadasana,false,false)
        exerciseList.add(exercise)



        return exerciseList
    }
}