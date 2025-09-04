package com.autowave.base.security.impl;

import com.autowave.base.security.Credential;
import com.autowave.base.security.ICredentialProvider;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CredentialProvider implements ICredentialProvider {

    public static CredentialProvider newInstance() {
        return new CredentialProvider();
    }

    @Override
    public Credential getCurrentInstance() {
        return (Credential) SecurityContextHolder.getContext().getAuthentication().getCredentials();
    }
}
