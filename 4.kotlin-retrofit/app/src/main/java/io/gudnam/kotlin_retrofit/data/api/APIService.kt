package io.gudnam.kotlin_retrofit.data.api

import io.gudnam.kotlin_retrofit.data.api.model.APIAuthInfoResponse
import io.gudnam.kotlin_retrofit.data.api.model.APIAuthNumberResponse
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by gudnam on 2017. 5. 11..
 */
interface APIService {

    @FormUrlEncoded
    @POST("auth/number")
    fun requestAuthNumber(@Field("phoneNumber") phoneNumber: String): Call<APIAuthNumberResponse>

    @GET("auth/startApp")
    fun requestAuthInfo(@Query("phoneNumber") phoneNumber: String, @Query("authNumber") authNumber: String): Call<APIAuthInfoResponse>
}