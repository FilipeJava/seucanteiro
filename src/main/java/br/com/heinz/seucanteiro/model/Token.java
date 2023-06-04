package br.com.heinz.seucanteiro.model;

public record Token(
    String token,
    String type,
    String prefix
) {}
