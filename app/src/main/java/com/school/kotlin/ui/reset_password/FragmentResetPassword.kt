package com.school.kotlin.ui.reset_password

import Preferences
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.school.kotlin.R
import com.school.kotlin.data.ResetPassword.ResetPasswordRequest
import com.school.kotlin.ui.login.FragmentLogin
import com.school.kotlin.ui.other.BaseFragment
import com.school.kotlin.utils.Constants
import com.school.kotlin.utils.Utils
import com.school.kotlin.utils.security.ApiFailureTypes
import kotlinx.android.synthetic.main.fragment_reset_password.*

/**
 * Created by shivam on 16/6/18.
 * class for FragmentResetPassword
 */
class FragmentResetPassword : BaseFragment(), View.OnClickListener {
    private var mViewModel: ResetPasswordModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //reference for ResetPasswordModel
        mViewModel = ViewModelProviders.of(this).get(ResetPasswordModel::class.java)
        attachObservers()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_reset_password, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setListener()
    }

    private fun init() {

    }

    private fun setListener() {
        button_reset_password.setOnClickListener(this)
        image_back_reset.setOnClickListener(this)
    }

    private fun authenticate() {
        val newPassword = edit_text_new_password.text.toString().trim()
        val confirmPassword = edit_text_confirm_password.text.toString().trim()

        when {
            newPassword.isEmpty() -> {
                Utils.hideKeyboard(activity)
                showSnackBar(getString(R.string.reset_newPassword_empty))
                return
            }
            newPassword.length !in 17 downTo 8 -> {
                Utils.hideKeyboard(activity)
                showSnackBar(getString(R.string.signUp_password_length))
                return
            }
            !Utils.isPasswordValid(newPassword) -> {
                Utils.hideKeyboard(activity)
                showSnackBar(getString(R.string.signUp_password_length))
                return
            }
            confirmPassword.isEmpty() -> {
                Utils.hideKeyboard(activity)
                showSnackBar(getString(R.string.reset_confirm_password_empty))
                return
            }
            confirmPassword != newPassword -> {
                Utils.hideKeyboard(activity)
                showSnackBar(getString(R.string.pass_not_matched))
                return
            }
            else -> {
                if (Utils.isNetworkAvailable(mContent)) {
                    val mobileNo = Preferences.prefs?.getString(Constants.MOBILE_NUMBER, "")
                    val resetPasswordRequest = ResetPasswordRequest()
                    resetPasswordRequest.password = newPassword
                    resetPasswordRequest.mobile = mobileNo
                    mViewModel?.resetPassword(resetPasswordRequest)
                } else {
                    Utils.hideKeyboard(activity)
                }
            }
        }
    }

    /**
     * this method will attach observer to the model, if any change occur
     * it will be observed and reflected on ui
     */
    private fun attachObservers() {
        //if hit is successful it will observe response
        mViewModel?.response?.observe(this, Observer {
            it?.let {
                val message = "${it.data}"
                showSnackBar(message)
                activity?.supportFragmentManager?.popBackStack(FragmentLogin().id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        })

        //if any error on api level is occur, it will observe here
        mViewModel?.apiError?.observe(this, Observer {
            it?.let {
                showSnackBar(it)
            }
        })

        //this will observe loader
        mViewModel?.isLoading?.observe(this, Observer {
            it?.let { showLoading(it) }

        })

        //if any failure occur it will be observed here
        mViewModel?.onFailure?.observe(this, android.arch.lifecycle.Observer {
            it?.let {
                showSnackBar(ApiFailureTypes().getFailureMessage(it))
            }
        })

    }

    /**
     * It will handle all click events
     */
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_reset_password -> {
                authenticate()
            }
            R.id.image_back_reset -> {
                goBack()

            }
        }

    }

}