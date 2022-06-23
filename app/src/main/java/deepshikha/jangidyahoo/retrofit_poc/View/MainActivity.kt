package deepshikha.jangidyahoo.retrofit_poc.View

import android.content.ClipData
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import deepshikha.jangidyahoo.retrofit_poc.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import deepshikha.jangidyahoo.retrofit_poc.ViewModel.UserViewModel
import deepshikha.jangidyahoo.retrofit_poc.ViewModel.UserViewModelFactory
import deepshikha.jangidyahoo.retrofit_poc.model.ItemResponse
import deepshikha.jangidyahoo.retrofit_poc.model.item
import deepshikha.jangidyahoo.retrofit_poc.repository.MainRepository
import deepshikha.jangidyahoo.retrofit_poc.repository.Service
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.cert.CertPathValidator.getInstance
import java.util.Calendar.getInstance

class MainActivity : AppCompatActivity() {
    private var mAdapter: ItemAdapter?= null;
    lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerview = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerview.layoutManager = LinearLayoutManager(this)

        viewModel =
            ViewModelProvider(this, UserViewModelFactory(MainRepository(Service.getInstance()))).get(
                UserViewModel::class.java
            )

        //set recyclerview adapter

        viewModel.UserList.observe(this, Observer {
            Log.d("Deep", "UserList: $it")
            mAdapter = ItemAdapter(this, it)
            recyclerview.adapter = mAdapter
            mAdapter!!.setOnItemClickListener(object : ItemAdapter.onItemClickListener{
                override fun onItemCLick(position: Int) {
                    val intent = Intent(this@MainActivity,UserDetail::class.java)
                    intent.putExtra("accountId", it.get(position)?.account_id.toString())
                    intent.putExtra("display_name",it[position].display_name.toString())
                    intent.putExtra("link",it[position].link.toString())
                    intent.putExtra("location",it[position].location.toString())
                    intent.putExtra("profile_image",it[position].profile_image.toString())
                    intent.putExtra("reputation",it[position].reputation.toString())
                    startActivity(intent)
                }

            })

        })

        viewModel.getAllUsers()







    }

}