package com.dantsov.sample.docker_api.service;

import org.springframework.stereotype.Service;

@Service
public class InternalUserService {

    public InternalUser getUser() {
        return new InternalUser("ServiceA", 25);

    }
}
