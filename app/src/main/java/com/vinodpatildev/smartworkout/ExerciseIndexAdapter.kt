package com.vinodpatildev.smartworkout

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.vinodpatildev.smartworkout.databinding.RvExerciseIndexItemBinding

class ExerciseIndexAdapter(val items: ArrayList<ExerciseModel>): RecyclerView.Adapter<ExerciseIndexAdapter.viewHolder>() {
    inner class viewHolder(val itemBinding: RvExerciseIndexItemBinding):RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(item:ExerciseModel){
            itemBinding.tvExerciseIndex.text = item.getId().toString()
            if(item.getIsSelected()){
                itemBinding.tvExerciseIndex.setBackgroundResource(R.drawable.rv_normal_item_current)
            }else if(item.getIsCompleted()){
                itemBinding.tvExerciseIndex.setBackgroundResource(R.drawable.rv_normal_item_completed)
            }else{
                itemBinding.tvExerciseIndex.setBackgroundResource(R.drawable.rv_normal_item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(RvExerciseIndexItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}