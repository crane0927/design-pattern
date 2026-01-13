package com.example.behavioral.command;

public class GitCloneCommand implements Command {

    private ReleaseExecutor releaseExecutor;

    public GitCloneCommand (ReleaseExecutor releaseExecutor){
        this.releaseExecutor = releaseExecutor;
    }

    @Override
    public void execute() {
        releaseExecutor.gitClone();
    }


}
