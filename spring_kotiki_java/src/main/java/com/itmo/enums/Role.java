package com.itmo.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    ADMIN(Set.of(Permission.READ,Permission.WRITE)),
    USER(Set.of(Permission.READ));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
    public Set<SimpleGrantedAuthority> getAuthority() {
        return  getPermissions().stream().map((pr -> new SimpleGrantedAuthority((pr.getPermission())))).collect(Collectors.toSet());
    }
}
