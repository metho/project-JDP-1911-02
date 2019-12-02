package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Map;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto {
    private Long id;
    private String productGroup;
}
