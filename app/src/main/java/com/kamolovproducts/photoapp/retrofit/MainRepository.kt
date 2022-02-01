package com.kamolovproducts.photoapp.retrofit

class MainRepository constructor(private val retrofitService: RetrofitService){

    fun getAllLives() = retrofitService.getAllLives()
}