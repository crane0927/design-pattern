package com.example.behavioral.responsibility2;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链管理器
 * 集中管理责任链的配置，符合开闭原则
 */
public class ChainManager {
    
    /**
     * 责任链配置：处理者的顺序列表
     */
    private static final List<Class<? extends Approver>> CHAIN_CONFIG = new ArrayList<>();
    
    static {
        // 初始化责任链配置：Manager -> Leader -> Director
        CHAIN_CONFIG.add(Manager.class);
        CHAIN_CONFIG.add(Leader.class);
        CHAIN_CONFIG.add(Director.class);
    }
    
    /**
     * 构建责任链
     * @return 责任链的第一个处理者
     */
    public static Approver buildChain() {
        if (CHAIN_CONFIG.isEmpty()) {
            return null;
        }
        
        Approver first = null;
        Approver previous = null;
        
        for (Class<? extends Approver> approverClass : CHAIN_CONFIG) {
            try {
                Approver current = approverClass.getDeclaredConstructor().newInstance();
                
                if (first == null) {
                    first = current; // 第一个处理者
                }
                
                if (previous != null) {
                    previous.setNext(current); // 设置下一个处理者
                }
                
                previous = current;
            } catch (Exception e) {
                throw new RuntimeException("无法创建处理者实例: " + approverClass.getName(), e);
            }
        }
        
        return first;
    }
    
    /**
     * 添加处理者到责任链（支持动态扩展）
     * @param approverClass 处理者类
     * @param position 插入位置（-1 表示末尾）
     */
    public static void addApprover(Class<? extends Approver> approverClass, int position) {
        if (position < 0 || position >= CHAIN_CONFIG.size()) {
            CHAIN_CONFIG.add(approverClass); // 添加到末尾
        } else {
            CHAIN_CONFIG.add(position, approverClass); // 插入到指定位置
        }
    }
    
    /**
     * 添加处理者到责任链末尾
     * @param approverClass 处理者类
     */
    public static void addApprover(Class<? extends Approver> approverClass) {
        addApprover(approverClass, -1);
    }
    
    /**
     * 移除处理者
     * @param approverClass 处理者类
     */
    public static void removeApprover(Class<? extends Approver> approverClass) {
        CHAIN_CONFIG.remove(approverClass);
    }
    
    /**
     * 清空责任链配置
     */
    public static void clearChain() {
        CHAIN_CONFIG.clear();
    }
    
    /**
     * 获取责任链配置信息
     * @return 责任链配置列表
     */
    public static List<Class<? extends Approver>> getChainConfig() {
        return new ArrayList<>(CHAIN_CONFIG);
    }
}
