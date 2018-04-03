package com.lbx.domain;

public class RoleFunctionKey {
    private String roleId;

    private String functionId;

    public RoleFunctionKey(String roleId, String functionId) {
        this.roleId = roleId;
        this.functionId = functionId;
    }

    public RoleFunctionKey(String roleId) {
        this.roleId = roleId;
    }

    public RoleFunctionKey() {
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId == null ? null : functionId.trim();
    }
}