package tn.esprit.pidev.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import tn.esprit.pidev.DTO.MedicalFOlderDTO;
import tn.esprit.pidev.Entities.MedicalFolder;

@Mapper(componentModel = "spring", uses = { EntityDtoMapper.class,
        BaseMapper.class }, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicalFolderDtoMapper {
    public MedicalFOlderDTO toDto(MedicalFolder u);
    @Mapping(target = "id", ignore = true)
    public void fillEntity(MedicalFOlderDTO d, @MappingTarget MedicalFolder e);
}
