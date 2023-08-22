//package ru.fakelog.vkot.di.module
//
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ViewModelComponent
//import dagger.hilt.android.scopes.ViewModelScoped
//import ru.fakelog.vkot.domain.auth.repository.AuthRepository
//import ru.fakelog.vkot.ui.screen.auth.AuthViewModel
//
//@Module
//@InstallIn(ViewModelComponent::class)
//class ViewModelModule {
//
//    @Provides
//    fun provideAuthViewModel(): AuthViewModel {
//        return AuthViewModel()
//    }
//}