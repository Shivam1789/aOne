package com.school.kotlin.utils.security

import android.util.Log
import com.school.kotlin.data.Status
import com.school.kotlin.utils.Constants
import okhttp3.Interceptor
import okhttp3.Response
import org.greenrobot.eventbus.EventBus
import java.io.IOException


class ResponseInterceptorterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        Log.e("rescode", response.code().toString())
        EventBus.getDefault().post(Status(response.code(), Constants.SESSION_EXPIRED))

        /**
         ************* handle the response here first before passing to ratrofit because can't create
         * model for every value we are passing to backend if any check fails resposne come in array
         * with different key which is hard to manage with model so here parse the error response
         * here and make it sutiable for model to parse and show proper validation error message
         */
//        if (response.code() == Constants.httpcodes.STATUS_API_VALIDATION_ERROR) {
//
//            try {
//                var errorMessage = ""
//
//                val rawJson = response.body()?.string()
//                val jsonObject = JSONObject(rawJson)
//                val jasonObj = jsonObject.getJSONObject("status")
//                val jsonerror = jasonObj.getJSONObject("errorMessage")
//
//                val iter = jsonerror.keys()
//                while (iter.hasNext()) {
//                    val key = iter.next()
//                    val jsonerrorarray = jsonerror.getJSONArray(key)
//                    errorMessage = jsonerrorarray[0].toString()
//                    break
//
//                }
//
//                jsonObject.put("message", errorMessage)
//                val jsonResponse = jsonObject.toString()
//                Log.e("response==>", jsonResponse)
//                // Re-create the response before returning it because body can be read only once
//                return response.newBuilder()
//                        .body(ResponseBody.create(response.body()!!.contentType(), jsonResponse)).build()
//
//
//            } catch (e: JSONException) {
//                Log.e("parsingError", e.localizedMessage)
//            }
//            catch (e: IllegalStateException) {
//                Log.e("parsingError", e.localizedMessage)
//            }
//
//            }
//
//            return response
//    }
        return response
    }
}