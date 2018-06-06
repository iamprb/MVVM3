package com.thoughtbeats.pranay.mvvm.repository.mainRepository;

import com.thoughtbeats.pranay.mvvm.Network.NetworkService;
import com.thoughtbeats.pranay.mvvm.helper.AppExecutors;

import javax.inject.Inject;

public class MainRepositoryImpl implements MainRepository {

    private final NetworkService networkService;
    private final AppExecutors appExecutors;

    @Inject
    MainRepositoryImpl(AppExecutors appExecutors, NetworkService networkService){
        this.appExecutors=appExecutors;
        this.networkService=networkService;
    }
}
