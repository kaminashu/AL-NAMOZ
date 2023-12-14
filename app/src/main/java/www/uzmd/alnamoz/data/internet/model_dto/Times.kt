package www.uzmd.alnamoz.data.internet.model_dto

import com.google.gson.annotations.SerializedName

class Times(

    @field:SerializedName("asr")
    val asr: String? = null,

    @field:SerializedName("quyosh")
    val quyosh: String? = null,

    @field:SerializedName("hufton")
    val hufton: String? = null,

    @field:SerializedName("shom_iftor")
    val shomIftor: String? = null,

    @field:SerializedName("tong_saharlik")
    val tongSaharlik: String? = null,

    @field:SerializedName("peshin")
    val peshin: String? = null
)