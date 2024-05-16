package com.engenes.ecommerce.core.utilies;

import com.engenes.ecommerce.core.result.ResultData;

public class ResultHelper {
    public static <T> ResultData<T> created(T data) {
        return new ResultData<>(true,Msg.CREATED, "201", data);
    }

    public static <T> ResultData<T> validateError(T data) {
        return new ResultData<>(true,Msg.VALIDATE_ERROR, "400", data);
    }

    public static <T> ResultData<T> success(T data) {
        return new ResultData<>(true,Msg.OK, "200", data);
    }


}
