package noteasy.kotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.info_row.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var toronto=6167865
    var torontoFull:String="https://api.darksky.net/forecast/6e0b8d2d59339c4e55989aa2ff4e6d8b/43.6332,-79.4186"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun getJson(c:String) {
        println("Getting Json")
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
data class Weather(
       val temperature:Double,
       val timeZone:String
)


