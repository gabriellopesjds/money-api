package com.gabriellopesjds.moneyapi.launch.repository;

import com.gabriellopesjds.moneyapi.launch.domain.model.Launch;
import org.springframework.data.jpa.domain.Specification;

public class FinderAllLaunchSpecification {

    public static Specification<Launch> filterBy(FinderAllLaunchSpecificationParameters parameters) {
        return (root, criteriaQuery, criteriaBuilder) -> Specification.where(
            LaunchSpecification.descriptionEquals(parameters.getDescription())
            .and(LaunchSpecification.typeEquals(parameters.getType()))
            .and(LaunchSpecification.expirationDateBeetwen(parameters.getExpirationDateStart(), parameters.getExpirationDateEnd())))
            .toPredicate(root, criteriaQuery, criteriaBuilder);
    }

}
