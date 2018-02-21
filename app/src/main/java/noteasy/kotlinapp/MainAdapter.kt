package noteasy.kotlinapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.info_row.view.txtOnline
import java.math.RoundingMode
import java.text.DecimalFormat

/**
 * Created by Simeng on 2/20/2018.
 */
class MainAdapter(val weather:Weather): RecyclerView.Adapter<CustomView>(){
    public fun ftoC(x: Double):Double {
        return ((x-32)*5)/9
    }
    override fun getItemCount(): Int {
        return 3
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomView {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.info_row, parent, false)
        return CustomView(cellForRow)
    }
    override fun onBindViewHolder(holder: CustomView?, position: Int) {
        val temp=ftoC(weather?.currently?.temperature)
        val df=DecimalFormat("#.##")
        df.roundingMode=RoundingMode.CEILING
        holder?.view?.txtOnline?.text=df.format(temp)+"°C"
    }

}
class CustomView(val view:View):RecyclerView.ViewHolder(view){

}