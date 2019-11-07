package com.school.kotlin.ui.login

import Preferences
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.besttyme.kotlin.ui.signUp.LoginModel
import com.google.gson.Gson
import com.school.kotlin.R
import com.school.kotlin.activities.nevigational.NevigationalActivity
import com.school.kotlin.data.Login.LoginRequest
import com.school.kotlin.ui.forgot_password.FragmentForgotPassword
import com.school.kotlin.ui.other.BaseFragment
import com.school.kotlin.utils.Constants
import com.school.kotlin.utils.Utils
import com.school.kotlin.utils.getValue
import com.school.kotlin.utils.security.ApiFailureTypes
import com.school.kotlin.utils.setValue
import kotlinx.android.synthetic.main.fragment_scl_login.*
import org.greenrobot.eventbus.EventBus

/**
 * Created by shivam on 15/6/18.
 * login fragment
 */
class FragmentLogin : BaseFragment(), View.OnClickListener {
    private var mViewModel: LoginModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //reference of login model
        mViewModel = ViewModelProviders.of(this).get(LoginModel::class.java)
        attachObservers()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_scl_login, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setListener()
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
    }

    /**
     * ALl initialization will be done in this method
     */
    private fun init() {
        val phone = Preferences.prefs?.getValue(Constants.PHONE_NUMBER, "")
        edit_text_phone.setText(phone)
        val isChecked = Preferences.prefs?.getValue(Constants.CHECKED_UNCHECKED, false)
        isChecked?.let {
            check_box.isChecked = it
        }


    }

    /**
     *Attach observer to model, if any change occur will be observed here and response is updated on ui
     */
    private fun attachObservers() {
        mViewModel?.response?.observe(this, Observer {
            it?.let {
                val token = it.data?.accesstoken
                val id = it.data?.id
                val gson = Gson()
                val loginResponses = gson.toJson(it)
                Preferences.prefs?.setValue(Constants.SAVEPROFILE, loginResponses)
                Preferences.prefs?.setValue(Constants.IS_LOGGED_IN, true)
                Preferences.prefs?.setValue(Constants.MOBILE_NUMBER, it.data?.mobile)
                Preferences.prefs?.setValue(Constants.TOKEN, token)
                Preferences.prefs?.setValue(Constants.ID, id)
                val idD=   Preferences.prefs?.getValue(Constants.ID, "")
                val tokenId =  Preferences.prefs?.getValue(Constants.TOKEN, "")
                Log.e("token + id",idD+tokenId)
                val message = "${it.message}"
                showSnackBar(message)
                val intent = Intent(activity, NevigationalActivity::class.java)
                startActivity(intent)
                activity.overridePendingTransition(R.anim.anim_in, R.anim.anim_out)
                EventBus.getDefault().post("home")
            }
        })
        //If any api error will occur this will be observed
        mViewModel?.apiError?.observe(this, Observer {
            it?.let {
                showSnackBar(it)
            }
        })
        //this will observe the loader
        mViewModel?.isLoading?.observe(this, Observer {
            it?.let { showLoading(it) }

        })
        //this will show message if any failure will occur
        mViewModel?.onFailure?.observe(this, android.arch.lifecycle.Observer {
            it?.let {
                showSnackBar(ApiFailureTypes().getFailureMessage(it))
            }
        })

    }


    private fun setListener() {
        text_forgotPassword.setOnClickListener(this)
        button_sign_in.setOnClickListener(this)
        image_back_login.setOnClickListener(this)
    }

    /**
     * All the click events will be handled here
     */
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.text_forgotPassword -> {
                Utils.hideKeyboard(activity)
                addFragment(FragmentForgotPassword(), true)
            }
            R.id.button_sign_in -> {
                authenticate()
            }
            R.id.image_back_login -> {
                goBack()
            }
        }
    }

    /**
     * This method will authenticate the field before hiting login api
     */
    private fun authenticate() {
        val phone = edit_text_phone.text.toString().trim()
        val password = edit_text_password.text.toString().trim()
        when {
            phone.isEmpty() -> {
                showSnackBar(getString(R.string.login_phone_empty))
                return
            }
            phone.length !in 16 downTo 6 -> {
                showSnackBar(getString(R.string.signUp_phone_length))
                return
            }
            password.isEmpty() -> {
                showSnackBar(getString(R.string.login_password_empty))
                return
            }
            else -> {
                if (Utils.isNetworkAvailable(mContent)) {
                    if (Utils.singleClick()) {
                        val loginRequest = LoginRequest()
                        loginRequest.mobile = phone
                        loginRequest.password = password
                        mViewModel?.loginData(loginRequest)

                    }
                    if (check_box.isChecked) {
                        Preferences.prefs?.setValue(Constants.PHONE_NUMBER, phone)
                        Preferences.prefs?.setValue(Constants.CHECKED_UNCHECKED, true)
                    } else {
                        Preferences.prefs?.setValue(Constants.CHECKED_UNCHECKED, false)
                    }

                } else {
                    activity?.let { Utils.hideKeyboard(it) }
                }
            }

        }
    }
    override fun onDestroyView() {
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
        super.onDestroyView()
    }

}