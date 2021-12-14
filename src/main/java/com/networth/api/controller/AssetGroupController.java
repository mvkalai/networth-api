package com.networth.api.controller;

import com.networth.api.domain.AssetGroupDto;
import com.networth.api.domain.Response;
import com.networth.api.exception.ActionFailureException;
import com.networth.api.repository.AssetGroupRepository;
import com.networth.api.service.AssetGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class AssetGroupController {

    @Autowired
    AssetGroupService assetGroupService;

    @GetMapping("/asset-group/{id}")
    public ResponseEntity<Response<AssetGroupDto>> getAssetGroupById(@PathVariable Integer id)
            throws ActionFailureException {
        Response<AssetGroupDto> response = new Response<>();
        response.setData(Arrays.asList(assetGroupService.getAssetGroupById(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
