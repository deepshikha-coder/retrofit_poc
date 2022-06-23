package deepshikha.jangidyahoo.retrofit_poc.repository

import deepshikha.jangidyahoo.retrofit_poc.model.ItemResponse
import deepshikha.jangidyahoo.retrofit_poc.model.item
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface  Service {
    @GET("/2.3/users?order=desc&sort=reputation&site=stackoverflow")
    fun getResponse(): Call<ItemResponse>

    companion object {

        var retrofitService: Service? = null

        fun getInstance(): Service {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.stackexchange.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(Service::class.java)
            }
            return retrofitService!!
        }
    }
}