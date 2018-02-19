package com.dantsov.sample.docker_api.service;

import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

//@GrpcService
//@Service
public class UserServiceRpc extends UserServiceGrpc.UserServiceImplBase  {

    @Override
    public void getNewAsyncUser(UserRequest request,
                           StreamObserver<UserResponse> responseObserver) {
        UserResponse response = UserResponse.newBuilder()
                .setName("Async user")
                .setAge(25)
                .build();
        try {
            Thread.sleep(request.getTimout());
        } catch (Exception ex) {
            responseObserver.onError(ex);
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getNewSyncUser(UserRequest request,
                                StreamObserver<UserResponse> responseObserver) {
        UserResponse response = UserResponse.newBuilder()
                .setName("Sync user")
                .setAge(35)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    }
