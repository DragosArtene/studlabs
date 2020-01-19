package com.proiect.colectiv.features.file_storage.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class FileStorageImpl implements FileStorage {


    private final Logger logger = LoggerFactory.getLogger(FileStorageImpl.class);

    @Value("${spring.file-service.path}")
    private String path;

    @Override
    public String store(MultipartFile file, String uri) throws IOException {
        File dest = new File( path + File.separator + uri);

        logger.debug("Destination for file: " + dest.getAbsolutePath());

        File parentFolder = dest.getParentFile();

        logger.debug("Parent folder for file: " + parentFolder.getAbsolutePath());
        if (parentFolder != null && !parentFolder.exists()) {
            parentFolder.mkdirs();
        }

        file.transferTo(dest);
        return dest.getAbsolutePath();
    }

    @Override
    public InputStream retrieve(String key) throws Exception {
        File file = new File(key);
        if (file.exists()) {
            try {
                return new FileInputStream(file);
            } catch (FileNotFoundException e) {
                throw new Exception("Unable to create FileInputStream  " );
            }
        } else {
            throw new Exception("Invalid key provided: ");
        }
    }



}
