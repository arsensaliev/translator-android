package arsensaliev.ru.translator.view.main

import arsensaliev.ru.translator.model.data.AppState
import arsensaliev.ru.translator.model.data.DataModel
import arsensaliev.ru.translator.model.repository.Repository
import arsensaliev.ru.translator.viewmodel.Interactor

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}
