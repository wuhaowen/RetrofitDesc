package com.wuhaowen.desc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/**
 * 利用adapter获取DESC Annotation 来输出接口描述
 */
public class ApiDescCallAdapterFactory extends CallAdapter.Factory {
    /**
     * 接口描述回调， 可在回调里面输出logcat,或记录文件日志
     */
    public interface DescCallback {
        /**
         * 输出接口描述
         * @param desc 接口描述
         */
        void desc(String desc);
    }

    private DescCallback descCallback;

    private ApiDescCallAdapterFactory(DescCallback descCallback) {
        this.descCallback = descCallback;
    }

    public static CallAdapter.Factory create(@NonNull DescCallback descCallback) {
        return new ApiDescCallAdapterFactory(descCallback);
    }

    @Nullable
    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        for (Annotation annotation : annotations) {
            if (annotation.annotationType() == DESC.class) {
                descCallback.desc(((DESC) annotation).value());
                break;
            }
        }
        return null;
    }
}
