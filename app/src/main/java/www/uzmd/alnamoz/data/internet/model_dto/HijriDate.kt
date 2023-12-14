package www.uzmd.alnamoz.data.internet.model_dto

import com.google.gson.annotations.SerializedName
 class HijriDate(

    @field:SerializedName("month")
    val month: String? = null,

    @field:SerializedName("day")
    val day: Int? = null
)
