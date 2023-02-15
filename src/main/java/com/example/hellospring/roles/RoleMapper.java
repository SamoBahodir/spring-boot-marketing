//package com.example.hellospring.roles;
//
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.MappingTarget;
//
//@Mapper(componentModel = "spring")
//public interface RoleMapper {
//    @Mapping(target = "name.uz", source = "nameUz")
//    @Mapping(target = "name.oz", source = "nameOz")
//    @Mapping(target = "name.ru", source = "nameRu")
//    @Mapping(target = "name.en", source = "nameEn")
//    void toEntity(@MappingTarget Role role, RolePayload payload);
//
//    @Mapping(target = "updatedBy", ignore = true)
//    @Mapping(target = "createdBy", ignore = true)
//    RoleResponse toDto(Role role);
//}
