package com.gabriellopesjds.moneyapi.launch.domain.service;

import com.gabriellopesjds.moneyapi.launch.domain.model.Launch;
import com.gabriellopesjds.moneyapi.launch.domain.model.enumerated.LaunchTypeEnum;
import com.gabriellopesjds.moneyapi.launch.dto.response.LaunchResponseDTO;
import com.gabriellopesjds.moneyapi.launch.dto.response.LaunchResponseWrapperDTO;
import com.gabriellopesjds.moneyapi.launch.repository.FinderAllLaunchSpecification;
import com.gabriellopesjds.moneyapi.launch.repository.FinderAllLaunchSpecificationParameters;
import com.gabriellopesjds.moneyapi.launch.repository.LaunchRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GetterLaunchService {

    private final LaunchRepository launchRepository;
    private final LaunchFactory launchFactory;

    public LaunchResponseWrapperDTO findAllParametersBy(String description,
                                                        LocalDate expirationDateStart,
                                                        LocalDate expirationDateEnd,
                                                        LaunchTypeEnum type,
                                                        int pageSize,
                                                        int pageNumber) {
        FinderAllLaunchSpecificationParameters parameters =
            FinderAllLaunchSpecificationParameters.builder()
                .description(description)
                .expirationDateStart(expirationDateStart)
                .expirationDateEnd(expirationDateEnd)
                .type(type)
                .build();

        Specification<Launch> launchSpecification =
            FinderAllLaunchSpecification.filterBy(parameters);

        Pageable page = PageRequest.of(pageNumber, pageSize);

        Page<Launch> launchPage = launchRepository.findAll(launchSpecification, page);

        List<LaunchResponseDTO> result =
            launchPage.stream().map(launchFactory::buildResponse).collect(Collectors.toList());

        return launchFactory.buildResponseList(page, launchPage, result);
    }

}
