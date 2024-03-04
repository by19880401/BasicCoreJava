package com.siemens.rank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthTable {
    private String distributor;
    private Double healthRatio;
    private String rank;
}
