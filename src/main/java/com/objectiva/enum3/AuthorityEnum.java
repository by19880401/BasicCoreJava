package com.objectiva.enum3;

public enum AuthorityEnum {
    ADMIN("admin"), USER("user"), GUEST("guest");

    private String authority;

    AuthorityEnum(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }
}
