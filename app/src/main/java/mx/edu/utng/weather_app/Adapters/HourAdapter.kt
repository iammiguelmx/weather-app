package mx.edu.utng.weather_app.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.hourly_item.view.*

class HourAdapter(val daysList:ArrayList<Hour>) : RecyclerView.Adapter<HourAdapter.HourViewHolder>() {
    override fun onBindViewHolder(holder: HourViewHolder, position: Int) {
        return holder.bind(daysList[position])

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourViewHolder
            =HourViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.hourly_item,parent,false))


    override fun getItemCount(): Int= daysList.size


    class HourViewHolder(hourlyItemView:View):RecyclerView.ViewHolder(hourlyItemView){
        fun bind(hour:Hour)= with(itemView){
            hourTextView.text=hour.getFormattedTime()
            hourprecipTextView.text="${hour.precip.toInt()} %"
            hourtempTextView.text="${hour.temp.toInt()} C"
        }
    }
}