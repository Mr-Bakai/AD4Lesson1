package com.hfad.ad4lesson1
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.hfad.ad4lesson1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var ui: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(ui.root)

        val data: String? = intent.getStringExtra("res").toString()
        data?.let { ui.editText.setText(data) }

        ui.button.setOnClickListener {
            if (!ui.editText.text.isNullOrBlank()) {

                val intent = Intent()
                intent.putExtra("res", ui.editText.text?.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()

            } else {
                showMessage()
            }
        }
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }

    private fun showMessage() {
        Toast.makeText(this, "Field cannot be empty", Toast.LENGTH_SHORT).show()
    }
}