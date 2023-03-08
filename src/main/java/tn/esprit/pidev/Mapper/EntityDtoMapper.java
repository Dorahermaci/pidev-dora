package tn.esprit.pidev.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.TargetType;
import org.reflections.Reflections;
import org.springframework.stereotype.Component;
import tn.esprit.pidev.Entities.IPidevEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

@Component
@Mapper(componentModel = "spring", uses = BaseMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class EntityDtoMapper {
    @PersistenceContext
    protected EntityManager entityManager;

    protected Reflections reflexions;

    public Reflections getReflexions() {
        if (reflexions == null) {
            reflexions = new Reflections("tn.esprit");
        }
        return reflexions;
    }

    public Long toReference(IPidevEntity entity) {
        return entity != null ? entity.getId() : null;
    }

    public <T extends IPidevEntity> T resolve(Long reference, @TargetType Class<T> entityClass) {
        return reference != null ? entityManager.find(entityClass, reference) : null;
    }

    public <K extends IPidevEntity, V extends Number> Map<Long, V> map(Map<K, V> m) {
        Map<Long, V> r = new HashMap<>();

        if (m != null) {
            for (Map.Entry<K, V> me : m.entrySet()) {
                r.put(me.getKey().getId(), me.getValue());
            }
        }

        return r;
    }

}

