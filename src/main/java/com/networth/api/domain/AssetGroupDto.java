package com.networth.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetGroupDto {
 private Integer assetGroupId;
 private String  assetGroupName;
}
