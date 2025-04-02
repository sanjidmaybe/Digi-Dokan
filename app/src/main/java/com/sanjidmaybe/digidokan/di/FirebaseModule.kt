package com.sanjidmaybe.digidokan.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.sanjidmaybe.digidokan.data.repositories.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

class FirebaseModule {

    @Provides
    @Singleton
    fun providesFirebaseAuth() : FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun providesFirebaseFirestoreDB() : FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun providesAuthRepository(sAuth: FirebaseAuth, db : FirebaseFirestore) : AuthRepository {
        return AuthRepository(sAuth, db)
    }
}