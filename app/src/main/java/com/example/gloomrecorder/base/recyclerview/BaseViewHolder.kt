package com.example.gloomrecorder.base.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T : Any>(val databinding: ViewDataBinding) : RecyclerView.ViewHolder(databinding.root) {

     abstract fun bind(item: T)
}