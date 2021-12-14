package com.networth.api.repository;

import com.networth.api.entity.AssetGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetGroupRepository extends JpaRepository<AssetGroup,Integer> {


}
