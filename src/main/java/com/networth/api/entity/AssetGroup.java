package com.networth.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ASSET_GROUP")
public class AssetGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assetGroupId;
    private String  assetGroupName;
}
