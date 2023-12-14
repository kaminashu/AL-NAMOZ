package www.uzmd.alnamoz.domain.usecases

import www.uzmd.alnamoz.domain.repositories.AppRepository

class GetUserInfo(private val repo: AppRepository) {
    operator fun invoke() = repo.getUserInfo()
}