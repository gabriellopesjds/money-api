package com.gabriellopesjds.moneyapi.launch.domain.service;

import com.gabriellopesjds.moneyapi.launch.domain.model.Launch;
import com.gabriellopesjds.moneyapi.launch.dto.request.LaunchRequestDTO;
import com.gabriellopesjds.moneyapi.launch.dto.response.LaunchResponseDTO;
import com.gabriellopesjds.moneyapi.launch.repository.LaunchRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RegisterLaunchService {

    private final LaunchRepository launchRepository;
    private final LaunchFactory launchFactory;

    @Transactional
    public LaunchResponseDTO saveLaunch(LaunchRequestDTO requestDTO) {
        Launch launch = launchFactory.fromValue(requestDTO);
        Launch launchSaved = launchRepository.saveAndFlush(launch);
        return launchFactory.buildResponse(launchSaved);
    }

}
