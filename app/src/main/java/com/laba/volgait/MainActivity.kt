package com.laba.volgait

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.laba.volgait.data.remote.RetrofitService
import com.laba.volgait.ui.stocks.StocksActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState!=null){
//            val nextScreenIntent = Intent(this, StocksActivity::class.java)
//            startActivity(nextScreenIntent)
//            finish()
        }
        var last = getStocks()
    }
    fun getStocks(){
        CoroutineScope(Dispatchers.IO).launch {
            RetrofitService.retrofitService?.technicalIndicator()
        }
    }
}