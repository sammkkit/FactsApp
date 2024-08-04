package com.example.factsapp.domain.Repository

import com.example.factsapp.domain.model.Fact

interface Repository {
    suspend fun getfacts(): Fact
}