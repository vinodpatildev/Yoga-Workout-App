package com.vinodpatildev.smartworkout

import android.animation.ValueAnimator
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.vinodpatildev.smartworkout.databinding.RvHistoryItemViewBinding

class ExerciseHistoryAdapter(private val items : ArrayList<ExerciseEntity>,
                             private val updateListener: (id:Int)->Unit,
                             private val deleteListener: (id:Int)->Unit
                             ): RecyclerView.Adapter<ExerciseHistoryAdapter.exerciseViewHolder>() {
    inner class exerciseViewHolder(val binding: RvHistoryItemViewBinding) :RecyclerView.ViewHolder(binding?.root) {
        val llContainer = binding.llContainer
        val tvIndex = binding.tvIndex
        val tvTitle = binding.tvTitle
        val tvTime = binding.tvTime
        val btnDelete = binding.btnDelete
        val btnUpdate = binding.btnUpdate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): exerciseViewHolder {
        return exerciseViewHolder(RvHistoryItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: exerciseViewHolder, position: Int) {
        val context = holder.itemView.context
        val item = items[position]

        holder.tvIndex.text = position.plus(1).toString()
        holder.tvTitle.text = item.title
        holder.tvTime.text = item.time

        holder.btnUpdate.setOnClickListener {
            updateListener.invoke(item.id)
        }
        holder.btnDelete.setOnClickListener {
            deleteListener.invoke(item.id)
        }

//        if(position % 2 == 0){
//            holder.llContainer.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,R.color.colorFirst))
//        }else{
//            holder.llContainer.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,R.color.colorSecond))
//        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}