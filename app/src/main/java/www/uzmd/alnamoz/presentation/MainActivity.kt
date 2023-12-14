package www.uzmd.alnamoz.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import www.uzmd.alnamoz.R
import www.uzmd.alnamoz.data.internet.connection.GetApiConnection
import www.uzmd.alnamoz.data.internet.connection.GetApiService
import www.uzmd.alnamoz.presentation.ui.main.MainFragment
import www.uzmd.alnamoz.presentation.ui.settings.SettingsFragment

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this)[NamazViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_main)
        if (viewModel.testFragment()) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, MainFragment()).commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, SettingsFragment()).commit()
        }

        lifecycleScope.launch {
            val cerate = GetApiConnection.getRetrofit().create(GetApiService::class.java)
            val info = cerate.getInfo("Xonqa")
            val soat = info.times?.asr.toString()
            Log.d("TAG", "onCreate: $soat")
        }

    }
}