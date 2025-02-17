package com.ProductManagementSystem.ProductManagementSystem.service;

import com.ProductManagementSystem.ProductManagementSystem.exception.ProductException;
import com.ProductManagementSystem.ProductManagementSystem.payload.dowJones.PfaRequest;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class UploaderService {

    @Transactional
    public PfaRequest uploadAndMapXml(MultipartFile file) throws JAXBException, ProductException {
        try {
            // Read the InputStream to a byte array
            byte[] xmlBytes = file.getBytes();

            // Create JAXB context and unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(PfaRequest.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Convert the byte array to an InputStream for unmarshalling
            try (InputStream inputStream = new ByteArrayInputStream(xmlBytes)) {
                return (PfaRequest) unmarshaller.unmarshal(inputStream);
            }
        } catch (IOException e) {
            throw new ProductException(e);
        }
    }


    private void saveXmlData(PfaRequest request) {

    }


}
