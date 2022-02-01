package com.kamolovproducts.photoapp.retrofit


import com.kamolovproducts.photoapp.data.ModelPhoto
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface RetrofitService {
    @GET("task-m-001/list.php")
    fun getAllLives(): Call<List<ModelPhoto>>

    companion object {

        private val retrofitService: RetrofitService by lazy {


            val retrofit = Retrofit.Builder()
                .baseUrl("https://dev-tasks.alef.im/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(RetrofitService::class.java)

        }


        fun getInstance(): RetrofitService {
            return retrofitService
        }

    }
}