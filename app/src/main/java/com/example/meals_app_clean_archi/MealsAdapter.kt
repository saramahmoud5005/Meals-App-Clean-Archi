package com.example.meals_app_clean_archi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.domain.model.Category
import com.example.meals_app_clean_archi.databinding.MealItemBinding

public class MealsAdapter: RecyclerView.Adapter<MealsAdapter.MealsViewHolder>() {

    var categories : List<Category> = listOf();
    class MealsViewHolder(val binding:MealItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category){
            binding.txt1.text = category.strCategory;
            binding.txt2.text = category.strCategoryDescription;
            Glide.with(binding.root.context).load(category.strCategoryThumb).into(binding.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsViewHolder {
        return MealsViewHolder(MealItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: MealsViewHolder, position: Int) {
        holder.bind(categories.get(position))
    }


}