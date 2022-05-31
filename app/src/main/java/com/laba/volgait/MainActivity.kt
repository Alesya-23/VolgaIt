package com.laba.volgait

import android.content.Intent
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.*
import com.laba.volgait.model.models.Stock
import com.laba.volgait.ui.stocks.StocksActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val nextScreenIntent = Intent(this, StocksActivity::class.java)
            startActivity(nextScreenIntent)
            finish()
        }
    }
}

//попытки достучаться до api
//
//        val gson = GsonBuilder()
//                .setLenient()
//                .create()
//        val service = Retrofit.Builder()
//                .baseUrl("https://finnhub.io/c8f19a2ad3ibvc83srs0/v1/")
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build()
//                .create(UserService::class.java)
//
//        service.getUsers().enqueue(object : Callback<List<Stock>> {
//
//            /* The HTTP call failed. This method is run on the main thread */
//            override fun onFailure(call: Call<List<Stock>>, t: Throwable) {
//                Log.d("TAG_", "An error happened!")
//                t.printStackTrace()
//            }
//
//            /* The HTTP call was successful, we should still check status code and response body
//             * on a production app. This method is run on the main thread */
//            override fun onResponse(call: Call<List<Stock>>, response: Response<List<Stock>>) {
//                val response2: String = response.toString()
//                val gson = Gson()
//                val posts = response.body()
////                posts?.let {
////                    for (post in posts) {
////                        val fromUserJson = Gson().toJson(notificationRequest.fromUser)
////                        val feedServiceResponse = gson.fromJson(response.body().toString(), Stock.class)
////                        /* This will print the response of the network call to the Logcat */
////                    }
////                }
//                val customGson = GsonBuilder().registerTypeHierarchyAdapter(ByteArray::class.java, ByteArrayToBase64Adapter()).create()
//                val responseModel = customGson.fromJson(response2, Stock::class.java)
//                Log.d("TAG_", response.body().toString())
//            }
//        })
//    }
//}
//
//class ByteArrayToBase64Adapter : JsonSerializer<ByteArray?>, JsonDeserializer<ByteArray?> {
//    @Throws(JsonParseException::class)
//    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): ByteArray {
//        return Base64.decode(json.asString, Base64.NO_WRAP)
//    }
//
//    override fun serialize(src: ByteArray?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
//        return JsonPrimitive(Base64.encodeToString(src, Base64.NO_WRAP))
//    }
//}
///* Kotlin data/model classes that map the JSON response, we could also add Moshi
// * annotations to help the compiler with the mappings on a production app */
//data class UserResponse(val results: List<User>)
//data class User(val email: String, val phone: String)
//
///* Retrofit service that maps the different endpoints on the API, you'd create one
// * method per endpoint, and use the @Path, @Query and other annotations to customize
// * these at runtime */
//interface UserService {
//    @GET("/stock/symbol?exchange=US")
//    fun getUsers(): Call<List<Stock>>
//}
////        val apiService = create()
////        CoroutineScope(Dispatchers.IO).launch {
////
////            apiService.test()
//////            call.enqueue(object : Callback() {
//////                fun onResponse(call: Call?, response: Response) {
//////                    Log.e("TAG", "response 33: " + Gson().toJson(response.body()))
//////                }
//////
//////                fun onFailure(call: Call?, t: Throwable) {
//////                    Log.e("TAG", "onFailure: $t")
//////                    // Log error here since request failed
//////                }
//////            })
//////            val response = apiService.test()
////
////            // process response...
////
////        }
////        run("https://api.github.com/users/Evin1-/repos")
////    }
////
////    fun run(url: String) {
////        val request = Request.Builder()
////                .url(url)
////                .build()
////
////        client.newCall(request).enqueue(object : Callback, okhttp3.Callback {
////            fun onFailure(call: Call, e: IOException) {}
////            fun onResponse(call: Call, response: Response) = println(response.body()?.string())
////        })
////    }
////
////
////    fun getStocks() {
////        //CoroutineScope(Dispatchers.IO).launch {
////      //  RetrofitService.retrofitService?.stockSymbols()
////        //}
////    }
////}
////fun removeQuotesAndUnescape(uncleanJson: String): String? {
////    val noQuotes = uncleanJson.replace("^\"|\"$".toRegex(), "")
////    return StringEscapeUtils.unescapeJava(noQuotes)
////}