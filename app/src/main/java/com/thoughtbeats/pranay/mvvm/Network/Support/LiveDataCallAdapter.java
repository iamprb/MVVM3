package com.thoughtbeats.pranay.mvvm.Network.Support;

import android.arch.lifecycle.LiveData;
import android.util.Log;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveDataCallAdapter<R> implements CallAdapter<R,LiveData<ApiResponse<R>>> {

    private static final String TAG = LiveDataCallAdapter.class.getSimpleName();

    private final Type responseType;

    public LiveDataCallAdapter(Type responseType) {
        this.responseType = responseType;
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @Override
    public LiveData<ApiResponse<R>> adapt(Call<R> call) {
        LiveData<ApiResponse<R>> liveData = new LiveData<ApiResponse<R>>() {
            AtomicBoolean started = new AtomicBoolean(false);

            @Override
            protected void onActive() {
                super.onActive();
                if (started.compareAndSet(false, true)) {
                    call.enqueue(new Callback<R>() {
                        @Override
                        public void onResponse(Call<R> call, Response<R> response) {
                            Log.d(TAG, "on Response " + response.toString());
                            postValue(new ApiResponse<>(response));
                        }

                        @Override
                        public void onFailure(Call<R> call, Throwable throwable) {
                            Log.d(TAG, "On Failure " + throwable.getMessage());
                            postValue(new ApiResponse<>(throwable));
                        }
                    });
                }
            }
        };
        Log.d(TAG, "Live Data State : " + liveData.hasObservers() + " Active Sate : " + liveData.hasActiveObservers());
        return liveData;
    }
}
