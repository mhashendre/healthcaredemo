package com.aventude.healthcare.service;

import java.util.List;

public interface IHelperService {

    <D> D map(Object source, Class<D> destinationType);
    <S, T> List<T> mapList(List<S> source, Class<T> targetClass);
}
