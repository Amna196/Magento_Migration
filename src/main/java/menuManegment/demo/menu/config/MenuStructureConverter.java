package menuManegment.demo.menu.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import menuManegment.demo.menu.model.MenuStructure;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.List;

@Converter
public class MenuStructureConverter implements
        AttributeConverter<List<MenuStructure>, String> {

    final static ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<MenuStructure> menuStructure) {
        if (menuStructure == null) {
            return null;
        }
        try {
            return mapper.writeValueAsString(menuStructure);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public List<MenuStructure> convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        try {
            return mapper.readValue(dbData, new TypeReference<List<MenuStructure>>() {
            });
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
