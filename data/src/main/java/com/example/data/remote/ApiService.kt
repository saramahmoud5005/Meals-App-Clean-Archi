package com.example.data.remote

interface ApiService {
    @GET(categories.php)
    fun getMeals():CategoryResponse
}