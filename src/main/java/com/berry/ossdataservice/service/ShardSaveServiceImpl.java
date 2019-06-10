package com.berry.ossdataservice.service;

import com.berry.rpc.IShardSaveService;
import org.apache.dubbo.config.annotation.Service;

import java.io.InputStream;

/**
 * Title ShardSaveServiceImpl
 * Description
 * Copyright (c) 2019
 * Company  上海思贤信息技术股份有限公司
 *
 * @author berry_cooper
 * @version 1.0
 * @date 2019/6/10 18:29
 */
@Service
public class ShardSaveServiceImpl implements IShardSaveService {

    @Override
    public String writeShard(InputStream inputStream) {
        return null;
    }

    @Override
    public InputStream readShard(String id) {
        return null;
    }
}
