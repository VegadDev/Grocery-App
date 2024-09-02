package com.dev.groceryapp.di

import android.content.Context
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.dev.groceryapp.App
import com.dev.groceryapp.data.MainDatabase
import com.dev.groceryapp.data.dao.DataDao
import com.dev.groceryapp.repository.DataRepository
import com.dev.groceryapp.repository.DataRepositoryImpl
import com.dev.groceryapp.repository.NetworkRepository
import com.dev.groceryapp.repository.NetworkRepositoryImpl
import com.dev.groceryapp.ui.navigation.Navigator
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

  @Singleton
  @Provides
  fun provideApp(): App {
    return App()
  }

  @Singleton
  @Provides
  fun provideGsonConverterFactory(): GsonConverterFactory {
    return GsonConverterFactory.create(GsonBuilder().setLenient().create())
  }

  @Singleton
  @Provides
  fun provideRetrofitClient(): OkHttpClient {
    return OkHttpClient.Builder().addInterceptor(
      HttpLoggingInterceptor().setLevel(
        HttpLoggingInterceptor.Level.BODY
      )
    ).build()
  }

  @Singleton
  @Provides
  @Named("Backend")
  fun provideRetrofit(client: OkHttpClient, gsonConverterFactory: GsonConverterFactory): Retrofit {
    return Retrofit.Builder()
      .baseUrl("https://apis.codedbypatel.com/msl/v1/")
      .addConverterFactory(gsonConverterFactory)
      .client(client)
      .build()
  }

  @Singleton
  @Provides
  fun provideDataDao( @ApplicationContext context: Context): DataDao {
    return MainDatabase.getInstance(context, "local.db").dataDao()
  }


  @Singleton
  @Provides
  fun provideNetworkRepository(networkRepositoryImpl: NetworkRepositoryImpl): NetworkRepository {
    return networkRepositoryImpl
  }

  @Singleton
  @Provides
  fun provideDataRepository(dataRepository: DataRepositoryImpl): DataRepository {
    return dataRepository
  }

  @Singleton
  @Provides
  fun provideNavigator(): Navigator {
    return Navigator()
  }

}