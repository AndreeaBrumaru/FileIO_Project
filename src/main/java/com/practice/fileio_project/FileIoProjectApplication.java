package com.practice.fileio_project;

import com.practice.fileio_project.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class FileIoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileIoProjectApplication.class, args);
    }

}
