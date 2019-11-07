package com.school.kotlin.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.school.kotlin.R

/**
 * Created by android on 8/11/17.
 * Base activity for all activities
 */
@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    protected val TAG: String = javaClass.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // pass activity's  result to the fragments
        val fragment = supportFragmentManager.findFragmentById(R.id.container)
        fragment?.onActivityResult(requestCode, resultCode, data)
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val fragment = supportFragmentManager.findFragmentById(R.id.container)
        fragment?.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


    /**
     * replace fragment without animation and backstack *****************
     * @param fragment
     */
    protected fun replaceFragment(fragment: Fragment) {
        val tag = fragment.tag
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment, tag)
                .commitAllowingStateLoss()
    }


    fun showSnackBar(message: String, content: View) {
        this.let {
            Snackbar.make(content, message, Snackbar.LENGTH_LONG).show()
        }
    }

    /**
     * Add fragment with or without addToBackStack
     *
     * @param fragment       which needs to be attached
     * @param addToBackStack is fragment needed to backstack
     */
    fun addFragment(fragment: Fragment, addToBackStack: Boolean) {
        val tag = fragment.javaClass.simpleName
        val fragmentManager = supportFragmentManager
        val fragmentOldObject = fragmentManager?.findFragmentByTag(tag)
        val transaction = fragmentManager?.beginTransaction()
        transaction?.setCustomAnimations(R.anim.anim_in, R.anim.anim_out, R.anim.anim_in_reverse, R.anim.anim_out_reverse)
        if (fragmentOldObject != null) {
            fragmentManager.popBackStackImmediate(tag, 0)
        } else {
            if (addToBackStack) {
                transaction?.addToBackStack(tag)
            }
            transaction?.add(R.id.container, fragment, tag)
                    ?.commit()
        }
    }
}