package mx.edu.utng.weather_app.API



import  mx.edu.utng.weather_app.Models.CurrentWeather
import  mx.edu.utng.weather_app.Models.Day
import  mx.edu.utng.weather_app.Extensions.iterator
import  mx.edu.utng.weather_app.Models.Hour
import org.json.JSONObject

fun getCurrentWeatherJSON(response: JSONObject): CurrentWeather {
    with(response.getJSONObject(CURRENTLY)) {
        return CurrentWeather(
            getString(ICON),
            getString(SUMMARY),
            getDouble(TEMPERATURE),
            getDouble(PRECIPPROBABILITY)
        )
    }
}

fun getDailyWeatherJSON(response: JSONObject): ArrayList<Day> {
    with(response.getJSONObject(DAILY)) {
        val dayArray = getJSONArray(DATA)
        val days = ArrayList<Day>()
        for (i in dayArray) {
            with(i) {
                val min = getDouble(TEMPERATUREMIN)
                val max = getDouble(TEMPERATUREMAX)
                val time = getLong(TIME)
                days.add(Day(time, min, max))
            }

        }
        return days
    }
}
fun getHourlyWeatherJSON(response: JSONObject): ArrayList<Hour> {
    val timeZone = response.getString(TIMEZONE)
    with(response.getJSONObject(HOURLY)) {
        val hourArray = getJSONArray(DATA)
        val hour = ArrayList<Hour>()
        for (i in hourArray) {
            with(i) {
                val time = getLong(TIME)
                val temp = getDouble(TEMPERATURE)
                val precip = getDouble(PRECIPPROBABILITY)

                hour.add(Hour(time, temp, precip, timeZone))
            }
        }
        return hour
    }
}