package com.maxie.model;

import lombok.Data;

/**
 * 接收要传递给模板的参数
 *
 * @author: xujian
 * @create: 2023-12-05 10:02
 **/
@Data
public class MainTemplateConfig {
    //三个参数
    // 建议给所有字符串一个默认值，
    /**
     * 作者
     */
    private String author = "maxie";

    /**
     * 输出文本
     */
    private String outputText = "good job ~~";

    /**
     * 是否循环
     */
    private boolean loop = false;
}
