package com.gabriellopesjds.moneyapi.launch.domain.service;

import com.gabriellopesjds.moneyapi.category.domain.service.CategoryFactory;
import com.gabriellopesjds.moneyapi.category.domain.service.GetterCategoryService;
import com.gabriellopesjds.moneyapi.launch.domain.model.Launch;
import com.gabriellopesjds.moneyapi.launch.dto.request.LaunchRequestDTO;
import com.gabriellopesjds.moneyapi.launch.dto.response.LaunchResponseDTO;
import com.gabriellopesjds.moneyapi.launch.dto.response.LaunchResponseWrapperDTO;
import com.gabriellopesjds.moneyapi.person.domain.service.GetterPersonService;
import com.gabriellopesjds.moneyapi.person.domain.service.PersonFactory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LaunchFactory {

    private final GetterCategoryService getterCategoryService;
    private final GetterPersonService getterPersonService;
    private final CategoryFactory categoryFactory;
    private final PersonFactory personFactory;
    private final PageableFactory pageableFactory;

    public Launch fromValue(LaunchRequestDTO requestDTO) {
        Launch launch = new Launch();
        launch.setDescription(requestDTO.getDescription());
        launch.setExpirationDate(requestDTO.getExpirationDate());
        launch.setPaymentDate(requestDTO.getPaymentDate());
        launch.setValue(requestDTO.getValue());
        launch.setObservation(requestDTO.getObservation());
        launch.setTypeEnum(requestDTO.getType());
        launch.setCategory(getterCategoryService.findById(requestDTO.getCategoryId()));
        launch.setPerson(getterPersonService.findByIdAndStatusActive(requestDTO.getPersonId()));
        return launch;
    }

    public LaunchResponseDTO buildResponse(Launch launchSaved) {
        return LaunchResponseDTO.builder()
            .id(launchSaved.getId())
            .description(launchSaved.getDescription())
            .expirationDate(launchSaved.getExpirationDate())
            .paymentDate(launchSaved.getPaymentDate())
            .value(launchSaved.getValue())
            .observation(launchSaved.getObservation())
            .type(launchSaved.getTypeEnum())
            .person(personFactory.buildResponse(launchSaved.getPerson()))
            .category(categoryFactory.buildResponse(launchSaved.getCategory()))
            .build();
    }

    public LaunchResponseWrapperDTO buildResponseList(Pageable page,
                                                       Page<Launch> launchPage,
                                                       List<LaunchResponseDTO> result) {
       return LaunchResponseWrapperDTO.builder()
           .data(result)
           .pageableDTO(pageableFactory.buildResponse(page, launchPage))
           .build();
    }

}
