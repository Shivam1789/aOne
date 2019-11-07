package com.school.kotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.school.kotlin.R


class UserChildListAdapter(private var mList: List<String?>, var  context: Context) : RecyclerView.Adapter<UserChildListAdapter.Items>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Items {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.forgot_password, parent, false)
        return Items(view)


    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: Items, position: Int) {

        if (mList.isNotEmpty()) {
            holder.bindData(mList[position])

        }
    }

    inner class Items(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindData(data: String?) {

            /*set the email*/
            if (data!= null) {
                //itemView.text_user_name.text = data

            }


        }


    }
}