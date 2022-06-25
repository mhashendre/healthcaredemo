package com.aventude.healthcare.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HelperServiceImpl implements IHelperService {

    private ModelMapper modelMapper;

    HelperServiceImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public <D> D map(Object source, Class<D> destinationType) {
        return source == null ? null : modelMapper.map(source, destinationType);
    }

    @Override
    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}
