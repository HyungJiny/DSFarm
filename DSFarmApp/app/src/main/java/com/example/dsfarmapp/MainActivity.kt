package com.example.dsfarmapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    private var textView: TextView? = null
    private var buttonOnOff: Button? = null
    private var requestQueue: RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "DSbioFarm"

        textView = findViewById<TextView>(R.id.text)
        buttonOnOff = findViewById<Button>(R.id.buttonOnOff)
        requestQueue = Volley.newRequestQueue(this)

        buttonOnOff?.setOnClickListener{ sendOnOffRequest() }
    }

    private fun sendOnOffRequest() {
        val url = "http://192.168.0.7:8000/data"

        //RequestQueue initialized
        requestQueue = Volley.newRequestQueue(this)

        //String Request initialized
        var mStringRequest =
            object : StringRequest(Method.POST, url, Response.Listener { response ->
                Toast.makeText(applicationContext, "On/Off Successfully", Toast.LENGTH_SHORT)
                    .show()


            }, Response.ErrorListener { error ->
                Log.i("This is the error", "Error :" + error.toString())
                Toast.makeText(
                    applicationContext,
                    "Please make sure you enter correct password and username",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                override fun getBodyContentType(): String {
                    return "application/json"
                }

                @Throws(AuthFailureError::class)
                override fun getBody(): ByteArray {
                    val params2 = HashMap<String, String>()

                    params2.put("led", buttonOnOff?.text.toString())

                    if (buttonOnOff?.text.toString().equals("on")){
                        buttonOnOff?.setText("off")
                    }else{
                        buttonOnOff?.setText("on")
                    }
                    return JSONObject(params2 as Map<*, *>).toString().toByteArray()
                }

            }
        requestQueue!!.add(mStringRequest!!)
    }
}