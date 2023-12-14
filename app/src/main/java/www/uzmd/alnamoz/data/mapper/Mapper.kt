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

    fun mapperTimesModelToTimesDbModel(times: Times): TimesDbModel {
        return TimesDbModel(
            asr = times.asr,
            hufton = times.hufton,
            quyosh = times.quyosh,
            shomIftor = times.shomIftor,
            tongSaharlik = times.tongSaharlik,
            peshin = times.peshin
        )
    }

    fun mapperTimesDbModelToNamazTime(timesDbModel: TimesDbModel): NamazTime {
        return NamazTime(
            asr = timesDbModel.asr,
            quyosh = timesDbModel.quyosh,
            hufton = timesDbModel.hufton,
            shomIftor = timesDbModel.shomIftor,
            tongSaharlik = timesDbModel.tongSaharlik,
            peshin = timesDbModel.peshin
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