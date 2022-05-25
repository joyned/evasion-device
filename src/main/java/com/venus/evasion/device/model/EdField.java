package com.venus.evasion.device.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EdField {

    private String name;
    private String xpath;
    private String type;
}
