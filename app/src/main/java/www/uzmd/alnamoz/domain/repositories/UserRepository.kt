package www.uzmd.alnamoz.domain.repositories

import www.uzmd.alnamoz.domain.entities.UserTimesModel


interface UserRepository {
    fun getNamazTimes(): UserTimesModel
    fun loadData()
}