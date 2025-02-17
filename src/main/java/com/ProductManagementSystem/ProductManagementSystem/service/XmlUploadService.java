package com.ProductManagementSystem.ProductManagementSystem.service;

import com.ProductManagementSystem.ProductManagementSystem.builder.ResponseBuilder;
import com.ProductManagementSystem.ProductManagementSystem.entity.EntEntity;
import com.ProductManagementSystem.ProductManagementSystem.entity.IndividualEntity;
import com.ProductManagementSystem.ProductManagementSystem.exception.ProductException;
import com.ProductManagementSystem.ProductManagementSystem.model.Response;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.alQaida.ConsolidatedList;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.alQaida.EntityDto;
import com.ProductManagementSystem.ProductManagementSystem.payload.request.alQaida.IndividualDto;
import com.ProductManagementSystem.ProductManagementSystem.repository.EntEntityRepository;
import com.ProductManagementSystem.ProductManagementSystem.repository.IndividualEntityRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class XmlUploadService {

    private final IndividualEntityRepository individualEntityRepository;
    private final EntEntityRepository entEntityRepository;

    @Transactional
    public Response uploadAndMapXml(MultipartFile file) throws JAXBException, ProductException {
        try (InputStream inputStream = file.getInputStream()) {
            JAXBContext jaxbContext = JAXBContext.newInstance(ConsolidatedList.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            ConsolidatedList consolidatedList = (ConsolidatedList) unmarshaller.unmarshal(inputStream);
            saveXmlData(consolidatedList);

            return ResponseBuilder.buildSuccessResponse("Xml Upload Successful");
        } catch (IOException e) {
            throw new ProductException(e);
        }
    }


    private void saveXmlData(ConsolidatedList consolidatedList) {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(Long.class, UUID.class)
                .setProvider(request -> null);

        modelMapper.typeMap(IndividualDto.class, IndividualEntity.class)
                .addMappings(mapper -> mapper.skip(IndividualEntity::setDataId)); //skip mapping the dataId field, modelmapper tries to convert to UUID.

        List<IndividualDto> individuals = consolidatedList.getIndividuals();
        List<EntityDto> entities = consolidatedList.getEntities();

        List<IndividualEntity> individualEntities = individuals.stream()
                .map(e -> {
                    IndividualEntity individualEntity = modelMapper.map(e, IndividualEntity.class);
                    individualEntity.setDataId(e.getDataId());
                    if (individualEntity.getIndividualPlaceOfBirth() != null) {
                        individualEntity.getIndividualPlaceOfBirth().setIndividual(individualEntity);
                    }

                    if (individualEntity.getIndividualAliases() != null) {
                        individualEntity.getIndividualAliases().forEach(alias -> alias.setIndividual(individualEntity));
                    }

                    if (individualEntity.getIndividualDateOfBirth() != null) {
                        individualEntity.getIndividualDateOfBirth().forEach(dob -> dob.setIndividual(individualEntity));
                    }

                    return individualEntity;
                })
                .toList();

        List<EntEntity> entityList = entities.stream()
                .map(e -> {
                    EntEntity entity = modelMapper.map(e, EntEntity.class);
                    entity.setDataId(e.getDataId());
                    if (entity.getEntityAlias() != null) {
                        entity.getEntityAlias().setEntity(entity);
                    }

                    if (entity.getEntityAddress() != null) {
                        entity.getEntityAddress().forEach(ea -> ea.setEntity(entity));
                    }
                    return entity;
                })
                .toList();

        individualEntityRepository.saveAll(individualEntities);
        entEntityRepository.saveAll(entityList);
        ResponseBuilder.buildSuccessResponse("success");
    }

}

