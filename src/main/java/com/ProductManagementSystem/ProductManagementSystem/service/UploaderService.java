package com.ProductManagementSystem.ProductManagementSystem.service;

import com.ProductManagementSystem.ProductManagementSystem.PersonEntityMapper;
import com.ProductManagementSystem.ProductManagementSystem.builder.ResponseBuilder;
import com.ProductManagementSystem.ProductManagementSystem.entity.dj.CountryDetailEntity;
import com.ProductManagementSystem.ProductManagementSystem.entity.dj.DateDetailEntity;
import com.ProductManagementSystem.ProductManagementSystem.entity.dj.DateValueEntity;
import com.ProductManagementSystem.ProductManagementSystem.entity.dj.DowEntEntity;
import com.ProductManagementSystem.ProductManagementSystem.entity.dj.NameDetailEntity;
import com.ProductManagementSystem.ProductManagementSystem.entity.dj.NameValueEntity;
import com.ProductManagementSystem.ProductManagementSystem.entity.dj.PersonEntity;
import com.ProductManagementSystem.ProductManagementSystem.exception.ProductException;
import com.ProductManagementSystem.ProductManagementSystem.mapper.DowEntEntityMapper;
import com.ProductManagementSystem.ProductManagementSystem.model.Response;
import com.ProductManagementSystem.ProductManagementSystem.payload.dowJones.CountryDetail;
import com.ProductManagementSystem.ProductManagementSystem.payload.dowJones.CountryValue;
import com.ProductManagementSystem.ProductManagementSystem.payload.dowJones.Date;
import com.ProductManagementSystem.ProductManagementSystem.payload.dowJones.DateValue;
import com.ProductManagementSystem.ProductManagementSystem.payload.dowJones.Entity;
import com.ProductManagementSystem.ProductManagementSystem.payload.dowJones.Name;
import com.ProductManagementSystem.ProductManagementSystem.payload.dowJones.NameValue;
import com.ProductManagementSystem.ProductManagementSystem.payload.dowJones.Person;
import com.ProductManagementSystem.ProductManagementSystem.payload.dowJones.PfaRequest;
import com.ProductManagementSystem.ProductManagementSystem.payload.dowJones.Place;
import com.ProductManagementSystem.ProductManagementSystem.repository.DowEntEntityRepository;
import com.ProductManagementSystem.ProductManagementSystem.repository.PersonEntityRepository;
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
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UploaderService {

    private final PersonEntityRepository personRepository;
    private final PersonEntityMapper personEntityMapper;
    private final DowEntEntityMapper dowEntEntityMapper;
    private final DowEntEntityRepository dowEntEntityRepository;

    @Transactional
    public Response uploadAndMapXml(MultipartFile file) throws JAXBException, ProductException {
        try {
            byte[] xmlBytes = file.getBytes();

            JAXBContext jaxbContext = JAXBContext.newInstance(PfaRequest.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            try (InputStream inputStream = new ByteArrayInputStream(xmlBytes)) {
                PfaRequest request = (PfaRequest) unmarshaller.unmarshal(inputStream);
                saveXmlData(request);
                return ResponseBuilder.buildSuccessResponse("Xml upload success");
            }
        } catch (IOException person) {
            throw new ProductException(person);
        }
    }

    private void saveXmlData(PfaRequest request) {
        List<Person> persons = request.getRecords().getPersons();
        List<Entity> entities = request.getRecords().getEntities();

        List<PersonEntity> personEntities = persons.stream().map(person -> {
                    PersonEntity personEntity = personEntityMapper.toEntity(person);
                    List<String> birthPlaceNames = Optional.ofNullable(person.getBirthPlace())
                            .orElse(List.of())
                            .stream()
                            .map(Place::getName)
                            .toList();

                    if (person.getNameDetails() != null) {
                        List<NameDetailEntity> nameDetailEntities = person.getNameDetails().stream()
                                .map(nameDto -> mapNameToEntity(nameDto, personEntity))
                                .toList();
                        personEntity.setNameDetails(nameDetailEntities);
                    }

                    if (person.getDateDetails() != null) {
                        List<DateDetailEntity> dateDetailEntities = person.getDateDetails().stream()
                                .map(dateDto -> mapDateToEntity(dateDto, personEntity))
                                .toList();
                        personEntity.setDateDetails(dateDetailEntities);
                    }
                    if (person.getCountryDetails() != null) {
                        List<CountryDetailEntity> countryDetailEntities = person.getCountryDetails().stream()
                                .map(countryDto -> mapCountryToEntity(countryDto, personEntity))  // Assuming mapCountryToEntity handles the mapping
                                .toList();
                        personEntity.setCountryDetails(countryDetailEntities);
                    }

                    personEntity.setBirthPlace(birthPlaceNames);
                    return personEntity;
                }
        ).toList();

        List<DowEntEntity> dowJonesEntities = entities.stream()
                .map(e -> {
                    DowEntEntity dowEntEntity = dowEntEntityMapper.toEntity(e);
                    return dowEntEntity;
                }).toList();

        dowEntEntityRepository.saveAll(dowJonesEntities);
        personRepository.saveAll(personEntities);
    }

    private NameDetailEntity mapNameToEntity(Name nameDto, PersonEntity personEntity) {
        NameDetailEntity nameDetailEntity = new NameDetailEntity();
        nameDetailEntity.setNameType(nameDto.getNameType());
        nameDetailEntity.setPerson(personEntity);

        if (nameDto.getNameValues() != null) {
            List<NameValueEntity> nameValueEntities = nameDto.getNameValues().stream()
                    .map(this::mapNameValueToEntity)
                    .toList();
            nameDetailEntity.setNameValues(nameValueEntities);
        }

        return nameDetailEntity;
    }

    private NameValueEntity mapNameValueToEntity(NameValue nameValueDto) {
        NameValueEntity nameValueEntity = new NameValueEntity();
        nameValueEntity.setFirstName(nameValueDto.getFirstName());
        nameValueEntity.setMiddleName(nameValueDto.getMiddleName());
        nameValueEntity.setSurname(nameValueDto.getSurname());
        nameValueEntity.setMaidenName(nameValueDto.getMaidenName());
        nameValueEntity.setOriginalScriptName(nameValueDto.getOriginalScriptName());
        return nameValueEntity;
    }

    private DateDetailEntity mapDateToEntity(Date dateDto, PersonEntity personEntity) {
        DateDetailEntity dateDetailEntity = new DateDetailEntity();
        dateDetailEntity.setDateType(dateDto.getDateType());
        dateDetailEntity.setPerson(personEntity);

        if (dateDto.getDateValues() != null) {
            List<DateValueEntity> dateValueEntities = dateDto.getDateValues().stream()
                    .map(this::mapDateValueToEntity)
                    .toList();
            dateDetailEntity.setDateValues(dateValueEntities);
        }

        return dateDetailEntity;
    }

    private DateValueEntity mapDateValueToEntity(DateValue dateValueDto) {
        DateValueEntity dateValueEntity = new DateValueEntity();
        dateValueEntity.setDay(dateValueDto.getDay());
        dateValueEntity.setMonth(dateValueDto.getMonth());
        dateValueEntity.setYear(dateValueDto.getYear());
        return dateValueEntity;
    }

    private CountryDetailEntity mapCountryToEntity(CountryDetail countryDto, PersonEntity personEntity) {
        CountryDetailEntity countryDetailEntity = new CountryDetailEntity();
        countryDetailEntity.setCountryType(countryDto.getCountryType());

        List<String> countryValues = countryDto.getCountryValue().stream()
                .map(CountryValue::getCode)
                .toList();
        countryDetailEntity.setCountryValues(countryValues);

        countryDetailEntity.setPerson(personEntity);
        return countryDetailEntity;
    }
}


