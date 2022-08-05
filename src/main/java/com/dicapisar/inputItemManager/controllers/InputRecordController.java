package com.dicapisar.inputItemManager.controllers;

import com.dicapisar.inputItemManager.dtos.response.RecordInputResponse;
import com.dicapisar.inputItemManager.exceptions.SessionErrorException;
import com.dicapisar.inputItemManager.exceptions.SessionWithOutPermissionException;
import com.dicapisar.inputItemManager.services.IRecordInputService;
import com.dicapisar.inputItemManager.utils.SessionUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static com.dicapisar.inputItemManager.commons.InputItemManagerConstants.*;
import static com.dicapisar.inputItemManager.utils.SessionUtils.validateSessionExist;
import static com.dicapisar.inputItemManager.utils.SessionUtils.validateSessionHavePermissions;

@RestController
@AllArgsConstructor
@RequestMapping("/input_records")
public class InputRecordController {

    private IRecordInputService recordInputService;

    @PostMapping("/create")
    public ResponseEntity<RecordInputResponse> createNewInputRecord(HttpSession session)
            throws SessionErrorException, SessionWithOutPermissionException {
        ArrayList<String> rolesPermissions = new ArrayList<>(List.of(ADMIN, MANAGER, EMPLOYED));

        validateSessionExist(session);
        validateSessionHavePermissions(session, rolesPermissions);

        return new ResponseEntity<>(recordInputService.createNewRecordInput(SessionUtils.getIdUserSession(session)), HttpStatus.CREATED);
    }
}
