package com.proiect.colectiv.features.file_storage.controller;

import com.proiect.colectiv.features.file_storage.service.AwsStorageImpl;
import com.proiect.colectiv.features.file_storage.service.FileStorageImpl;
import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api
@RestController
@RequestMapping("/files")
public class FileUploadController {

    private FileStorageImpl fileStorageImpl;
    private AwsStorageImpl awsStorage;

    public FileUploadController(FileStorageImpl fileStorageImpl, AwsStorageImpl awsStorage) {
        this.fileStorageImpl = fileStorageImpl;
        this.awsStorage = awsStorage;
    }

//    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
//    @RequestMapping(value="/aws",method = RequestMethod.POST)
//    public String uploadFileToAws(@RequestBody MultipartFile file) throws Exception{
//        try {
//            return awsStorage.store(file, file.getOriginalFilename());
//        } catch (Exception e) {
//            throw new Exception("File can not be uploaded! ");
//        }
//    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(method = RequestMethod.POST)
    public String uploadFileLocally(@RequestBody MultipartFile file) throws Exception{
        try {
            return fileStorageImpl.store(file, file.getOriginalFilename());
        } catch (Exception e) {
            throw new Exception("File can not be uploaded! ");
        }
    }
}
