package com.github.xenteros.mapper;

import com.github.xenteros.dto.AddressDto;
import com.github.xenteros.model.Address;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {


    AddressDto toAddressDto(Address address);
    List<AddressDto> toAddressDto(Collection<Address> address);
}
