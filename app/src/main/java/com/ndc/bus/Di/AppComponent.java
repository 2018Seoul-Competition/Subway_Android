package com.ndc.bus.Di;

import com.ndc.bus.Common.BaseApplication;
import com.ndc.bus.Database.BusDatabaseModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        ActivityModule.class,
        BusDatabaseModule.class
})
public interface AppComponent {
    void inject(BaseApplication app);
}