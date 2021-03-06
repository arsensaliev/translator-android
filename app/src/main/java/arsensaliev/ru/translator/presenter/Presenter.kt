package arsensaliev.ru.translator.presenter

import arsensaliev.ru.translator.model.data.AppState
import arsensaliev.ru.translator.view.base.View

interface Presenter<T : AppState, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}
