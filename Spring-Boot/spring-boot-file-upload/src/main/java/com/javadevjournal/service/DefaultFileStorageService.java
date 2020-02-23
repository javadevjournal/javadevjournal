package com.javadevjournal.service;

import com.javadevjournal.data.FileMetaData;
import com.javadevjournal.exception.FileStorageException;
import com.javadevjournal.utils.UploadFileProperties;
import org.apache.tika.detect.Detector;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AutoDetectParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service("fileStorageService")
public class DefaultFileStorageService implements FileStorageService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultFileStorageService.class);

    @Autowired
    UploadFileProperties uploadFileProperties;

    @Override
    public FileMetaData store(MultipartFile file) throws FileStorageException {

        //Normalize the path by suppressing sequences like "path/.." and inner simple dots.
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            // we can add additional file validation to discard invalid files
            Path uploadDir = getUploadDirLocation().resolve(fileName);

            //copy the file to the upload directory,it will replace any file with same name.
            Files.copy(file.getInputStream(), uploadDir, StandardCopyOption.REPLACE_EXISTING);

            FileMetaData fileData = new FileMetaData();
            fileData.setFileName(fileName);
            fileData.setSize(file.getSize());
            fileData.setMime(file.getContentType());
            return fileData;

        } catch (IOException e) {
            LOG.error("unable to cpy file to the target location {}", e);
            throw new FileStorageException("Unable to store file " + fileName);
        }
    }

    /**
     * Read all files and return as list of @FileMetaData
     * @return
     */
    @Override
    public List<Path> getAllFiles() {
        return null;
    }

    /**
     * Method to return the file as @Resource for the download.It read the file from the file system
     * and return it as @Resource
     * @param fileName
     * @return FileMetaData
     * @throws FileNotFoundException
     */
    @Override
    public FileMetaData getFile(String fileName) throws FileNotFoundException {
        Path path = getUploadDirLocation().resolve(fileName).normalize();

        try {
            Resource resource = new UrlResource(path.toUri());

            if(resource.exists()){
                Metadata metadata = getFileMetaDataInfo(resource);
                FileMetaData fileMetaData = new FileMetaData();
                fileMetaData.setResource(resource);
                fileMetaData.setFileName(fileName);
                fileMetaData.setSize(metadata.size());
                fileMetaData.setMime(metadata.get(Metadata.CONTENT_TYPE));
                return fileMetaData;
            }
            else{
                throw new FileNotFoundException("Not able to find file");
            }
        } catch (MalformedURLException e) {
            throw new FileNotFoundException("Not able to find file");
        }
    }

    /**
     * Provides the upload directory location based on the application.properties configurations
     *
     * @return Path
     */
    private Path getUploadDirLocation() {
        return Paths.get(uploadFileProperties.getUploadDir()).toAbsolutePath().normalize();
    }

    /**
     * Helper method to get the file meta-data using Apache Tikka corre library.JDK also provide
     * way to read meta-data information but it's very limited and have lot of issues.
     * @param resource
     * @return Metadata
     */
    private Metadata getFileMetaDataInfo(Resource resource){
        AutoDetectParser parser = new AutoDetectParser();
        Detector detector = parser.getDetector();
        Metadata metadata = new Metadata();
        try {
            metadata.set(Metadata.RESOURCE_NAME_KEY, resource.getFile().getName());
            TikaInputStream stream = TikaInputStream.get(resource.getInputStream());
            MediaType mediaType = detector.detect(stream,metadata);
            metadata.set(Metadata.CONTENT_TYPE, mediaType.toString());
        } catch (IOException e) {
            e.printStackTrace();
            //fallback to default content type
            metadata.set(Metadata.CONTENT_TYPE, "application/octet-stream");

        }
        return metadata;
    }
}
