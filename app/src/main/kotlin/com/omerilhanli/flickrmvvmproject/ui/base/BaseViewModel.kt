package com.omerilhanli.flickrmvvmproject.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omerilhanli.flickrmvvmproject.asistive.scheduler.IScheduler
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

open class BaseViewModel<Navigator> constructor(
    private val scheduler: IScheduler? = null
) : ViewModel() {

    val isLoadingLiveData: MutableLiveData<Boolean> = MutableLiveData(false)

    private val compositeDisposable = CompositeDisposable()

    private var mNavigator: WeakReference<Navigator>? = null

    var navigator: Navigator?
        get() = mNavigator?.get()
        set(navigator) {
            this.mNavigator = if (navigator != null) WeakReference(navigator) else null
        }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    protected fun <Response> Observable<Response>.completion(subscribing: (param: Response) -> Unit) {
        val navigator = navigator as BaseNavigator
        val disposable =
            observeOn(scheduler?.main())
                .subscribeOn(scheduler?.io())
                .subscribe(
                    { response ->
                        subscribing(response)
                    }, { ex ->
                        setIsLoading(false)
                        navigator.handleError(ex)
                    }, {
                        setIsLoading(false) // loading animasyonu gizlenir.
                    }, {
                        setIsLoading(true) // loading animasyonu gösterilir.
                    })

        compositeDisposable.add(disposable)
    }

    private fun setIsLoading(isLoading: Boolean) {
        this.isLoadingLiveData.value = isLoading
    }
}