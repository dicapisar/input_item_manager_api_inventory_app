package com.dicapisar.inputItemManager.repository;

import com.dicapisar.inputItemManager.models.RecordInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordInputRepository extends JpaRepository<RecordInput, Long> {
}
