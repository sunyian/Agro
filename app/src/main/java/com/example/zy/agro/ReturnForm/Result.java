package com.example.zy.agro.ReturnForm;

import java.io.Serializable;

public class Result implements Serializable {
    private Boolean success;

    private String message;

    private Object body;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
