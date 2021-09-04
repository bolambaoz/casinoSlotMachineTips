package com.ninetysixgroup.guidetoslotmachine.retrofit

import com.ninetysixgroup.guidetoslotmachine.model.ApiModel
import retrofit2.Call
import retrofit2.http.GET

interface RetroServiceInterface {

    @GET("vlog")
    fun getData(): Call<List<ApiModel>>
}