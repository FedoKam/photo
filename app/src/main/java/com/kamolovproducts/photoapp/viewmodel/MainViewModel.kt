package com.kamolovproducts.photoapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kamolovproducts.photoapp.retrofit.MainRepository
import com.kamolovproducts.photoapp.data.ModelPhoto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {

    val liveList = MutableLiveData<List<ModelPhoto>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllLives() {

        val request = repository.getAllLives()
        request.enqueue(object : Callback<List<ModelPhoto>>{
            override fun onResponse(call: Call<List<ModelPhoto>>, response: Response<List<ModelPhoto>>) {
                liveList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<ModelPhoto>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })

    }

}