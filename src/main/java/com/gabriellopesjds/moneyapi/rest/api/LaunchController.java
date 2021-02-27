package com.gabriellopesjds.moneyapi.rest.api;

import com.gabriellopesjds.moneyapi.launch.application.service.LaunchApplicationService;
import com.gabriellopesjds.moneyapi.launch.domain.model.enumerated.LaunchTypeEnum;
import com.gabriellopesjds.moneyapi.launch.dto.request.LaunchRequestDTO;
import com.gabriellopesjds.moneyapi.launch.dto.response.LaunchResponseDTO;
import com.gabriellopesjds.moneyapi.launch.dto.response.LaunchResponseWrapperDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;

import javax.validation.Valid;

@RestController
@RequestMapping("launchs")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LaunchController {

    private final LaunchApplicationService launchApplicationService;

    @PostMapping
    public ResponseEntity<LaunchResponseDTO> saveLaunch(@Valid @RequestBody LaunchRequestDTO requestDTO) {
        LaunchResponseDTO responseDTO = launchApplicationService.saveLaunch(requestDTO);

        URI uri =
            ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<LaunchResponseWrapperDTO> findAll(@RequestParam(value = "description", required = false) String description,
                                                            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(value = "expirationDateStart", required = false) LocalDate expirationDateStart,
                                                            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(value = "expirationDateEnd", required = false) LocalDate expirationDateEnd,
                                                            @RequestParam(value = "type", required = false) LaunchTypeEnum type,
                                                            @RequestParam(value = "pageSize") int pageSize,
                                                            @RequestParam(value = "pageNumber") int pageNumber) {
        LaunchResponseWrapperDTO responseDTOList = launchApplicationService.findAll(description, expirationDateStart, expirationDateEnd, type, pageSize, pageNumber);
        return responseDTOList.getData().isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(responseDTOList);
    }

}
