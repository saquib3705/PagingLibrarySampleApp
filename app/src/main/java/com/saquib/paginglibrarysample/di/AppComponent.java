package com.saquib.paginglibrarysample.di;


import com.saquib.paginglibrarysample.ui.PagingDemoAct;

import javax.inject.Singleton;

import dagger.Component;


@Component(modules = {UtilsModule.class})
@Singleton
public interface AppComponent {

    void doInjection(PagingDemoAct pagingDemoAct);

}
