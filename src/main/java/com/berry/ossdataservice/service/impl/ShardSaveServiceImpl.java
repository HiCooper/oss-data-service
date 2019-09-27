package com.berry.ossdataservice.service.impl;

import com.berry.ossdataservice.config.GlobalProperties;
import com.berry.ossdataservice.service.IShardSaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GlobalProperties globalProperties;

    @Override
    public String writeShard(String filePath, String bucketName, String fileName, Integer shardIndex, byte[] data) throws IOException {
        File file = new File(globalProperties.getDataPath(), bucketName + filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fullFilePath;
        if (StringUtils.isEmpty(shardIndex)) {
            // 单机模式下 没有 shardIndex 参数
            fullFilePath = file.getPath() + "/" + fileName;
        } else {
            fullFilePath = file.getPath() + "/" + fileName + "." + shardIndex;
        }
        FileOutputStream outputStream = new FileOutputStream(fullFilePath);
        outputStream.write(data);
        outputStream.close();
        return fullFilePath;
    }

    @Override
    public byte[] readShard(String path) throws IOException {
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            FileInputStream in = new FileInputStream(file);
            int size = in.available();
            byte[] result = new byte[size];
            int read = in.read(result);
            if (read != size) {
                logger.error("数据不完整:{}", path);
                return null;
            }
            in.close();
            return result;
        }
        logger.error("数据丢失：{}", path);
        return null;
    }
}
