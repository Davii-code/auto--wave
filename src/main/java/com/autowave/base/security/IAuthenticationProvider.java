package com.autowave.base.security;

public interface IAuthenticationProvider {
    Credential getAuthentication(final String token);
}
