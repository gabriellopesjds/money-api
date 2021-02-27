package com.gabriellopesjds.moneyapi.launch.application.service;

import com.gabriellopesjds.moneyapi.launch.domain.model.enumerated.LaunchTypeEnum;
import com.gabriellopesjds.moneyapi.launch.domain.service.GetterLaunchService;
import com.gabriellopesjds.moneyapi.launch.domain.service.RegisterLaunchService;
import com.gabriellopesjds.moneyapi.launch.dto.request.LaunchRequestDTO;
import com.gabriellopesjds.moneyapi.launch.dto.response.LaunchResponseDTO;
import com.gabriellopesjds.moneyapi.launch.dto.response.LaunchResponseWrapperDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LaunchApplicationService {

    private final RegisterLaunchService registerLaunchService;
    private final GetterLaunchService getterLaunchService;

    public LaunchResponseDTO saveLaunch(LaunchRequestDTO requestDTO) {
        return registerLaunchService.saveLaunch(requestDTO);
    }

    public LaunchResponseWrapperDTO findAll(String description,
                                            LocalDate expirationDateStart,
                                            LocalDate expirationDateEnd,
                                            LaunchTypeEnum type,
                                            int pageSize,
                                            int pageNumber) {
        return getterLaunchService.findAllParametersBy(description, expirationDateStart, expirationDateEnd, type, pageSize, pageNumber );
    }

}
