package com.example.behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class ReleasePipeline {

    private final List<Command> commands = new ArrayList<Command>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    public void undo() {
        for (Command command : commands) {
            command.undo();
        }
    }
}
