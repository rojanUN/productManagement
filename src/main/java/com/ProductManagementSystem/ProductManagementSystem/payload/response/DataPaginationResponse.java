package com.ProductManagementSystem.ProductManagementSystem.payload.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DataPaginationResponse {

    private long totalElementCount;
    private Object result;
}
