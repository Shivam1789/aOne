package com.school.kotlin.activities


import android.os.Bundle
import com.school.kotlin.R

import com.school.kotlin.utils.Constants

class DashboardNavigation : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val type = intent.extras.getInt(Constants.FRAGMENT_TYPE)
        val bundle = Bundle()

    }

    override fun onBackPressed() {
        super.onBackPressed()

//        val fragment = supportFragmentManager.findFragmentById(R.id.container)
//        if (fragment is FragmentResetPassword) {
//            super.onBackPressed()
//            super.onBackPressed()
//        } else {
//            super.onBackPressed()
//        }
        overridePendingTransition(R.anim.anim_in_reverse, R.anim.anim_out_reverse)
    }
}
