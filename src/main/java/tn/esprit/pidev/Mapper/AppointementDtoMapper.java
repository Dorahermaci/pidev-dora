package tn.esprit.pidev.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import tn.esprit.pidev.DTO.AppointementDTO;
import tn.esprit.pidev.Entities.Appointement;

@Mapper(componentModel = "spring", uses = { EntityDtoMapper.class,
        BaseMapper.class }, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppointementDtoMapper {
    public AppointementDTO toDto(Appointement u);
    @Mapping(target = "id", ignore = true)
    public void fillEntity(AppointementDTO d, @MappingTarget Appointement e);

}
