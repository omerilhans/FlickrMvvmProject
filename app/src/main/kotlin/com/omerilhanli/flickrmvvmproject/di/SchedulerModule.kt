package com.omerilhanli.flickrmvvmproject.di

import com.omerilhanli.flickrmvvmproject.asistive.scheduler.IScheduler
import com.omerilhanli.flickrmvvmproject.asistive.scheduler.SchedulerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class SchedulerModule {

    @Provides
    @Singleton
    fun provideScheduler(schedulerImpl: SchedulerImpl) : IScheduler {
        return schedulerImpl
    }
}