package com.school.kotlin.utils

import android.content.Context
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.school.kotlin.R
import com.school.kotlin.application.GlideApp


fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}


fun ImageView.loadImg(url: String, activity: Context) {
    GlideApp.with(activity)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .thumbnail(0.1f)
            .placeholder(R.drawable.ic_add_camera)
            .dontAnimate()
            .into(this)
}


fun AlertDialog.Builder.positiveButton(name: String = "Okay", clickListener: (which: Int) -> Any = {}) {
    this.setPositiveButton(name,
            { _, which -> clickListener(which) })
}

fun AlertDialog.Builder.negativeButton(name: String = "Cancel", clickListener: (which: Int) -> Any = {}) {
    this.setNegativeButton(name,
            { _, which -> clickListener(which) })
}


fun Any.error(message: String) {
    Log.e(this::class.java.simpleName, message)
}