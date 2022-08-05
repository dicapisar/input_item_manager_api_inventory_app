package com.dicapisar.inputItemManager.utils;

import com.dicapisar.inputItemManager.dtos.response.RecordInputResponse;
import com.dicapisar.inputItemManager.models.RecordInput;

public class RecordInputUtil {

    public static RecordInputResponse toRecordInputResponse(RecordInput recordInput) {

        return new RecordInputResponse(
                recordInput.getId(),
                recordInput.isActive(),
                recordInput.getStatus(),
                recordInput.getReason(),
                recordInput.getCreationDate(),
                recordInput.getUpdateDate(),
                recordInput.getCreator().getId()
        );
    }
}
