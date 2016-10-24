package com.sxt.base.common;
/**
 * @author jl
 */
public class SimpleResult extends AbstractResult {
    private String message;

    public SimpleResult() {
    }

    public SimpleResult(boolean success) {
        super.setSuccess(success);
    }

    public SimpleResult(boolean success, String message) {
        super.setSuccess(success);
        this.setMessage(message);
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
