package noteasy.kotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.info_row.*
import okhttp3.*
import java.io.IOException
import java.nio.file.WatchEvent

class MainActivity : AppCompatActivity() {
    var toronto=6167865
    var weatherTest:String=""
    var torontoAddress:String="https://api.darksky.net/forecast/6e0b8d2d59339c4e55989aa2ff4e6d8b/43.6332,-79.4186"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getJson(torontoAddress)
        recycle.layoutManager=LinearLayoutManager(this)
    }
    private fun getJson(torontoFull:String) {
        println("Getting Json")
        val client=OkHttpClient()
        val request= Request.Builder().url(torontoFull).build()
        client.newCall(request).enqueue(object:Callback{
            override fun onResponse(call: Call?, response: Response?) {
                val body=response?.body()?.string()
                println(body)
                val gson=GsonBuilder().create()
                val Weather=gson.fromJson(body,Weather::class.java)
                runOnUiThread{
                    recycle.adapter=MainAdapter(Weather)
                }
                println(Weather.timezone)
            }
            override fun onFailure(call: Call?, e: IOException?) {
                println("Failure")
            }
        })
    }
}
class Weather(
        val timezone:String,
        val currently: Currently
)
class Currently(
        val summary:String,
        val temperature:Double
)


