package com.practice.fileio_project.service;

import com.practice.fileio_project.controller.FileController;
import com.practice.fileio_project.exception.FileStorageException;
import com.practice.fileio_project.exception.MyFileNotFoundException;
import com.practice.fileio_project.model.FileModel;
import com.practice.fileio_project.repository.FileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;

@Service
public class FileService {

    private static final Logger logger = LoggerFactory.getLogger(FileService.class);

    @Autowired
    private FileRepository fileRepository;

    public String storeFile(MultipartFile file)
    {
        //Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try
        {
            //Check if the file's name contains invalid characters
            if(fileName.contains(".."))
            {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            //Copy file to database
            if(fileRepository.findByName(fileName) != null)
            {
                //TODO Create custom exception
                throw new RuntimeException();
            }
            FileModel newFile = new FileModel();
            newFile.setName(fileName);
            newFile.setFile(file.getBytes());
            newFile.setContentType(file.getContentType());
            fileRepository.save(newFile);

            return fileName;
        }
        catch (IOException e)
        {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", e);
        }
    }

    public FileModel loadFileAsResource(String fileName)
    {
        FileModel file = fileRepository.findByName(fileName);
        if(file == null)
        {
            throw new MyFileNotFoundException("File not found " + fileName);
        }
        return file;
    }
}
