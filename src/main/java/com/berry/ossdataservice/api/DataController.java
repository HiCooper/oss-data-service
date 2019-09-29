package com.berry.ossdataservice.api;

import com.berry.ossdataservice.service.IShardSaveService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Berry_Cooper.
 * @date 2019-06-12 20:54
 * fileName：DataController
 * Use：
 */
@RestController
@RequestMapping("data")
public class DataController {

    private final IShardSaveService shardSaveService;

    public DataController(IShardSaveService shardSaveService) {
        this.shardSaveService = shardSaveService;
    }

    @PostMapping("write")
    public String writeShard(@RequestBody WriteShardMo mo) throws IOException {
        return this.shardSaveService.writeShard(mo.getFilePath(), mo.getBucketName(), mo.getFileName(), mo.getShardIndex(), mo.getData());
    }

    @GetMapping("read")
    public byte[] readShard(@RequestParam("path") String path) throws IOException {
        return this.shardSaveService.readShard(path);
    }

    @GetMapping("delete")
    public void deleteObj(@RequestParam("path") String path) throws IOException {
        this.shardSaveService.deleteObj(path);
    }
}
