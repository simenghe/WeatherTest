package noteasy.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    var weatherTest: String = ""
    var torontoAddress: String = "https://api.darksky.net/forecast/6e0b8d2d59339c4e55989aa2ff4e6d8b/43.6332,-79.4186"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getJson()
        recycle.layoutManager = LinearLayoutManager(this)
    }

    fun getJson() {
        println("Getting Json")
        val url = torontoAddress
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)
                val gson = GsonBuilder().create()
                val Weather = gson.fromJson(body, Weather::class.java)
                runOnUiThread {
                    recycle.adapter = MainAdapter(Weather)
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
        val timezone: String,
        val currently: Currently
)
class Currently(
        val summary: String,
        val temperature: Double,
        val icon:String
)


