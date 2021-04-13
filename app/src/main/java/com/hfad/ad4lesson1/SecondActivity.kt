package com.hfad.ad4lesson1
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hfad.ad4lesson1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var ui: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(ui.root)

        val data: String? = intent.getStringExtra(MainActivity.KEY_RES).toString()
        data?.let { ui.editText.setText(data) }

        ui.button.setOnClickListener {
            if (!ui.editText.text.isNullOrBlank()) {

                setResult(Activity.RESULT_OK, Intent().putExtra(MainActivity.KEY_RES, ui.editText.text?.toString()))
                finish()

            } else {
                showMessage("This is the second activity")
            }
        }
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}