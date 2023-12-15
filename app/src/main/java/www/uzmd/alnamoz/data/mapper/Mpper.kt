package www.uzmd.alnamoz.data.mapper

import www.uzmd.alnamoz.data.database.dbModel.NamazModelDb
import www.uzmd.alnamoz.data.internet.dto.NamazDto
import www.uzmd.alnamoz.data.internet.dto.Times
import www.uzmd.alnamoz.domain.entities.UserTimesModel

class Mpper {
    companion object{
        fun mapperNamazDtoToNamazDbModel(namazDto: NamazDto):NamazModelDb{
            return NamazModelDb(region = namazDto.region?:"unkown", date = namazDto.date?:"unkown", weekday = namazDto.weekday?:"unkown")
        }
        fun mapperTimesToTimesUser(times:Times):UserTimesModel{
         return UserTimesModel(times.asr?:"unkown asr",times.quyosh?:"unkown quyosh",times.hufton?:"unkown hufton",times.shomIftor?:"unkown shomIftor",times.tongSaharlik?:"unkown tongSaharlik",times.peshin?:"unkown peshin")
        }
    }
}