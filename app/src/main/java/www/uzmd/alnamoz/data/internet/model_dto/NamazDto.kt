package www.uzmd.alnamoz.data.internet.model_dto

import com.google.gson.annotations.SerializedName

class NamazDto(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("times")
	val times: Times,

	@field:SerializedName("weekday")
	val weekday: String? = null,

	@field:SerializedName("region")
	val region: String? = null,

	@field:SerializedName("hijri_date")
	val hijriDate: HijriDate? = null
)



