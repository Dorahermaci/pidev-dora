package tn.esprit.pidev.Mapper;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface BaseMapper {
        default LocalDate toLocalDate(Date dt) {
                if (dt == null)
                        return null;
                // force a real java date, not a java.sql.date
                dt = new Date(dt.getTime());
                return dt.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }

        default Date toDate(LocalDate dt) {
                return dt == null ? null : Date.from(dt.atTime(12, 0).toInstant(ZoneOffset.UTC));
        }
        }
