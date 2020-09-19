package com.omerilhanli.flickrmvvmproject.asistive.scheduler

import io.reactivex.Scheduler

interface IScheduler {

    fun io(): Scheduler

    fun main(): Scheduler
}