package com.school.kotlin.ui.tutorial

import android.content.Context
import android.os.Parcelable
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.school.kotlin.R

class TutorialItemAdapter(context: Context, private val tutorialImages: IntArray) : PagerAdapter() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return tutorialImages.size
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(view: ViewGroup, position: Int): Any {
        val imageLayout = inflater.inflate(R.layout.item_tutorials, view, false)
        val tutorialImage = imageLayout.findViewById(R.id.img_tutorial) as ImageView
        tutorialImage.setImageResource(tutorialImages[position])
        view.addView(imageLayout)
        return imageLayout
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun restoreState(state: Parcelable, loader: ClassLoader) {}

    override fun saveState(): Parcelable? {
        return null
    }


}
