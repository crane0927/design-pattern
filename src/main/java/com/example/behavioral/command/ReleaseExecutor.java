package com.example.behavioral.command;

public class ReleaseExecutor {


    public void gitClone() {
        System.out.println("拉取代码");
    }

    public void build() {
        System.out.println("编译代码");
    }

    public void deploy() {
        System.out.println("部署服务");
    }

    public void rollback() {
        System.out.println("回滚服务");
    }
}
