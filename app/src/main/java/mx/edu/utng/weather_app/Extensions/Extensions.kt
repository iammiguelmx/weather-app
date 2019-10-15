package mx.edu.utng.weather_app.Extensions

import android.support.design.widget.Snackbar
import android.view.View
import android.view.ViewGroup
import org.json.JSONArray
import org.json.JSONObject
import mx.edu.utng.weather_app.R

operator fun JSONArray.iterator():Iterator<JSONObject>
        =(0 until length()).asSequence().map { get(it) as JSONObject }.iterator()

fun View.displaySnack(message:String, legth:Int=Snackbar.LENGTH_LONG, f:Snackbar.() -> Unit){
    val snackbar = Snackbar.make(this, message, legth)
    snackbar.f()
    snackbar.show()
}

fun Snackbar.action(message:String, listener:(View) -> Unit){
    setAction(message,listener)
}