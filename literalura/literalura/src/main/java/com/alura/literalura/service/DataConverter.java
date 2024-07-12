package com.alura.literalura.service;

public interface DataConverter {

    public <T> T obterDados(String json, Class<T> classe);
}