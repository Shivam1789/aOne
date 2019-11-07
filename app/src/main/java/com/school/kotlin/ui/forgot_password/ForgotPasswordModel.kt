package com.school.kotlin.ui.forgot_password


import android.arch.lifecycle.MutableLiveData
import com.school.kotlin.api.model.MyViewModel
import com.school.kotlin.data.ForgotPassword.ForgotPasswordRequest
import com.school.kotlin.data.ForgotPassword.ForgotPasswordResponse

/**
 * Created by android on 19/2/18.
 * model class for login
 */
class ForgotPasswordModel : MyViewModel() {
    var response = MutableLiveData<ForgotPasswordResponse>()

    fun forgotPassword(request: ForgotPasswordRequest) {
        isLoading.value = true
        ForgotPasswordRepository.forgotPassword({
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