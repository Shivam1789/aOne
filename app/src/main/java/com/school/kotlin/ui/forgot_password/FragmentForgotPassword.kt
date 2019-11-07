package com.school.kotlin.ui.forgot_password

import Preferences
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.school.kotlin.R
import com.school.kotlin.data.ForgotPassword.ForgotPasswordRequest
import com.school.kotlin.ui.other.BaseFragment
import com.school.kotlin.ui.otp.FragmentOtp
import com.school.kotlin.utils.Constants
import com.school.kotlin.utils.Utils
import com.school.kotlin.utils.security.ApiFailureTypes
import com.school.kotlin.utils.setValue
import kotlinx.android.synthetic.main.forgot_password.*

/**
 * Created by shivam on 15/6/18.
 * class for ForgotPassword
 */
class FragmentForgotPassword : BaseFragment(), View.OnClickListener {
    private var mViewModel: ForgotPasswordModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //reference for ForgotPasswordModel
        mViewModel = ViewModelProviders.of(this).get(ForgotPasswordModel::class.java)
        attachObservers()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.forgot_password, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setListener()
    }

    private fun init() {

    }

    /**
     * this method will attach observer to the model, if any change occur
     * it will be observed and reflected on ui
     */
    private fun attachObservers() {
        //if hit is successful it will observe response
        mViewModel?.response?.observe(this, Observer {
            it?.let {
                val message = "${it.message}"
                showSnackBar(message)
                Preferences.prefs?.setValue(Constants.MOBILE_NUMBER, edit_text_phone_forgot.text.toString().trim())
                Preferences.prefs?.setValue(Constants.COUNTRY_CODE, code_picker.selectedCountryCode)
                val bundle = Bundle()
                bundle.putBoolean(Constants.FROM_FORGOT, true)
                val fragmentOtp = FragmentOtp()
                fragmentOtp.arguments = bundle
                Utils.showCustomSnackbar(mContent, "Otp send successfully" + ".Your Otp Code is ${it.otp}.")
                addFragment(fragmentOtp, true)
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

    private fun authenticate() {
        val phoneNumber = edit_text_phone_forgot.text.toString().trim()
        when {
            phoneNumber.isEmpty() -> {
                Utils.hideKeyboard(activity)
                showSnackBar(getString(R.string.forgot_phone_empty))
                return
            }
            phoneNumber.length !in 16 downTo 6 -> {
                Utils.hideKeyboard(activity)
                showSnackBar(getString(R.string.signUp_phone_length))
                return
            }
            else -> {
                if (Utils.isNetworkAvailable(mContent)) {
                    val forgotPasswordRequest = ForgotPasswordRequest()
                    forgotPasswordRequest.mobile = edit_text_phone_forgot.text.toString().trim()
                    forgotPasswordRequest.countryCode = code_picker.selectedCountryCode
                    mViewModel?.forgotPassword(forgotPasswordRequest)
                } else {
                    Utils.hideKeyboard(activity)
                }
            }
        }
    }

    private fun setListener() {
        button_forword_submit.setOnClickListener(this)
        image_back_forword.setOnClickListener(this)
    }

    /**
     * It will handle all click events
     */
    override fun onClick(v: View?) {
        when (v?.id) {
        //hit api on button click
            R.id.button_forword_submit -> {
                authenticate()
            }
            R.id.image_back_forword -> {
                goBack()
            }
        }
    }
}