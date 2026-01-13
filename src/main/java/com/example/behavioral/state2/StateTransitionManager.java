package com.example.behavioral.state2;

import java.util.HashMap;
import java.util.Map;

/**
 * 状态转换管理器
 * 集中管理状态转换逻辑，符合开闭原则
 */
public class StateTransitionManager {
    
    /**
     * 状态转换表：当前状态 -> 下一个状态
     */
    private static final Map<Class<? extends OrderState>, Class<? extends OrderState>> TRANSITION_MAP = new HashMap<>();
    
    static {
        // 初始化状态转换规则
        TRANSITION_MAP.put(PendingPayState.class, PaidState.class);
        TRANSITION_MAP.put(PaidState.class, ShippedState.class);
        // ShippedState 是最终状态，不需要转换
    }
    
    /**
     * 获取下一个状态
     * @param currentStateClass 当前状态类
     * @return 下一个状态实例，如果是最终状态则返回 null
     */
    public static OrderState getNextState(Class<? extends OrderState> currentStateClass) {
        Class<? extends OrderState> nextStateClass = TRANSITION_MAP.get(currentStateClass);
        if (nextStateClass == null) {
            return null; // 最终状态
        }
        
        try {
            return nextStateClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("无法创建状态实例: " + nextStateClass.getName(), e);
        }
    }
    
    /**
     * 添加状态转换规则（支持动态扩展）
     * @param fromState 当前状态类
     * @param toState 下一个状态类
     */
    public static void addTransition(Class<? extends OrderState> fromState, 
                                     Class<? extends OrderState> toState) {
        TRANSITION_MAP.put(fromState, toState);
    }
    
    /**
     * 检查是否有下一个状态
     * @param currentStateClass 当前状态类
     * @return 是否有下一个状态
     */
    public static boolean hasNextState(Class<? extends OrderState> currentStateClass) {
        return TRANSITION_MAP.containsKey(currentStateClass);
    }
}
