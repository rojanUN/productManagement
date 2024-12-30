package com.ProductManagementSystem.ProductManagementSystem.model;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class Response {

    private boolean success;
    private String code;
    private String message;
    private Object data;

}
