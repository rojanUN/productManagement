package com.ProductManagementSystem.ProductManagementSystem.controller;


import com.ProductManagementSystem.ProductManagementSystem.exception.ProductException;
import com.ProductManagementSystem.ProductManagementSystem.model.Response;
import com.ProductManagementSystem.ProductManagementSystem.payload.dowJones.PfaRequest;
import com.ProductManagementSystem.ProductManagementSystem.service.UploaderService;
import com.ProductManagementSystem.ProductManagementSystem.service.XmlUploadService;
import jakarta.xml.bind.JAXBException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
@RequiredArgsConstructor
public class SanctionController {

    private final XmlUploadService xmlUploadService;
    private final UploaderService uploaderService;

    @PostMapping("/consolidated-list")
    public ResponseEntity<Response> uploadConsolidatedList(@RequestParam("file") MultipartFile file) throws ProductException, JAXBException {
        return ResponseEntity.ok(xmlUploadService.uploadAndMapXml(file));
    }

    @PostMapping("/pfa-list")
    public ResponseEntity<PfaRequest> uploadPfaList(@RequestParam("file") MultipartFile file) throws ProductException, JAXBException {
        return ResponseEntity.ok(uploaderService.uploadAndMapXml(file));
    }
}
