package com.school.kotlin.ui.otp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.school.kotlin.R
import com.school.kotlin.activities.navigational.NavigationalActivity
import com.school.kotlin.ui.other.BaseFragment
import kotlinx.android.synthetic.main.fragment_otp.*

class FragmentOtp : BaseFragment(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_otp, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()

    }


    private fun init() {
        txt_resend.setOnClickListener {
            val intent = Intent(activity, NavigationalActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onClick(p0: View?) {
    }
}