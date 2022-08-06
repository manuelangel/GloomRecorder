package com.example.gloomrecorder.base.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates

abstract class BaseRvAdapter<T:Any>(items:List<T>? = emptyList()) : RecyclerView.Adapter<BaseViewHolder<T>>() {

    var items: List<T> by Delegates.observable(items?: emptyList()) {
            _, old, new ->
        autoNotify(old, new) { o, n -> o == n }
    }


    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T>

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int  = items.size

    private fun <T> autoNotify(old: List<T>, new: List<T>, compare: (T, T) -> Boolean) {
        val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return compare(old[oldItemPosition], new[newItemPosition])
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return old[oldItemPosition] == new[newItemPosition]
            }

            override fun getOldListSize() = old.size

            override fun getNewListSize() = new.size
        })

        diff.dispatchUpdatesTo(this)
    }

}