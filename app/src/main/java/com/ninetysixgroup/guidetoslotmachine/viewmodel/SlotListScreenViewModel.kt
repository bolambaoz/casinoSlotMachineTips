package com.ninetysixgroup.guidetoslotmachine.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ninetysixgroup.guidetoslotmachine.model.ApiModel
import com.ninetysixgroup.guidetoslotmachine.retrofit.RetroInstance
import com.ninetysixgroup.guidetoslotmachine.retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SlotListScreenViewModel: ViewModel() {

    lateinit var liveDataList: MutableLiveData<List<ApiModel>>

    init {
        liveDataList = MutableLiveData()
    }


    fun getLiveDataObserver(): MutableLiveData<List<ApiModel>>{
        return liveDataList
    }

    fun makeAPICall() {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.getData()

        call.enqueue(object : Callback<List<ApiModel>> {
            override fun onFailure(call: Call<List<ApiModel>>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(
                call: Call<List<ApiModel>>,
                response: Response<List<ApiModel>>
            ) {
                liveDataList.postValue(response.body())
            }
        })
    }
}

