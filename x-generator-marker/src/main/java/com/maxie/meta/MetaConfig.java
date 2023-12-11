package com.maxie.meta;


import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

import java.io.File;

/**
 * *考虑到Meta元信息只需要加载一次，这里使用单例模式获取Meta对象
 *
 * @author: xujian
 * @create: 2023-12-10 19:03
 **/
public class MetaConfig {

    private static volatile Meta meta;

    public static Meta getInstance(){
        if(meta == null){
            synchronized (MetaConfig.class){
                if(meta == null){
                    meta = init();
                }
            }
        }
        return meta;
    }

    public static Meta init(){
        //加载meta.json
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        //将Json对象 --》 Meta对象
        Meta meta = JSONUtil.toBean(metaJson, Meta.class);
        // todo 检验和处理用户参数默认值

        return meta;
    }
}
