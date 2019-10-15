package mx.edu.utng.weather_app.UI

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import mx.edu.utng.weather_app.Adapters.HourAdapter
import  mx.edu.utng.weather_app.R
import  mx.edu.utng.weather_app.Models.Hour
import kotlinx.android.synthetic.main.activity_hourly_weather.*


class HourlyWeatherActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hourly_weather)
        hourlyRecyclerView.setHasFixedSize(true)
        hourlyRecyclerView.layoutManager=LinearLayoutManager(this)
        var hour:ArrayList<Hour> = ArrayList()
        intent.let {
            hour= it.getParcelableArrayListExtra(MainActivity.HOURLY_WEATHER)
            Log.d("TAG123", hour[0].toString())
            hourlyRecyclerView.adapter= HourAdapter(hour)

        }
        if (hour.isEmpty()){
            textViewNoDataHour.visibility= View.VISIBLE
        }else{
            textViewNoDataHour.visibility= View.INVISIBLE
        }


    }
}