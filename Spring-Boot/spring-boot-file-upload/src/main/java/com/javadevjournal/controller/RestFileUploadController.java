package com.javadevjournal.controller;

import com.javadevjournal.data.FileMetaData;
import com.javadevjournal.exception.FileStorageException;
import com.javadevjournal.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api/v1")
public class RestFileUploadController extends PageController {

    @Autowired
    FileStorageService fileStorageService;

    /**
     * REST controller to allow file uploading for our REST API
     * @param file
     * @param redirectAttributes
     * @param model
     * @return FileMetaData
     * @throws FileStorageException
     */
    @PostMapping("/upload-file")
    @ResponseBody
    public FileMetaData uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, Model model) throws FileStorageException {
        FileMetaData data= fileStorageService.store(file);
        data.setUrl(fileDownloadUrl(data.getFileName(),"/api/v1/media/download/"));
        return data;
    }

    /**
     * Rest Controller method for file download feature.
     * @param fileName
     * @return ResponseEntity
     * @throws FileNotFoundException
     */
    @GetMapping("/media/download/{fileName:.+}")
    public  ResponseEntity<Resource> downloadFile(@PathVariable String fileName) throws FileNotFoundException {
         FileMetaData fileData= fileStorageService.getFile(fileName);
        return  ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + fileName + "\"")
                .contentType(MediaType.parseMediaType(fileData.getMime()))
                .body(fileData.getResource());
    }
}
