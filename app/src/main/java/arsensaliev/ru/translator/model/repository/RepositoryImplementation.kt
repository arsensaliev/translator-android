package arsensaliev.ru.translator.model.repository

import arsensaliev.ru.translator.model.data.DataModel
import arsensaliev.ru.translator.model.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}
