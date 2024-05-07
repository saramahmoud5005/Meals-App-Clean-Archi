package com.example.domain.repo

import com.example.domain.model.CategoryResponse

interface MealsRepo {
    fun getMealsFromRemote():CategoryResponse
}