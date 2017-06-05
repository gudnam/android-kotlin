package io.gudnam.kotlin_realm.data.api.model

/**
 * Created by gudnam on 2017. 5. 11..
 */
class CloudUser (
        val id: Int,
        val phoneNumber: String,
        val name: String,
        val authNumber: String,
        val postNo: String,
        val addr1: String,
        val addr2: String,
        val email: String,
        val createdAt: String,
        val updatedAt: String,
        val macaddressList: List<String>,
        val requestList: List<String>
)