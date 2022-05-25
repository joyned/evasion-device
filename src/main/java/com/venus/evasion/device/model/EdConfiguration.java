package com.venus.evasion.device.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EdConfiguration {

    private String name;
    private String applicationUrl;
    private Boolean clickSave;
    private List<EdField> fields;
}
