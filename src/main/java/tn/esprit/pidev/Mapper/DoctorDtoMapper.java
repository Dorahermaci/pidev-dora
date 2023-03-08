package tn.esprit.pidev.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import tn.esprit.pidev.DTO.DoctorDTO;
import tn.esprit.pidev.Entities.Doctor;

@Mapper(componentModel = "spring", uses = { EntityDtoMapper.class,
        BaseMapper.class }, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DoctorDtoMapper {
    public DoctorDTO toDto(Doctor u);
    @Mapping(target = "id", ignore = true)
    public void fillEntity(DoctorDTO d, @MappingTarget Doctor e);
}
