package com.inspur.service;

import com.inspur.utils.FileCopyUtils;
import com.inspur.utils.PropUtils;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Slf4j
public class Server {

    public void run(){
        String target = PropUtils.getProperties("file.target");
        String origin = PropUtils.getProperties("file.origin");
        File originDirectory = new File(origin);
        File targetDirectory = new File(target);
        if (!originDirectory.isDirectory()) {
            log.error(origin + "is not a Directory!!!");
            return;
        }

        if (!targetDirectory.exists()) {
            try {
                log.info(targetDirectory.getCanonicalPath() + " isn't exists,so create it");
                targetDirectory.mkdirs();
            } catch (IOException e) {
                log.error(e.getMessage());
            }

        }
        ArrayList<File> filterFiles = new ArrayList<>();

        filterFiles.clear();
        Set<String> set = new HashSet<>();
        Arrays.stream(targetDirectory.listFiles()).forEach(file -> {
            if(file.getName().endsWith(".jpg")) {
                String str = file.getName().substring(0, file.getName().length() - 4);
                set.add(file.getName().substring(0, file.getName().length() - 4));
            }
        });
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        log.info("The width and the height of the screen are:"+screenSize.getWidth()+"x"+screenSize.getHeight());
        Arrays.stream(originDirectory.listFiles()).forEach(file -> {
            BufferedImage bufferedImg = null;
            try {
                bufferedImg = ImageIO.read(file);
            } catch (IOException e) {
                log.error(file.getName()+" can't read ");
            }
            if (bufferedImg != null) {
                int imgWidth = bufferedImg.getWidth();
                int imgHeight = bufferedImg.getHeight();
                if (!set.contains(file.getName()) && imgWidth >= screenSize.getWidth() && imgHeight >= screenSize.getHeight()) {
                    filterFiles.add(file);
                }
            }
        });

        for (File fromFile : filterFiles) {
                File toFile = new File(targetDirectory + File.separator + fromFile.getName() + ".jpg");
                if (FileCopyUtils.path2Path(fromFile.toPath(), toFile.toPath())) {
                    log.info("copy size: " + fromFile.length() / 1024 + " success");
                } else {
                    log.info("copy size: " + fromFile.length() / 1024 + " failure");
                }
        }
    }
}
