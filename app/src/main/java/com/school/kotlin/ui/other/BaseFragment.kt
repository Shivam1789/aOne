package com.school.kotlin.ui.other


import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.text.Html
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.school.kotlin.R
import com.school.kotlin.application.GlideApp
import com.school.kotlin.callBack.OptionSelected
import com.school.kotlin.utils.Constants
import com.school.kotlin.utils.Utils
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by android on 2/11/17.
 * *
 */
open class BaseFragment : Fragment() {
    protected val TAG = javaClass.simpleName
    var mContent: View?=null// For showing snackbar
    private var mActivity: FragmentActivity? = null
    private var alertDialog: AlertDialog? = null
    private var mProgressDialog: Dialog? = null
    private val PERMISSION_REQUEST = 121


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = activity

    }

    fun showLoading(show: Boolean?) {
        show?.let {
            if (it) showProgress() else hideProgress()
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mContent = view
    }

    fun showSnackBar(message: String?) {
        mContent?.let {
            val snackbar = message?.let { it1 -> Snackbar.make(it, it1, Snackbar.LENGTH_LONG) }
            val snackbarView = snackbar?.view
            val tv = snackbarView?.findViewById<TextView>(android.support.design.R.id.snackbar_text)
            tv?.maxLines = 3
            snackbar?.duration = Constants.SNACK_BAR_DURATION
            snackbar?.show()
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
        val fragmentManager = mActivity?.supportFragmentManager
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
                    ?.commitAllowingStateLoss()
        }
    }

    fun getFormatedTimeFromUtc(dateString: String?, dateFormat: String?): String? {
        val FORMAT = "yyyy-MM-dd HH:mm:ss"
        val format = SimpleDateFormat(FORMAT, Locale.US)

        val formatedDateString: String
        try {
            val utcZone = TimeZone.getTimeZone("UTC")
            format.timeZone = utcZone// Set UTC time zone
            val date = format.parse(dateString)
            val timeFormat = SimpleDateFormat(dateFormat, Locale.US)
            timeFormat.timeZone = TimeZone.getDefault()// Set device time zone
            formatedDateString = timeFormat.format(date)
        } catch (e: ParseException) {
            Log.e("exp", e.localizedMessage)
            return dateString
        } catch (e: NullPointerException) {
            Log.e("exp", e.localizedMessage)
            return dateString
        }

        return formatedDateString
    }

    fun replaceFragment(fragment: Fragment, animate: Boolean) {
        val tag: String = fragment::class.java.simpleName

        val transaction = activity?.supportFragmentManager?.beginTransaction()
        if (animate) {
            transaction?.setCustomAnimations(R.anim.anim_in, R.anim.anim_out, R.anim.anim_in_reverse, R.anim.anim_out_reverse)

        }
        transaction?.replace(R.id.container, fragment, tag)
                ?.commitAllowingStateLoss()
    }

    protected fun setProfileImage(imagePath: String?, imageView_profile: ImageView, progressBar: ProgressBar?) {
        GlideApp.with(mActivity)
                .load(imagePath)
                .placeholder(R.drawable.ic_add_camera)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .centerCrop()
                .into(imageView_profile)
    }

    protected fun goBack() {
        activity.onBackPressed()
    }

    /**
     * show progress view
     */
    fun showProgress() {
        try {
            activity?.let {

                if (mProgressDialog == null) {
                    mProgressDialog = Dialog(it, android.R.style.Theme_Translucent)
                    mProgressDialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
                    mProgressDialog?.setContentView(R.layout.loader__layout)
                    mProgressDialog?.setCancelable(false)
                }
                mProgressDialog?.show()
            }

        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }

    }

    /**
     * hide progress view
     */
    fun hideProgress() {
        try {
            if (mProgressDialog?.isShowing == true) {
                mProgressDialog?.dismiss()
            }
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }

    }

    fun showMessage(message: String) {
        Utils.showSnackbar(mContent, message)
    }

    /**
     * show alert dialog box
     * @param title   title needs to be shown on the Alert
     * @param message message needs to be shown on the alert
     * @param inconId Icon for the dialog
     */
    protected fun showAlertDialogBox(title: String, message: String, inconId: Int, onClickListener: View.OnClickListener) {
        if (alertDialog == null) {
            alertDialog = AlertDialog.Builder(mActivity).setTitle(title)
                    .setCancelable(false)
                    .setPositiveButton(android.R.string.ok, null)
                    .setIcon(inconId)
                    .create()
        }
        alertDialog?.setTitle(title)
        alertDialog?.setMessage(message)
        alertDialog?.show()
        val button = alertDialog?.getButton(AlertDialog.BUTTON_POSITIVE)
        button?.setOnClickListener(onClickListener)
    }


    fun showOptionDialog(title: String, itemList: ArrayList<String>, optionSelected: OptionSelected) {

        // setup the alert builder
        val builder = AlertDialog.Builder(activity)
        builder.setTitle(Html.fromHtml("<b>$title</b>"))// bold style of  title of dialog


        var listData = arrayOfNulls<String>(itemList.size)
        listData = itemList.toTypedArray<String?>()
        // add a list
        builder.setItems(listData) { dialog, which -> optionSelected.selectedItem(itemList[which]) }

        // create and show the alert dialog
        val dialog = builder.create()
        dialog.show()
    }

    /**
     * dismiss alert dialog box
     */
    protected fun dismissAlertDialog() {
        if (alertDialog != null && alertDialog!!.isShowing()) {
            alertDialog?.dismiss()
        }
    }

}