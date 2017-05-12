package io.gudnam.kotlin_retrofit.data

import io.gudnam.kotlin_retrofit.data.unwrapCall
import io.gudnam.kotlin_retrofit.data.api.APIService
import io.gudnam.kotlin_retrofit.data.mapper.UserMapper
import io.gudnam.kotlin_retrofit.domain.entity.User
import io.gudnam.kotlin_retrofit.repository.dataset.UserDataSet

/**
 * Created by gudnam on 2017. 5. 11..
 */
class CloudUserDataSet(val apiService: APIService) : UserDataSet {

}