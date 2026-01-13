package com.example.behavioral.command;
/**
 * 构建命令
 * 执行构建命令，撤销构建命令
 */
public class BuildCommand implements Command {

    private ReleaseExecutor releaseExecutor;

    public BuildCommand(ReleaseExecutor releaseExecutor) {
        this.releaseExecutor = releaseExecutor;
    }

    @Override
    public void execute() {
        releaseExecutor.build();
    }


}
