package com.school.kotlin.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.school.kotlin.R
import com.school.kotlin.activities.navigational.NavigationalActivity
import com.school.kotlin.ui.forgot_password.FragmentForgot
import com.school.kotlin.ui.other.BaseFragment
import com.school.kotlin.ui.select_class.FragmentSelectClass
import com.school.kotlin.ui.signUp.FragmentSignUp
import kotlinx.android.synthetic.main.fragment_scl_login.*

class FragmentLogin : BaseFragment(), View.OnClickListener {
    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_SignIn ->{
                val intent = Intent(activity, NavigationalActivity::class.java)
                startActivity(intent)
            }
            R.id.txt_register ->
                addFragment(FragmentSelectClass(), true)
            R.id.txt_forgot_password ->
                addFragment(FragmentForgot(), true)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_scl_login, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_SignIn.setOnClickListener(this)
        txt_register.setOnClickListener(this)
        txt_forgot_password.setOnClickListener(this)
    }
}