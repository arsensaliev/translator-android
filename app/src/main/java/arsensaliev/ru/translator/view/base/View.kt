package arsensaliev.ru.translator.view.base

import arsensaliev.ru.translator.model.data.AppState

interface View {

    fun renderData(appState: AppState)

}
