package www.uzmd.alnamoz.data.mapper

import www.uzmd.alnamoz.data.database.dbmode.TimesDbModel
import www.uzmd.alnamoz.data.database.dbmode.UserDbModel
import www.uzmd.alnamoz.data.internet.model_dto.Times
import www.uzmd.alnamoz.domain.entities.NamazTime
import www.uzmd.alnamoz.domain.entities.UserModel

class Mapper {
    fun mapperUserModelToUserDbModel(userModel: UserModel): UserDbModel {
        return UserDbModel(userModel.id, userModel.name, userModel.familia, userModel.region)
    }

    fun mapperTimesModelToTimesDbModel(times: Times?): TimesDbModel {
        return TimesDbModel(
            asr = times?.asr?:"",
            hufton = times?.hufton?:"",
            quyosh = times?.quyosh?:"",
            shomIftor = times?.shomIftor?:"",
            tongSaharlik = times?.tongSaharlik?:"",
            peshin = times?.peshin?:""
        )
    }

    fun mapperTimesDbModelToNamazTime(timesDbModel: TimesDbModel?): NamazTime {
        return NamazTime(
            asr = timesDbModel?.asr?:"10",
            quyosh = timesDbModel?.quyosh?:"10",
            hufton = timesDbModel?.hufton?:"10",
            shomIftor = timesDbModel?.shomIftor?:"10",
            tongSaharlik = timesDbModel?.tongSaharlik?:"10",
            peshin = timesDbModel?.peshin?:"10"
        )
    }

    fun mapperUserDbModelToUserModel(userDbModel: UserDbModel?): UserModel {
        return UserModel(
            name = userDbModel?.name?:"",
            familia = userDbModel?.familia?:"",
            region = userDbModel?.region?:""
        )
    }
}