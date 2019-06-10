package com.berry.ossdataservice.service;

import com.berry.rpc.IShardSaveService;
import org.apache.dubbo.config.annotation.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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

    private Integer count = 0;

    @Override
    public String writeShard(byte[] bytes) {
        try {
            System.out.println("wrote " + count);
            OutputStream out = new FileOutputStream(new File("./", "test.png" + "." + count));
            count++;
            out.write(bytes);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @Override
    public byte[] readShard(String id) {
        return null;
    }
}
