package com.school.kotlin.activities


import android.os.Bundle
import android.os.Handler
import com.school.kotlin.R
import com.school.kotlin.ui.splash.SplashFragment
import com.school.kotlin.utils.Utils


class LauncherActivity : BaseActivity() {

    private var mDoubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        init()
    }

    private fun init() {

        replaceFragment(SplashFragment())
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else if (!mDoubleBackToExitPressedOnce) {
            this.mDoubleBackToExitPressedOnce = true
            Utils.showToast(this, resources.getString(R.string.home_back_button))
            Handler().postDelayed({ mDoubleBackToExitPressedOnce = false }, 2000)
        } else {
            super.onBackPressed()
            return
        }
    }
}
