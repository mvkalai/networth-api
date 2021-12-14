package com.networth.api.service;

import com.networth.api.domain.AssetGroupDto;
import com.networth.api.entity.AssetGroup;
import com.networth.api.enums.EStatusCode;
import com.networth.api.exception.ActionFailureException;
import com.networth.api.repository.AssetGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssetGroupService {

    @Autowired
    AssetGroupRepository assetGroupRepository;

    /**
     * Get a Case Report by status
     *
     * @param id
     * @return
     * @throws ActionFailureException
     */
    public AssetGroupDto getAssetGroupById(int id) throws ActionFailureException {
        Optional<AssetGroup> assetGroup = assetGroupRepository.findById(id);
        if (!assetGroup.isPresent())
        {
            throw new ActionFailureException(EStatusCode.RECORD_NOT_FOUND.name());
        }

        AssetGroupDto assetGroupDto = new AssetGroupDto();
        assetGroupDto.setAssetGroupId(assetGroup.get().getAssetGroupId());
        assetGroupDto.setAssetGroupName(assetGroup.get().getAssetGroupName());

        return assetGroupDto;
    }

}
