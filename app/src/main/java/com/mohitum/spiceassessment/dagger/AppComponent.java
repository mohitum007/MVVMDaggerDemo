package com.mohitum.spiceassessment.dagger;

import com.mohitum.spiceassessment.view.HomeActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, UtilsModule.class})
@Singleton
public interface AppComponent {

    void doInjection(HomeActivity homeActivity);

}
