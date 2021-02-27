package com.gabriellopesjds.moneyapi.launch.repository;

import com.gabriellopesjds.moneyapi.launch.domain.model.Launch;
import com.gabriellopesjds.moneyapi.launch.domain.model.enumerated.LaunchTypeEnum;
import liquibase.util.StringUtil;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class LaunchSpecification {

    private static final LocalDate MAX_DATE = LocalDate.of(9999,12,30);

    public static Specification<Launch> descriptionEquals(String description) {
        if (StringUtil.isEmpty(description)) {
            return null;
        }
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("description"), description);
    }

    public static Specification<Launch> typeEquals(LaunchTypeEnum typeEnum) {
        if (typeEnum == null) {
            return null;
        }
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("typeEnum"), typeEnum);
    }

    public static Specification<Launch> expirationDateBeetwen(LocalDate startDate, LocalDate endDate) {
        boolean startDateNull = false;
        boolean endDateNull = false;
        if (startDate == null) {
            startDateNull = true;
            startDate = LocalDate.MIN;
        }
        if (endDate == null) {
            endDateNull = true;
            endDate = MAX_DATE;
        }
        if (startDateNull && endDateNull){
            return null;
        }
        LocalDate finalStartDate = startDate;
        LocalDate finalEndDate = endDate;
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
            .between(root.get("expirationDate"), finalStartDate, finalEndDate);
    }

}
