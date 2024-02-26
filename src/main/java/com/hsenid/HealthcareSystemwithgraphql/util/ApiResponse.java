package com.hsenid.HealthcareSystemwithgraphql.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse {
    private int code;
    private String message;
    private Object data;
    private Object data2;
}
