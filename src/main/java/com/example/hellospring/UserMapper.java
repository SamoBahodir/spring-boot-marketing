//package com.example.hellospring;
//
//import com.example.hellospring.users.UserEntity;
//import com.example.hellospring.users.UserListResponse;
//import com.example.hellospring.users.UserSingleResponse;
//import org.mapstruct.InjectionStrategy;
//import org.mapstruct.Mapper;
//
//@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
//public abstract class UserMapper {
////    void toEntity(@MappingTarget UserEntity user, UserPayload payload);
////
////    UserEntity toEntity(UserPayload payload);
//
//    public abstract UserSingleResponse toDto(UserEntity user);
//
//
//    public abstract UserListResponse toDtoList(UserEntity user);
//}