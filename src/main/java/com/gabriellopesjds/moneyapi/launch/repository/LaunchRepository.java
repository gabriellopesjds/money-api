package com.gabriellopesjds.moneyapi.launch.repository;

import com.gabriellopesjds.moneyapi.launch.domain.model.Launch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LaunchRepository extends JpaRepository<Launch, UUID>, JpaSpecificationExecutor<Launch> {

}
