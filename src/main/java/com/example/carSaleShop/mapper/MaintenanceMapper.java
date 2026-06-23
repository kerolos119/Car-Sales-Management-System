package com.example.carSaleShop.mapper;

import com.example.carSaleShop.document.Maintenance;
import com.example.carSaleShop.dto.MaintenanceDto;
import org.springframework.stereotype.Component;

@Component
public class MaintenanceMapper extends AbstractMapper<MaintenanceDto, Maintenance> {

    public MaintenanceMapper() {
        super(MaintenanceDto.class, Maintenance.class);
    }

    @Override
    public Maintenance updateToEntity(MaintenanceDto dto, Maintenance entity) {
        if (dto.getDescription() != null && !dto.getDescription().isBlank())
            entity.setDescription(dto.getDescription());
        if (dto.getMaintenanceStatus() != null)
            entity.setMaintenanceStatus(dto.getMaintenanceStatus());
        if (dto.getScheduledDate() != null)
            entity.setScheduledDate(dto.getScheduledDate());
        if (dto.getCompletedDate() != null)
            entity.setCompletedDate(dto.getCompletedDate());
        if (dto.getLaborCost() != null)
            entity.setLaborCost(dto.getLaborCost());
        if (dto.getTotalCost() != null)
            entity.setTotalCost(dto.getTotalCost());
        if (dto.getTechnicianNotes() != null && !dto.getTechnicianNotes().isBlank())
            entity.setTechnicianNotes(dto.getTechnicianNotes());
        if (dto.getUsedPartsId() != null && !dto.getUsedPartsId().isEmpty())
            entity.setUsedPartsId(dto.getUsedPartsId());
        return entity;
    }
}