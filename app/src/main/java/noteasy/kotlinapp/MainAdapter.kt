package noteasy.kotlinapp

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

/**
 * Created by Simeng on 2/20/2018.
 */
class MainAdapter(val weather:Weather): RecyclerView.Adapter<CustomView>(){
    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomView {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun onBindViewHolder(holder: CustomView?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
class CustomView(val view:View):RecyclerView.ViewHolder(view){

}