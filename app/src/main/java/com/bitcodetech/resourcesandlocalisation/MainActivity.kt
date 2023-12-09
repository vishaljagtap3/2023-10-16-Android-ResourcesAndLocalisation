package com.bitcodetech.resourcesandlocalisation

import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var btnSubmit : Button
    private lateinit var edtInfo : EditText
    private lateinit var txtInfo : TextView
    private lateinit var imgFlag : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        //get the data back
        if(lastCustomNonConfigurationInstance != null) {
            txtInfo.text = lastCustomNonConfigurationInstance as String
        }

        val company = resources.getString(R.string.company)
        val isHidden = resources.getBoolean(R.bool.is_hidden)
        val drawable = resources.getDrawable(R.drawable.ic_launcher_background, null)
        val companyCode = resources.getInteger(R.integer.company_code)

        val pincodes = resources.getIntArray(R.array.pin_codes)
        val areas = resources.getStringArray(R.array.areas)

        val config = resources.configuration

        val kbType = when(config.keyboard) {
            Configuration.KEYBOARD_QWERTY -> "Qwerty"
            Configuration.KEYBOARD_12KEY -> "12 Keys"
            else -> "Not Known"
        }
        Log.e("tag", "Keyboard: ${kbType}")

        val orientation = when(config.orientation) {
            Configuration.ORIENTATION_LANDSCAPE ->"Landscape"
            Configuration.ORIENTATION_PORTRAIT -> "Portrait"
            else -> "Not Known"
        }
        Log.e("tag", "Orientation: ${orientation}")

        Log.e("tag", "Locale: ${config.locale.country} ${config.locale.script}")

        btnSubmit.setOnClickListener {
            txtInfo.text = edtInfo.text.toString()
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onRetainCustomNonConfigurationInstance(): Any? {

        return txtInfo.text
    }

    private fun initViews() {
        btnSubmit = findViewById(R.id.btnSubmit)
        edtInfo = findViewById(R.id.edtInfo)
        txtInfo = findViewById(R.id.txtInfo)
        imgFlag = findViewById(R.id.imgFlag)
    }
}