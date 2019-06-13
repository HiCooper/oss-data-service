package com.berry.ossdataservice.api;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Title WriteShardResponse
 * Description
 * Copyright (c) 2019
 * Company  上海思贤信息技术股份有限公司
 *
 * @author berry_cooper
 * @version 1.0
 * @date 2019/6/13 12:54
 */
@Data
@Accessors(chain = true)
public class WriteShardResponse {

    private String ip;
    private String path;
}
