package com.twitter.challenge.di;

import com.twitter.challenge.MyViewModel;
import com.twitter.challenge.Repository;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {ApiModule.class, RepositoryModule.class})
public interface MyComponent {

    void injectRetrofit(Repository repository);

    void injectRepository(MyViewModel myViewModel);
}
