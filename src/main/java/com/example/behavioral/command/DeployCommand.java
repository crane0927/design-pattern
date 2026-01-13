package com.example.behavioral.command;

/**
 * 部署命令
 * 执行部署命令，撤销部署命令
 */
public class DeployCommand implements Command {

    private ReleaseExecutor releaseExecutor;

    public DeployCommand(ReleaseExecutor releaseExecutor) {
        this.releaseExecutor = releaseExecutor;
    }

    @Override
    public void execute() {
        releaseExecutor.deploy();
    }

    @Override
    public void undo() {
        releaseExecutor.rollback();
    }
}
