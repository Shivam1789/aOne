package com.school.kotlin.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.school.kotlin.R
import com.school.kotlin.utils.loadImg

class ImageSliderAdapter(internal var context: Context, internal var images: List<String?>?) : PagerAdapter() {
    internal var layoutInflater: LayoutInflater


    init {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        return images?.size?:0
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = layoutInflater.inflate(R.layout.layout_item, container, false)

        val imageView = itemView.findViewById(R.id.imageView) as ImageView
        images?.get(position)?.let {
            imageView.loadImg(it,context)
        }

        container.addView(itemView)

        //listening to image click


        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}