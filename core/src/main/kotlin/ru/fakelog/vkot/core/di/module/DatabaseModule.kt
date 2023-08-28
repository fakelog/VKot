package ru.fakelog.vkot.core.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import ru.fakelog.vkot.core.constants.DatabaseConstants
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.fakelog.vkot.core.data.data_source.local.db.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DatabaseConstants.DATABASE_NAME).build()
    }
}