package io.gudnam.kotlin_retrofit.data.api.model

/**
 * Created by gudnam on 2017. 5. 11..
 */
class APIAuthInfoResponse(val data: APIAuthInfoDataResponse)

class APIAuthInfoDataResponse(
        val type: String,
        val AccessToken: String
)