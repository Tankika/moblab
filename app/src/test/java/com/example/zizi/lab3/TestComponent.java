package com.example.zizi.lab3;

import com.example.zizi.lab3.interactor.InteractorModule;
import com.example.zizi.lab3.mock.MockNetworkModule;
import com.example.zizi.lab3.repository.TestRepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends MobSoftApplicationComponent {
}
