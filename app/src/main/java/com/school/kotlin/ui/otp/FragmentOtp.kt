package com.school.kotlin.ui.otp

import Preferences
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.school.kotlin.R
import com.school.kotlin.activities.nevigational.NevigationalActivity
import com.school.kotlin.data.otp.OtpRequest
import com.school.kotlin.data.resendOtp.ResendOtpRequest
import com.school.kotlin.ui.other.BaseFragment
import com.school.kotlin.ui.reset_password.FragmentResetPassword
import com.school.kotlin.utils.Constants
import com.school.kotlin.utils.Utils
import com.school.kotlin.utils.security.ApiFailureTypes
import com.school.kotlin.utils.setValue
import kotlinx.android.synthetic.main.fragment_otp.*
import org.greenrobot.eventbus.EventBus

class FragmentOtp : BaseFragment(), View.OnClickListener {
    private var mCountDownTimer: CountDownTimer? = null
    private var mIsTimerEnable: Boolean = false
    private var mViewModel: OtpModel? = null
    private var mFromForgotPassword: Boolean = false
    private var mPhone: String? = null
    private var mCode: String? = null
    private var mOldNumber: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(OtpModel::class.java)
        attachObservers()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_otp, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        textWatcherListener()
        setListener()
    }


    /* get data from bundle*/
    private fun init() {
        mOldNumber = Preferences.prefs?.getString(Constants.MOBILE_NUMBER, "")
        arguments?.let {
            mFromForgotPassword = it.getBoolean(Constants.FROM_FORGOT, false)
            mPhone = it.getString(Constants.PHONE)
            mCode = it.getString(Constants.CODE)
        }

        /* when it comes from edit profile then new number is set and if it comes from forgot
        * or registration then existing number is set for otp verification*/
        if(mPhone!=null) {
            text_mobile.text=mPhone
        }
        else {
            text_mobile.text=mOldNumber
        }
    }

    /**
     * This method will close the keyboard when user fills the otp
     */
    private fun textWatcherListener() {
        pin_view_otp.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (p0?.length == 6) {
                    Utils.hideKeyboard(activity)
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }


    private fun attachObservers() {
        mViewModel?.response?.observe(this, Observer {
            it?.let {
                if (arguments != null) {
                    /* when come from editprofile*/
                    if (mFromForgotPassword) {
                        addFragment(FragmentResetPassword(), true)
                    } else {
                        /* call method of edit profile fragment to change the verification*/
                        Handler().postDelayed({
                            EventBus.getDefault().post("success")//* hit api and get Plans*//*
                        }, 300)

                        /* WHEN USER NOT UPDATE PROFILE AND ONLY
                        * VERIFY THE NUMBER THEN WE ARE SAVING THE NEW VALUE LOCALLY
                        * BECAUSE WE  SAVE THE PROFILE ONLY UPDATE PROFILE,LOGIN AND REGISTRATION OTP VERIFICATION*/
                        Preferences.prefs?.setValue(Constants.MOBILE_NUMBER, mPhone)
                        goBack()
                        hideProgress()
                    }
                } else {
                    /* when user comes from registration then user profile are saved in preference*/
                    val gson = Gson()
                    val loginResponses = gson.toJson(it)
                    Preferences.prefs?.setValue(Constants.SAVEPROFILE, loginResponses)
                    Preferences.prefs?.setValue(Constants.IS_LOGGED_IN, true)
                    val intent = Intent(activity, NevigationalActivity::class.java)
                    startActivity(intent)
                    activity.overridePendingTransition(R.anim.anim_in, R.anim.anim_out)
                    EventBus.getDefault().post("home")
                    Preferences.prefs?.setValue(Constants.TOKEN, it.data?.accesstoken)
                    Preferences.prefs?.setValue(Constants.ID, it.data?.id)
                }

            }
        })

        mViewModel?.apiError?.observe(this, Observer {
            it?.let {
                showSnackBar(it)
            }
        })

        mViewModel?.isLoading?.observe(this, Observer {
            it?.let { showLoading(it) }

        })
        mViewModel?.onFailure?.observe(this, android.arch.lifecycle.Observer {
            it?.let {
                showSnackBar(ApiFailureTypes().getFailureMessage(it))
            }
        })
        mViewModel?.responseResendOtp?.observe(this, Observer {
            it?.let {
                val message = "${it.message}"
                if (!mIsTimerEnable) {
                    countTimer()
                }
                Utils.showCustomSnackbar(mContent, "Otp send successfully " + ".Your Otp Code is ${it.otp}.")

            }
        })
    }

    /**
     * This method will start timer when we resend otp and disable resend otp buttom
     */
    private fun countTimer() {

        if (!mIsTimerEnable) {
            mCountDownTimer = object : CountDownTimer(40000, 1000) {

                override fun onTick(millisUntilFinished: Long) {
                    mIsTimerEnable = true
                    image_resend?.isClickable = false
                    textViewResend?.isClickable=false
                    text_count_timer?.visibility = View.VISIBLE
                    val time = "${millisUntilFinished / 60000}0:${millisUntilFinished % 60000 / 1000}"
                    text_count_timer?.text = time
                }

                override fun onFinish() {
                    mIsTimerEnable = false
                    text_count_timer?.visibility = View.INVISIBLE
                    image_resend?.isClickable = true
                    textViewResend?.isClickable=true
                    mCountDownTimer?.cancel() /* this is used for stop timing and done all
                                                 fun in on finish method*/
                }

            }.start()
        }
    }

    /* finish the timer*/
    override fun onStop() {
        mCountDownTimer?.onFinish()
        super.onStop()
    }

    /* set click event on all view*/
    private fun setListener() {
        button_verify_otp.setOnClickListener(this)
        image_resend.setOnClickListener(this)
        image_back_otp.setOnClickListener(this)
        textViewResend.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.image_resend, R.id.textViewResend -> {
                if (Utils.isNetworkAvailable(mContent)) {
                    val resendOtpRequest = ResendOtpRequest()
                    val mobileNo = Preferences.prefs?.getString(Constants.MOBILE_NUMBER, "")
                    val countryCode = Preferences.prefs?.getString(Constants.COUNTRY_CODE, "")
                    if (mPhone != null) {
                        /* when user comes from  edit profile then type is 3*/
                        resendOtpRequest.type = "3"
                        resendOtpRequest.countryCode = mCode
                        resendOtpRequest.mobile = mPhone
                    } else {
                        /* In this if User comes from forgot screen then type is 1 else 0*/
                        resendOtpRequest.mobile = mobileNo
                        resendOtpRequest.type = if (mFromForgotPassword) "1" else "0"
                        resendOtpRequest.countryCode = countryCode
                    }
                }
            }
            R.id.button_verify_otp -> {
                if (pin_view_otp.text.isNotEmpty()) {
                    if (com.school.kotlin.utils.Utils.isNetworkAvailable(mContent)) {
                        val countryCode = Preferences.prefs?.getString(Constants.COUNTRY_CODE, "")
                        val mobileNo = Preferences.prefs?.getString(Constants.MOBILE_NUMBER, "")
                        val otpRequest = OtpRequest()
                        otpRequest.otp = pin_view_otp.text.toString()
                        otpRequest.mobile = mobileNo
                        if (arguments != null) {

                            /* when user comes from forgot password screen then type is 1
                            * and if user comes from edit profile screen then type is 0*/
                            if (mFromForgotPassword) {
                                otpRequest.type = "1"//for forgot password
                                otpRequest.countryCode = countryCode
                            } else {
                                otpRequest.mobile = mOldNumber
                                otpRequest.newPhoneNumber = mPhone
                                otpRequest.countryCode = mCode
                                otpRequest.type = "3"//for verify number in edit profile
                            }
                        } else {
                            otpRequest.type = "0"//for registrations
                        }
                        mViewModel?.putOtp(otpRequest)
                    }
                } else {
                    Utils.hideKeyboard(activity)
                    showSnackBar(getString(R.string.otp_empty))
                }
            }
            /* back pressed when click on back images*/
            R.id.image_back_otp -> {
                goBack()
            }
        }
    }
}