package com.dicapisar.inputItemManager.services;

import com.dicapisar.inputItemManager.dtos.response.RecordInputResponse;
import com.dicapisar.inputItemManager.models.RecordInput;
import com.dicapisar.inputItemManager.models.User;
import com.dicapisar.inputItemManager.repository.RecordInputRepository;
import com.dicapisar.inputItemManager.repository.UserRepository;
import com.dicapisar.inputItemManager.utils.RecordInputUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.dicapisar.inputItemManager.commons.InputItemManagerConstants.IN_PROCESS;

@AllArgsConstructor
@Service
public class RecordInputService implements IRecordInputService {

    private UserRepository userRepository;
    private RecordInputRepository recordInputRepository;

    public RecordInputResponse createNewRecordInput(Long idUserCreator) {
        User creator = userRepository.getUserById(idUserCreator);

        RecordInput newRecordInput = this.getNewRecorInput(creator);

        RecordInput newRecordInputCreated = recordInputRepository.save(newRecordInput);

        return RecordInputUtil.toRecordInputResponse(newRecordInputCreated);

    }


    private RecordInput getNewRecorInput(User userCreator) {
        RecordInput newRecordInput = new RecordInput();

        newRecordInput.setActive(true);
        newRecordInput.setStatus(IN_PROCESS);
        newRecordInput.setReason("En proceso de ingreso de Items");
        newRecordInput.setCreationDate(LocalDateTime.now());
        newRecordInput.setUpdateDate(LocalDateTime.now());
        newRecordInput.setCreator(userCreator);
        newRecordInput.setUpdater(userCreator);

        return newRecordInput;

    }
}



