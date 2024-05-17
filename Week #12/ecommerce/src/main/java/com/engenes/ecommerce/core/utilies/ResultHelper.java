package com.engenes.ecommerce.core.utilies;

import com.engenes.ecommerce.core.result.Result;
import com.engenes.ecommerce.core.result.ResultData;
import com.engenes.ecommerce.dto.response.CursorResponse;
import com.engenes.ecommerce.dto.response.category.CategoryResponse;
import org.springframework.data.domain.Page;

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

    public static Result notFound(String msg) {
        return new Result(true, msg, "404");
    }

    public static <T> ResultData<CursorResponse<T>> cursor(Page<T> pageData) {
        CursorResponse<T> cursor = new CursorResponse<>();
        cursor.setItems(pageData.getContent());
        cursor.setPageSize(pageData.getSize());
        cursor.setPageNumber(pageData.getNumber());
        cursor.setTotalElements(pageData.getTotalElements());

        return ResultHelper.success(cursor);
    }

}
