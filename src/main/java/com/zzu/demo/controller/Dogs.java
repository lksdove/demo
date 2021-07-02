package com.zzu.demo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

/**
 * @author lks
 * @date 2021/5/26 14:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dogs {
    @Valid
    private List<DogDTO> dogDTOS;
}
