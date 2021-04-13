package com.hfad.ad4lesson1
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.hfad.ad4lesson1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var ui: ActivityMainBinding
    private lateinit var startForResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)

        startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val intent = result.data
                    ui.editText.setText(intent?.getStringExtra(KEY_RES))
                }
            }

        ui.textView.invisible()

        ui.button.setOnClickListener {
            if (!ui.editText.text.isNullOrBlank()) {

                startForResult.launch(Intent(this@MainActivity, SecondActivity::class.java)
                    .putExtra(KEY_RES, ui.editText.text?.toString()))

            } else {
                showMessage("Well this is the first activity")
            }
        }
    }

    companion object {
        const val KEY_RES = "res"
    }
}
