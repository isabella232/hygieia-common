package com.capitalone.dashboard.repository;

import com.capitalone.dashboard.model.Cmdb;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
/**
 * Repository for {@link Cmdb} data.
 */
public interface CmdbRepository extends QueryRepository<Cmdb>  {

    Cmdb findByConfigurationItem(String configurationItem);

    List<Cmdb> findAllByConfigurationItemContainingOrCommonNameContainingAllIgnoreCase(String configItemFilter, String commonNameFilter);

    Page<Cmdb> findAllByItemTypeAndValidConfigItemAndIdIn(String itemType, boolean valid, List<ObjectId> idList, Pageable pageable);

    Page<Cmdb> findAllByItemTypeAndConfigurationItemContainingIgnoreCaseAndValidConfigItem(String itemType, String configurationItem, Pageable pageable, boolean valid);

    Cmdb findByConfigurationItemIgnoreCase(String configurationItem);

    List<Cmdb> findAllByItemType(String type);

    List<Cmdb> findAllByItemTypeAndValidConfigItem(String type, boolean valid);

    Cmdb findByConfigurationItemAndItemType(String confiugrationItem, String itemType);

    Iterable<Cmdb> findAllByValidConfigItem(boolean validFlag);

    Cmdb findByConfigurationItemIgnoreCaseOrCommonNameIgnoreCase(String configurationItem, String commonName);

    Cmdb findByItemTypeAndCommonNameContainingIgnoreCase(String itemType, String commonName);

    Cmdb findByItemTypeAndConfigurationItemIgnoreCase(String itemType, String configurationItem);
}