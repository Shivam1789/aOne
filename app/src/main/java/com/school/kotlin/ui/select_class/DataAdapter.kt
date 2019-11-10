package com.school.kotlin.ui.select_class

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.school.kotlin.R

class DataAdapter(private val items: MutableList<ListItem>,private val param: class_selector_callback) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ListItem.TYPE_HEADER) {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.header_layout, parent, false)
            return VHHeader(v)
        } else if (viewType == ListItem.TYPE_ITEM) {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
            return VHItem(v)
        }
        throw RuntimeException("there is no type that matches the type $viewType + make sure your using types correctly")
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is VHHeader) {
            val header = items[position] as Header
            holder.tvName.text = header.name
        } else if (holder is VHItem) {
            val person = items[position] as Person
            holder.tvItem.text = person.name
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].itemType
    }

    internal inner class VHHeader(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView

        init {
            this.tvName = itemView.findViewById<View>(R.id.tvName) as TextView
        }
    }

    internal inner class VHItem(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvItem: TextView

        init {
            this.tvItem = itemView.findViewById<View>(R.id.tvItem) as TextView
            itemView.setOnClickListener(object : View.OnClickListener{
                override fun onClick(p0: View?) {
                    val person = items[layoutPosition] as Person
                    param.selectedItem(person.name)
                }

            })
        }
    }
}
