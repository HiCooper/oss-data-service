package com.berry.ossdataservice.common.util;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Berry_Cooper.
 * @date 2019/9/29 14:30
 * fileName：FileUtils
 * Use：
 */
public class FileUtils extends org.apache.commons.io.FileUtils {

    /**
     * 递归删除文件夹下所有空目录
     *
     * @param rootDir
     * @throws IOException
     */
    public static void recursiveRemoveEmptyDir(File rootDir) throws IOException {
        if (rootDir.isDirectory()) {
            Collection<File> files = org.apache.commons.io.FileUtils.listFiles(rootDir, null, true);
            if (files.size() == 0) {
                // 如果目录下没有文件，删除目录
                FileUtils.deleteDirectory(rootDir);
                return;
            }
            File[] childFiles = rootDir.listFiles();
            if (childFiles != null && childFiles.length > 0) {
                for (File file : childFiles) {
                    if (file.isDirectory()) {
                        recursiveRemoveEmptyDir(file);
                    }
                }
            }
        }
    }
}
