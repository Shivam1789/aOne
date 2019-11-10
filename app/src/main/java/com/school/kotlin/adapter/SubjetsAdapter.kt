package com.school.kotlin.adapter

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.school.kotlin.R

class SubjetsAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val DATA = 1
    private val LOADER = 2

    //for load more check funtionality
    private var mLinearLayoutManager: LinearLayoutManager? = null
    private var mVisibleItemCount: Int = 0
    private var mTotalItemCount: Int = 0
    private var mFirstVisibleItem: Int = 0
    private var mIsNoMoreLoading: Boolean = true

    private val list = ArrayList<Any?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            DATA -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
                return ViewHolderItem(view)

            }

            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.list_loadmore, parent, false)
                ViewHolderItemLoader(view)
            }


        }

    }

    override fun getItemCount(): Int {
        return 4
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolderItem) {
//            val item = list[position]
//            item?.let { holder.bind(it as DataItem) }


        }
    }

    override fun getItemViewType(position: Int): Int {
//        val data = list[position]
//        return if (data is DataItem) {
//            DATA
//        } else {
//            LOADER
//        }
        return DATA
    }

//    fun populateNewList(newList: List<DataItem?>) {
//        list.addAll(newList)
//        notifyDataSetChanged()
//    }
//
//    fun updateNotificationItemLocally(pos: Int?) {
//        (list[pos!!] as DataItem).followStatus = 1
//        notifyItemChanged(pos)
//    }


    fun clearList() {
        list.clear()
        notifyDataSetChanged()
    }

    fun updateLoadmore(status: Boolean) {
        mIsNoMoreLoading = status
    }

    fun addLoadMore() {
        list.add(null)
        notifyItemInserted(list.size.minus(1))
    }

    fun removeLoadMore() {
        if (list.isNotEmpty()) {
            val lastPos = list.size.minus(1)
            if (list[lastPos] == null) {
                list.removeAt(lastPos)
                notifyItemRemoved(lastPos)
            }
        }
    }


    inner class ViewHolderItemLoader(itemView: View) : RecyclerView.ViewHolder(itemView)


    inner class ViewHolderItem(view: View) : RecyclerView.ViewHolder(view) {
        init {

        }

    }


    /*
       * Setting recycler view pagination*/
    fun setRecyclerView(linearLayoutManager: LinearLayoutManager, recyclerView: RecyclerView) {
        mLinearLayoutManager = linearLayoutManager
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    mVisibleItemCount = linearLayoutManager.childCount
                    mTotalItemCount = linearLayoutManager.itemCount
                    mFirstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition()

                    //If the recycler is not Loading and data is not of the end page then
                    //trigger the LoadMore event
                    if ((!mIsNoMoreLoading)) {
                        if ((mFirstVisibleItem + mVisibleItemCount) >= mTotalItemCount
                                && mFirstVisibleItem >= 0
                        ) {
//                            mOnLoadMore()
                            mIsNoMoreLoading = true
                        }
                    }
                }

            }

        })

    }
}