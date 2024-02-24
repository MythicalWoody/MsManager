package com.example.myprojectmanager.Adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myprojectmanager.databinding.ItemLabelColorBinding
import java.util.ArrayList

class LabelColorListItemsAdapter(
    private val context: Context,
    private var list: ArrayList<String>,
    private val mSelectedColor: String
) : RecyclerView.Adapter<LabelColorListItemsAdapter.MyViewHolder>() {

    var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemLabelColorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]

        holder.binding.viewMain.setBackgroundColor(Color.parseColor(item))

        if (item == mSelectedColor) {
            holder.binding.ivSelectedColor.visibility = View.VISIBLE
        } else {
            holder.binding.ivSelectedColor.visibility = View.GONE
        }

        holder.binding.root.setOnClickListener {
            onItemClickListener?.onClick(position, item)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(val binding: ItemLabelColorBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickListener {
        fun onClick(position: Int, color: String)
    }
}