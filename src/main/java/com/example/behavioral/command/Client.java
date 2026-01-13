package com.example.behavioral.command;

public class Client {

    public static void main(String[] args) {
        ReleaseExecutor releaseExecutor = new ReleaseExecutor();
        Command gitCloneCommand = new GitCloneCommand(releaseExecutor);
        Command buildCommand = new BuildCommand(releaseExecutor);
        Command deployCommand = new DeployCommand(releaseExecutor);
        ReleasePipeline releasePipeline = new ReleasePipeline();
        releasePipeline.addCommand(gitCloneCommand);
        releasePipeline.addCommand(buildCommand);
        releasePipeline.addCommand(deployCommand);
        try {
            releasePipeline.execute();
        } catch (Exception e) {
            releasePipeline.undo();
        }
    }

}
