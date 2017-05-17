package io.gudnam.kotlin_retrofit.data

import io.gudnam.kotlin_retrofit.data.api.APIService
import io.gudnam.kotlin_retrofit.data.mapper.AuthMapper
import io.gudnam.kotlin_retrofit.domain.entity.Auth
import io.gudnam.kotlin_retrofit.repository.dataset.AuthDataSet

/**
 * Created by gudnam on 2017. 5. 12..
 */
class CloudAuthDataSet(val apiService: APIService) : AuthDataSet {

    override fun requestAuthNumber(phoneNumber: String): Auth? =
            apiService.requestAuthNumber(phoneNumber).unwrapCall {
                AuthMapper().transform(data)
            }

}