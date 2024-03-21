package org.fugerit.java.demo.jwt;

import lombok.Getter;
import lombok.Setter;
import org.fugerit.java.emp.sm.service.ServiceResponse;

public class ConsumerDemoResponse extends ServiceResponse {

    @Getter @Setter
    private String result;

}
