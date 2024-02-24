package com.example.kisileruygulamasimvvm.di

import android.content.Context
import androidx.room.Room
import com.example.kisileruygulamasimvvm.data.repo.KisilerDaoRepository
import com.example.kisileruygulamasimvvm.room.KisilerDao
import com.example.kisileruygulamasimvvm.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKisilerDaoRepository(kdao : KisilerDao) : KisilerDaoRepository{
        return KisilerDaoRepository(kdao)
    }

    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context: Context) : KisilerDao{
        val vt = Room.databaseBuilder(context,Veritabani::class.java,"rehberY.sqlite")
            .createFromAsset("rehberY.sqlite").build()
        return vt.getKisilerDao()
    }


}