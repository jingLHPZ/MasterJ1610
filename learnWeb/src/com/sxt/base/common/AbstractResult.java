package com.sxt.base.common;
/**
 * @author jl
 */
public abstract class AbstractResult {
    private boolean success = false;

    public AbstractResult() {
    }

    public AbstractResult(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
