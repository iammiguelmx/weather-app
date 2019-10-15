package mx.edu.utng.weather_app.Models


import android.os.Parcel
import android.os.Parcelable
import java.text.SimpleDateFormat
import java.util.*


data class Day(val time:Long, val minTemp:Double, val maxTemp:Double):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readDouble(),
        parcel.readDouble())

    override fun writeToParcel(parcel: Parcel, p1: Int) {
        parcel.writeLong(time)
        parcel.writeDouble(minTemp)
        parcel.writeDouble(maxTemp)
    }

    override fun describeContents(): Int=0

    fun getFormattedTime():String{
        val formater = SimpleDateFormat("EEEE", Locale.US)
        val date = Date(time*1000)
        val dayOfWeek=formater.format(date)
        return dayOfWeek
    }

    companion object CREATOR : Parcelable.Creator<Day> {
        override fun createFromParcel(parcel: Parcel): Day {
            return Day(parcel)
        }

        override fun newArray(size: Int): Array<Day?> {
            return arrayOfNulls(size)
        }
    }
}