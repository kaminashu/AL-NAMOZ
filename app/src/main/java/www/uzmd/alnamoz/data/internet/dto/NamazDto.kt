package www.uzmd.alnamoz.data.internet.dto

import com.google.gson.annotations.SerializedName

data class NamazDto(
	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("times")
	val times: Times? = null,

	@field:SerializedName("weekday")
	val weekday: String? = null,

	@field:SerializedName("region")
	val region: String? = null
)


