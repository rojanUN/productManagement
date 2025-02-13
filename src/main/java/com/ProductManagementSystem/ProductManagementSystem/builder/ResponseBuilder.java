package com.ProductManagementSystem.ProductManagementSystem.builder;

import com.ProductManagementSystem.ProductManagementSystem.model.Response;
import com.ProductManagementSystem.ProductManagementSystem.utils.ExceptionUtil;
import lombok.Data;

@Data
public class ResponseBuilder {

    public ResponseBuilder() {}

    public static Response buildSuccessResponse(String message, Object data) {
        return Response.builder()
                .success(Boolean.TRUE)
                .code("0000")
                .data(data)
                .message(message)
                .build();
    }

    public static Response buildSuccessResponse(String message) {
        return Response.builder()
                .success(Boolean.TRUE)
                .code("0000")
                .message(message)
                .build();
    }

    public static Response buildSuccessResponse(Object data) {
        return Response.builder()
                .success(Boolean.TRUE)
                .code("0000")
                .data(data)
                .build();
    }

    public static Response buildUnknownFailResponse(Exception exception) {
        Response response = new Response();
        response.setSuccess(Boolean.FALSE);
        response.setCode("000000");
        response.setMessage(exception.getMessage());
        response.setData(ExceptionUtil.getStackTraceString(exception));
        return response;

    }

}
