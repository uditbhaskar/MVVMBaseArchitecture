package com.example.sampleapp.data.repository

import com.example.sampleapp.data.local.DatabaseService
import com.example.sampleapp.data.model.Dummy
import com.example.sampleapp.data.remote.request.DummyRequest
import com.example.sampleapp.data.remote.response.NetworkService
import io.reactivex.Single
import javax.inject.Inject

class DummyRepository @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService
) {

    fun fetchDummy(id: String): Single<List<Dummy>> =
        networkService.doDummyCall(DummyRequest(id)).map { it.data }

}