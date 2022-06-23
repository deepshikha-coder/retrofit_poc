package deepshikha.jangidyahoo.retrofit_poc.repository

class MainRepository constructor(private val retrofitService: Service) {

    fun getAllMovies() = retrofitService.getResponse()
}