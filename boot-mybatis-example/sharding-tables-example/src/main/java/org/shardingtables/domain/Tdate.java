package org.shardingtables.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User Message
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tdate {

    private Long id;
    private String str_date;
    private String end_date;

}