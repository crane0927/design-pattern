package com.example.behavioral.command;

/**
 * 命令接口
 */
public interface Command {

    void execute(); // 执行命令

    default void undo(){}// 撤销命令（可选）

}
