package com.school.kotlin.application

import Preferences
import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho

/**
 * Created by android on 3/11/17.
 */
class BaseProject : Application() {

    var mContext: Context? = null




    companion object AppContext {
        lateinit var instance: BaseProject
        public fun getContext():Context
        {
            return  instance
        }
    }

    init {
        instance = this
    }


    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        Preferences.initPreferences(this)
        mContext = applicationContext
    }
}
