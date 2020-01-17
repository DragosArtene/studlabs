package com.proiect.colectiv.file_storage;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public interface FileStorage {


    String store(MultipartFile file, String key) throws IOException;


    InputStream retrieve(String key) throws Exception ;

}

