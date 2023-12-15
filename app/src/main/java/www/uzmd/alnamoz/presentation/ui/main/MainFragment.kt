package www.uzmd.alnamoz.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import www.uzmd.alnamoz.databinding.FragmentMainBinding
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentMainBinding? = null
    private val viewModel by lazy {
        ViewModelProvider(this)[MainFragmentViewModel::class.java]
    }

    private val binding: FragmentMainBinding
        get() = _binding ?: throw RuntimeException("Binding da muammo bor")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding =
            FragmentMainBinding.inflate(LayoutInflater.from(container?.context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            while (true) {

                val calendar = Calendar.getInstance().time.time
                val localTime = SimpleDateFormat("HH:mm")
                val datetime = localTime.format(calendar)
                binding.localTime.text = datetime.toString()
                val localHour = SimpleDateFormat("HH")
                val localMinutes = SimpleDateFormat("mm")
                val datetimeHour = localHour.format(calendar)
                val datetimeMinutes = localMinutes.format(calendar)
                val nextNamaz = viewModel.nextNamaz(datetimeHour.toInt(), datetimeMinutes.toInt())
                var namazType = when (nextNamaz[0]) {
                    0 -> {
                        "Bomdot"
                    }

                    1 -> {
                        "Peshin"
                    }

                    2 -> {
                        "Asr"
                    }

                    3 -> {
                        "Shom"
                    }

                    4 -> {
                        "Xufton"
                    }

                    else -> {
                        throw RuntimeException("error whlie")
                    }
                }
                binding.nextNamazTime.text =
                    "$namazType ga ${nextNamaz[1]} soat ${nextNamaz[2]} daqiqa qoldi"
                delay(10000)
            }
        }
        binding.userNameMain.text = "Salom ${viewModel.getUserInfofunc().name}"
        val times = viewModel.getTimes()
        var saxarlik = times.tongSaharlik.toString()
        var peshin = times.peshin.toString()
        var asr = times.asr.toString()
        var hufton = times.hufton.toString()
        var shom = times.shomIftor.toString()
        binding.apply {
            bomdotTime.text = saxarlik
            namazAsrTime.text = asr
            namazXuftomTime.text = hufton
            namazShomTime.text = shom
            namazPeshinTime.text = peshin
        }
        val userInfofunc = viewModel.getUserInfofunc()


        binding.mintaqaTxt.text = "Mintaqa : ${userInfofunc.region}"
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}