package com.school.kotlin.ui.otp


import android.arch.lifecycle.MutableLiveData
import com.school.kotlin.api.model.MyViewModel
import com.school.kotlin.data.otp.OtpRequest
import com.school.kotlin.data.otp.OtpResponse
import com.school.kotlin.data.resendOtp.ResendOtpResponse

/**
 * Created by android on 19/2/18.
 * model class for login
 */
class OtpModel : MyViewModel() {

    var response = MutableLiveData<OtpResponse>()
    var responseResendOtp = MutableLiveData<ResendOtpResponse>()

    fun putOtp(request: OtpRequest) {
        isLoading.value = true
        OtpRepository.sendOtp({
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