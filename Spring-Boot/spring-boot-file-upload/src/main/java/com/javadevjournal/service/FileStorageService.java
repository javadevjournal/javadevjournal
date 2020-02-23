package com.javadevjournal.service;

import com.javadevjournal.data.FileMetaData;
import com.javadevjournal.exception.FileStorageException;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.List;

public interface FileStorageService {

    FileMetaData store(MultipartFile file) throws FileStorageException;
    List<Path> getAllFiles();
    FileMetaData getFile(String fileName) throws FileNotFoundException;
}
