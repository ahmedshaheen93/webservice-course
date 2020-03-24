package com.shaheen;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/calc")
public class Calculation {
    @GET
    @Path("/{operation}")
    public String operation(@PathParam("operation") String operation, @QueryParam("num1") float num1, @QueryParam("num2") float num2) {
        float result = 0;
        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "sub":
                result = num1 - num2;
                break;
            case "mul":
                result = num1 * num2;
                break;
            case "div":
                if (num2 == 0) {
                    result = Float.NaN;
                } else {
                    result = num1 / num2;
                }
                break;
            default:
                result = Float.NaN;
        }
        return operation + " = " + result;
    }


}
