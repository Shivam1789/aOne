package com.school.kotlin.ui.tutorial

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.school.kotlin.R
import com.school.kotlin.ui.login.FragmentLogin
import com.school.kotlin.ui.other.BaseFragment
import kotlinx.android.synthetic.main.fragment_tutorial.*

class FragmentTutorial : BaseFragment() {

    private val images = intArrayOf(R.drawable.ic_splash, R.drawable.ic_splash, R.drawable.ic_splash)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_tutorial, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tutorialItemAdapter = TutorialItemAdapter(activity, images)
        fragment_vp_tutorial.adapter = tutorialItemAdapter
        fragment_tab_tutorial.setupWithViewPager(fragment_vp_tutorial)
        fragment_btn_tutorial.text = activity.getText(R.string.btnnext)
        setListeners()
    }


    private fun setListeners() {
        fragment_vp_tutorial.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                if (images.size-1 == position){
                    fragment_btn_tutorial.text = activity.getText(R.string.submit)
                }else{
                    fragment_btn_tutorial.text = activity.getText(R.string.btnnext)
                }
            }

            override fun onPageSelected(position: Int) {
            }

        })

        fragment_btn_tutorial.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                if (fragment_btn_tutorial.text == activity.getText(R.string.submit)){
                    addFragment(FragmentLogin(), true)
                }else{
                    fragment_vp_tutorial.setCurrentItem(fragment_vp_tutorial.currentItem + 1)
                }
            }

        })
    }

}
