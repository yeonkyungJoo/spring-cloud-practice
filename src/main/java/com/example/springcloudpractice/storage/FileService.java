package com.example.springcloudpractice.storage;

import com.example.springcloudpractice.event.FileEvent;
import com.example.springcloudpractice.event.FileEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class FileService {

    @Autowired
    FileEventPublisher fileEventPublisher;

    public void fileUpload(Map<String, Object> data) {

        try {
            log.info("파일 복사 완료");
            log.info("DB 파일 메타 정보 저장 완료");
            fileEventPublisher.notify(FileEvent.toCompleteEvent(data));

        } catch (Exception e) {
            log.info("실패");
            fileEventPublisher.notify(FileEvent.toErrorEvent(data));
        }

    }

}
