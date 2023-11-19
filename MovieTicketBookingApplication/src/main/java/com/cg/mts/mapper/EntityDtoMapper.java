package com.cg.mts.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Component
public class EntityDtoMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <D, E> D convertToDTO(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public static <E, D> E convertToEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    public static <D, E> List<D> convertToDTOList(List<E> entityList, Class<D> dtoClass) {
        return entityList.stream()
                .map(entity -> convertToDTO(entity, dtoClass))
                .collect(Collectors.toList());
    }
    
    public static <D, E> D convertToDTOWithRelationship(E entity, Class<D> dtoClass, Consumer<E> relationshipSetter) {
        D dto = modelMapper.map(entity, dtoClass);
        relationshipSetter.accept(entity);
        return dto;
    }
}

