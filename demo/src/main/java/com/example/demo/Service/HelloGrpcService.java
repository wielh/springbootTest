package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.message.GreeterGrpc;
import com.example.demo.message.HelloReply;
import com.example.demo.message.HelloRequest;

import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class HelloGrpcService {

    @GrpcClient("greeterService")
    private GreeterGrpc.GreeterBlockingStub greeterStub;

    public String sayHello(String name) {
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply reply = greeterStub.sayHello(request);
        return reply.getMessage();
    }
    
}
