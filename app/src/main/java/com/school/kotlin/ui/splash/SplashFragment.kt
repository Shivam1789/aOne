package com.school.kotlin.ui.splash


import Preferences
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.school.kotlin.R
import com.school.kotlin.activities.nevigational.NevigationalActivity
import com.school.kotlin.ui.other.BaseFragment
import com.school.kotlin.ui.otp.FragmentOtp
import com.school.kotlin.utils.Constants
import com.school.kotlin.utils.getValue


/**
 * A simple [Fragment] subclass.
 */
class SplashFragment : BaseFragment() {
    private var mDialog: Dialog? = null
    private val mHandler = Handler()
    private val mRunnable = Runnable {
        if (isAdded) {
            proceed()
        }
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater?.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showProgressDialog()
    }

    /**
     * Show progress dialog
     */
    private fun showProgressDialog() {
        if (mDialog == null) {
            mDialog = Dialog(activity, android.R.style.Theme_Translucent)
            mDialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
            mDialog?.setContentView(R.layout.loader_half_layout)
            mDialog?.setCancelable(false)
        }
        mDialog?.show()
    }

    /**
     * This method will navigate the user to different screen on basis of condition
     */
    private fun proceed() {
        val pref = Preferences.prefs
        val tutorialStatus = pref?.getValue(Constants.IS_TUTORIAL_SEEN, false)
        val enableLocationStatus = pref?.getValue(Constants.IS_ENABLE_LOCATION, false)

        if (tutorialStatus != null && !tutorialStatus) {
            replaceFragment(FragmentOtp(), true)
        } else if (enableLocationStatus != null && !enableLocationStatus) {

        } else {
            val intent = Intent(activity, NevigationalActivity::class.java)
            startActivity(intent)
            activity?.finish()
            activity?.overridePendingTransition(R.anim.anim_in, R.anim.anim_out)
        }
        hideProgressDialog()
    }

    /**
     * Hide progress dialog
     */
    private fun hideProgressDialog() {
        if (mDialog != null && mDialog?.isShowing!!) {
            mDialog?.dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        mHandler.postDelayed(mRunnable, Constants.SPLASH_TIME_OUT)
    }

    override fun onStop() {
        super.onStop()
        mHandler.removeCallbacks(mRunnable)
    }
}
