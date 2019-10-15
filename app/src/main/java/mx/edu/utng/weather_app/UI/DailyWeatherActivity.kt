package mx.edu.utng.weather_app.UI


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import  mx.edu.utng.weather_app.Adapters.DayAdapter
import  mx.edu.utng.weather_app.R
import mx.edu.utng.weather_app.models.Day
import kotlinx.android.synthetic.main.activity_daily_weather.*

class DailyWeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_weather)
        //se ejecuta solo sino es nulo
        intent.let {
            //rellenar Lista
            val days:ArrayList<Day> = it.getParcelableArrayListExtra(MainActivity.DAILY_WEATHER)
            val adapter = DayAdapter(context = this,dataSource = days)
            dailyListView.adapter=adapter

        }
        dailyListView.emptyView=textViewNoData
    }
}