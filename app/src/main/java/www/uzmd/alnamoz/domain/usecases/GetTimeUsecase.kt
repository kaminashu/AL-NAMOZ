package www.uzmd.alnamoz.domain.usecases

import www.uzmd.alnamoz.domain.repositories.AppRepository

class GetTimeUsecase(private val repository: AppRepository) {
    operator fun invoke() = repository.getTimes()
}