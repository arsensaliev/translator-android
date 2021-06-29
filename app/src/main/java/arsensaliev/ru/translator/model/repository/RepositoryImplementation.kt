package arsensaliev.ru.translator.model.repository

import arsensaliev.ru.translator.model.data.DataModel
import arsensaliev.ru.translator.model.datasource.DataSource
import io.reactivex.Observable

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    private val cache = mutableMapOf<String, List<DataModel>>()

    override fun getData(word: String): Observable<List<DataModel>> {
        if (cache.containsKey(word)) {
            return Observable.just(cache[word])
        }

        return dataSource.getData(word).doOnNext { cache[word] = it }
    }
}
