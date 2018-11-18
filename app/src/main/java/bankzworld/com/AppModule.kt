package bankzworld.com

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: App) {
    @Provides
    @Singleton
    fun provideApp() = app

    @Provides
    @Singleton
    fun provideSharedPrefs(): SharedPreferences {
        return app.getSharedPreferences("text", Context.MODE_PRIVATE)
    }
}