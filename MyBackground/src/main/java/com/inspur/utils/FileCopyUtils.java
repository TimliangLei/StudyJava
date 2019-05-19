package com.inspur.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.LinkOption.NOFOLLOW_LINKS;

@Slf4j
public final class FileCopyUtils {

    public static boolean path2Path(Path copy_from, Path copy_to){
        log.info("Using Files.copy (Path to Path) method ...");
        try {
            long startTime = System.nanoTime();

            Files.copy(copy_from, copy_to, NOFOLLOW_LINKS);

            long elapsedTime = System.nanoTime() - startTime;
            log.info("Elapsed Time is " + (elapsedTime / 1000000000.0) + " seconds");
            return true;
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return false;
    }
}
