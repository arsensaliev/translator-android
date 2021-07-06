package arsensaliev.ru.translator.di

import arsensaliev.ru.translator.model.data.DataModel
import arsensaliev.ru.translator.model.datasource.RetrofitImplementation
import arsensaliev.ru.translator.model.datasource.RoomDataBaseImplementation
import arsensaliev.ru.translator.model.repository.Repository
import arsensaliev.ru.translator.model.repository.RepositoryImplementation
import arsensaliev.ru.translator.view.main.MainInteractor
import arsensaliev.ru.translator.view.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) {
        RepositoryImplementation(
            RetrofitImplementation()
        )
    }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) {
        RepositoryImplementation(
            RoomDataBaseImplementation()
        )
    }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    viewModel { MainViewModel(get()) }
}
