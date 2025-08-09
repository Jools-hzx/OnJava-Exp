package com.jools.designpattern.flyweight.security;

/**
 * @author Jools He
 * @date 2025/7/29 21:28
 * @description: TODO
 */
public class AuthorizationFlyweight implements Flyweight {

    /**
     * 内部状态，安全实体
     */
    private String securityEntity;

    /**
     * 内部状态，权限
     */
    private String permit;

    public AuthorizationFlyweight(String state) {
        String[] ss = state.split(",");
        // 分割分别记录安全实体和权限
        securityEntity = ss[0];
        permit = ss[1];
    }

    public String getSecurityEntity() {
        return securityEntity;
    }

    public String getPermit() {
        return permit;
    }

    @Override
    public boolean match(String securityEntity, String permit) {
        if (this.securityEntity.equals(securityEntity) && this.permit.equals(permit)) {
            return true;
        }
        return false;
    }
}
