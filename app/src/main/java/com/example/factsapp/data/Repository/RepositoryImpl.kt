package com.example.factsapp.data.Repository

import com.example.factsapp.data.remote.FactApi
import com.example.factsapp.domain.Repository.Repository
import com.example.factsapp.domain.model.Fact
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: FactApi
) : Repository {
    override suspend fun getfacts(): Fact {
        return api.getfacts()
    }
}