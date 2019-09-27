package com.berry.ossdataservice.service;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Berry_Cooper.
 * @date 2019-06-12 20:47
 * fileName：IShardSaveService
 * Use：
 */
public interface IShardSaveService {

    /**
     * 写数据分片
     *
     * @param filePath   相对存储空间的位置
     * @param bucketName bucketName
     * @param fileName   文件名
     * @param shardIndex 分片索引
     * @param data       数据
     * @return 分片路径及ip等信息
     * @throws IOException
     */
    String writeShard(String filePath, String bucketName, String fileName, Integer shardIndex, byte[] data) throws IOException;

    /**
     * 读数据分片
     *
     * @param path 分片路径
     * @return 数据
     * @throws IOException
     */
    byte[] readShard(String path) throws IOException;
}
