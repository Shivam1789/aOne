package com.school.kotlin.utils

import Preferences
import android.Manifest
import android.annotation.TargetApi
import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.os.SystemClock
import android.preference.PreferenceManager
import android.provider.MediaStore
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.content.ContextCompat
import android.util.Log
import android.util.Patterns
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import com.school.kotlin.R
import com.school.kotlin.activities.navigational.NavigationalActivity
import com.school.kotlin.utils.Constants.PERMISSION_READ_EXTERNAL_STORAGE
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern


/**
 * Created by android on 2/11/17.
 * *
 */
object Utils {

    val FILE_NAME = "BaseProject"

    private var mLastClickTime = 0L


    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun hideKeyboard(ctx: Context) {
        val inputManager = ctx.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val v = (ctx as Activity).currentFocus ?: return
        inputManager.hideSoftInputFromWindow(v.windowToken, 0)
    }


    fun defaultPrefs(context: Context): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun customPrefs(context: Context): SharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

    /**
     * Show toast.
     *
     * @param toast String value which needs to shown in the toast.
     * @description if you want to print a toast just call this method and pass
     * what you want to be shown.
     */
    @Synchronized
    fun showSnackbar(content: View?, toast: String): Snackbar {
        val snackbar: Snackbar
        snackbar = Snackbar.make(content!!, toast, Snackbar.LENGTH_LONG)
        snackbar.show()
        return snackbar
    }

    /* custom snackbar with button*/
    @Synchronized
    fun showCustomSnackbar(content: View?, toast: String): Snackbar {
        val snackbar: Snackbar = Snackbar.make(content!!, toast,Snackbar.LENGTH_INDEFINITE)

        snackbar.setAction("Dismiss", {

            snackbar.dismiss() })
        snackbar.show()
        return snackbar
    }

    fun logout(context: Context) {
        val phone = Preferences.prefs?.getValue(Constants.PHONE_NUMBER, "")
        val isChecked = Preferences.prefs?.getValue(Constants.CHECKED_UNCHECKED, false)
        Log.e("phoneLogout",phone)

        //clear shared preference

        val pref = Preferences.prefs
        pref?.clearPref()
        val token = Preferences.prefs?.getValue(Constants.TOKEN, "")
        val id = Preferences.prefs?.getValue(Constants.ID, "")
        Log.e("isTokenLogout",token+id)
        pref?.setValue(Constants.IS_TUTORIAL_SEEN, true)
        pref?.setValue(Constants.IS_ENABLE_LOCATION, true)
       isChecked?.let {
           if(it)
           {
               pref?.setValue(Constants.CHECKED_UNCHECKED,it)
               Log.e("isCheckedLogout",it.toString())
               pref?.setValue(Constants.PHONE_NUMBER,phone)
           }
       }
        val intent = Intent(context, NavigationalActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        context.startActivity(intent)
        if (context is Activity) {
            val activity = context
            activity.finish()
            activity.overridePendingTransition(R.anim.anim_in, R.anim.anim_out)
        }
    }

    /**
     * Is email valid.
     *
     * @param email Pass a email in string format and this method check if it is
     * a valid address or not.
     * @return True if email is valid otherwise false.
     */
    fun isEmailValid(email: String): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }


    /**
     * Is online.
     *
     * @return True, if device is having a Internet connection available.
     */
    fun isNetworkAvailable(content: View?): Boolean {
        val cm = content?.context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        if (netInfo != null && netInfo.isConnectedOrConnecting) {
            return true
        } else {
            content?.context?.getString(R.string.no_internet_message)?.let { showSnackbar(content, it) }
        }
        return false
    }

    fun singleClick(): Boolean {
        val minInterval = 400L
        val currentClickTime = SystemClock.uptimeMillis()
        val elapsedTime = currentClickTime - mLastClickTime
        mLastClickTime = currentClickTime

        return elapsedTime >= minInterval
    }

    fun isPasswordValid(password: String): Boolean {
        val pattern: Pattern
        val matcher: Matcher

        val PASSWORD_PATTERN = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[$@$!%*?&])[a-zA-Z\\d$@$!%*?&]{6,}"
        pattern = Pattern.compile(PASSWORD_PATTERN)
        matcher = pattern.matcher(password)

        return matcher.matches()
    }

    @Synchronized
    fun getDOB(context: Context, textView: TextView) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        // put calendar back to 18 years
        c.add(Calendar.YEAR, -18)
        val datePickerDialog = DatePickerDialog(context, R.style.DialogTheme, DatePickerDialog.OnDateSetListener { _, year, month, day ->
            val date = year.toString() + "-" + month + "-" + day
            textView.text = formatDate(date)
        }, year, month, day)
        datePickerDialog.datePicker.maxDate = c.timeInMillis
        datePickerDialog.show()
    }


    fun formatDate(dateStr: String?): String? {
        if (dateStr == null) return null
        var date = "Format Exception"
        val currentFormat = SimpleDateFormat("yyyy-mm-dd", Locale.getDefault())
        val requiredFormat = SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault())
        try {
            val getDate = currentFormat.parse(dateStr)
            date = requiredFormat.format(getDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return date
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    fun checkPermission(context: Fragment): Boolean {
        val currentAPIVersion = Build.VERSION.SDK_INT
        if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context.context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                context.requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), PERMISSION_READ_EXTERNAL_STORAGE)
                return false
            }
        }
        return true
    }

    fun isPermissionDeniedPermanently(fragment: Fragment, permission: String): Boolean {
        return fragment.shouldShowRequestPermissionRationale(permission)
    }


    /*
    *  Getting the real path of image through camera
    * */
    @Synchronized
    fun getOriginalImagePath(fragmentActivity: FragmentActivity): String {
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = fragmentActivity.contentResolver.query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                projection, null, null, null)
        val column_index_data = cursor!!
                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor.moveToLast()

        return cursor.getString(column_index_data)
    }

    fun getPathFromURI(context: Context, uri: Uri?): String {
        if (uri == null) {
            throw NullPointerException("Uri must not be null")
        }
        val path: String
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = context.contentResolver.query(uri, projection, null, null, null)
        if (cursor != null) {
            val column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            cursor.moveToFirst()
            path = cursor.getString(column_index)
            cursor.close()
            return path
        }
        return uri.path
    }


}