package arsensaliev.ru.translator.model.datasource

import arsensaliev.ru.translator.model.data.DataModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("words/search")
    fun search(@Query("search") wordToSearch: String): Observable<List<DataModel>>
}
