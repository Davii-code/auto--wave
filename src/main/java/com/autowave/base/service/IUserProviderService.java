package com.autowave.base.service;

import com.autowave.base.dto.CredentialDTO;

public interface IUserProviderService {
    CredentialDTO getCredentialByLogin(String username);
    CredentialDTO getCredentialByEmail(String email);
    void recordLog(CredentialDTO credentialDTO, String action);
    void changePassword(String email, String password);
}
