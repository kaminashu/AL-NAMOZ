package www.uzmd.alnamoz.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import www.uzmd.alnamoz.R
import www.uzmd.alnamoz.data.internet.connection.ApiCillent
import www.uzmd.alnamoz.data.internet.connection.ApiService
import www.uzmd.alnamoz.presentation.ui.settings.SettingsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, SettingsFragment()).commit()
        val create = ApiCillent.getRetrofit().create(ApiService::class.java)
        lifecycleScope.launch {
            val time = create.loadRegionNamazTime("Xonqa").times?.tongSaharlik
            Log.d("TAG", "onCreate: $time")
        }
    }
}