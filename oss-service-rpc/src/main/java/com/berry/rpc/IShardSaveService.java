package com.berry.rpc;

import java.io.InputStream;

/**
 * Title IShardSaveService
 * Description
 * Copyright (c) 2019
 * Company  上海思贤信息技术股份有限公司
 *
 * @author berry_cooper
 * @version 1.0
 * @date 2019/6/10 14:02
 */
public interface IShardSaveService {

    String writeShard(InputStream inputStream) ;

    InputStream readShard(String id) ;
}
