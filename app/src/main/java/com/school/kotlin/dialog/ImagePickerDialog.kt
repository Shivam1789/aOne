package com.school.kotlin.dialog

import android.app.Dialog
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.TextView
import com.school.kotlin.R
import com.school.kotlin.utils.Constants.REQUEST_CAMERA
import com.school.kotlin.utils.Constants.REQUEST_GALLERY

/**
 * Created by android on 8/11/17.
 */
class ImagePickerDialog : DialogFragment(), View.OnClickListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val inflator = activity.layoutInflater
        val view = inflator.inflate(R.layout.fragment_image_picker, null)
        builder.setView(view)
        view.findViewById<TextView>(R.id.txt_take_photo).setOnClickListener(this)
        view.findViewById<TextView>(R.id.txt_choose_photo).setOnClickListener(this)
        view.findViewById<TextView>(R.id.txt_close).setOnClickListener(this)
        isCancelable = false
        return builder.create()
    }

    private fun takePhoto() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "NEW")
        val capturedImage = activity.contentResolver
                .insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        val takePicktureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        takePicktureIntent.putExtra(MediaStore.EXTRA_OUTPUT, capturedImage)
        activity.startActivityForResult(takePicktureIntent, REQUEST_CAMERA)
        dismiss()
    }

    private fun choosePhoto() {
        val galleryIntent = Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        activity.startActivityForResult(galleryIntent, REQUEST_GALLERY)
        dismiss()
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.txt_choose_photo -> choosePhoto()
            R.id.txt_take_photo -> takePhoto()
            R.id.txt_close -> dismiss()
        }
    }
}