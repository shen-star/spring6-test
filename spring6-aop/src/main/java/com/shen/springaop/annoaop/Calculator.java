package com.shen.springaop.annoaop;

/**
 * 计算器接口
 */
public interface Calculator {

    /**
     * 加
     *
     * @param i 整数
     * @param j 整数
     * @return 计算结果
     */
    int add(int i, int j);

    /**
     * 减
     *
     * @param i 整数
     * @param j 整数
     * @return 计算结果
     */
    int sub(int i, int j);

    /**
     * 乘
     *
     * @param i 整数
     * @param j 整数
     * @return 计算结果
     */
    int mul(int i, int j);

    /**
     * 除
     *
     * @param i 整数
     * @param j 整数
     * @return 计算结果
     */
    int div(int i, int j);
}
