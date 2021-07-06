package arsensaliev.ru.translator.application

import android.app.Application
import arsensaliev.ru.translator.di.application
import arsensaliev.ru.translator.di.mainScreen
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@TranslatorApp)
            modules(listOf(application, mainScreen))
        }
    }
}
