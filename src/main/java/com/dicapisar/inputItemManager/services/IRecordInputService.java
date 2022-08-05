package com.dicapisar.inputItemManager.services;

import com.dicapisar.inputItemManager.dtos.response.RecordInputResponse;

public interface IRecordInputService {
    RecordInputResponse createNewRecordInput(Long idUserCreator);
}
