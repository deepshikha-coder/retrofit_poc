package deepshikha.jangidyahoo.retrofit_poc.ViewModel

import android.content.ClipData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import deepshikha.jangidyahoo.retrofit_poc.model.ItemResponse
import deepshikha.jangidyahoo.retrofit_poc.model.item
import deepshikha.jangidyahoo.retrofit_poc.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserViewModel(private val repository: MainRepository) : ViewModel() {

    val UserList = MutableLiveData<List<item>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllUsers() {
        val response = repository.getAllMovies()
        response.enqueue(object : Callback<ItemResponse> {
            override fun onResponse(call: Call<ItemResponse>, response: Response<ItemResponse>) {
                UserList.postValue(response.body()?.items)
            }

            override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}








