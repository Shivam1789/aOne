package com.school.kotlin.ui.reset_password


import android.arch.lifecycle.MutableLiveData
import com.school.kotlin.api.model.MyViewModel
import com.school.kotlin.data.ResetPassword.ResetPasswordRequest
import com.school.kotlin.data.ResetPassword.ResetPasswordResponse

/**
 * Created by android on 19/2/18.
 * model class for login
 */
class ResetPasswordModel : MyViewModel() {

    var response = MutableLiveData<ResetPasswordResponse>()

    fun resetPassword(request: ResetPasswordRequest) {
        isLoading.value = true
        ResetPasswordRepository.resetPassword({
            response.value = it
            isLoading.value = false
        }, {
            apiError.value = it
            isLoading.value = false
        }, {
            onFailure.value = it
            isLoading.value = false
        }, request)
    }


}