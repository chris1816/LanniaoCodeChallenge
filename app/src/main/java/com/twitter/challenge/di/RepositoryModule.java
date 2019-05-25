package com.twitter.challenge.di;

import com.twitter.challenge.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class RepositoryModule {

    @Singleton
    @Provides
    Repository getRepositoryInstance() {
        return new Repository();
    }
}
