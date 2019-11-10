package com.school.kotlin.ui.signUp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.school.kotlin.R
import com.school.kotlin.activities.navigational.NavigationalActivity
import com.school.kotlin.ui.other.BaseFragment
import com.school.kotlin.ui.otp.FragmentOtp
import kotlinx.android.synthetic.main.fragment_sign_up.*

class FragmentSignUp : BaseFragment(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()

    }


    private fun init() {
        btn_SignIn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_SignIn -> {
                addFragment(FragmentOtp(),true)
            }

        }

    }
}