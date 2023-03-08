package tn.esprit.pidev.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import tn.esprit.pidev.DTO.PatientDTO;
import tn.esprit.pidev.Entities.Patient;

@Mapper(componentModel = "spring", uses = { EntityDtoMapper.class,
        BaseMapper.class }, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PatientDtoMapper {
    public PatientDTO toDto(Patient u);
    @Mapping(target = "id", ignore = true)
    public void fillEntity(PatientDTO d, @MappingTarget Patient e);

}
