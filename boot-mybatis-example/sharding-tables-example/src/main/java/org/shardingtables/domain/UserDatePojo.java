package org.shardingtables.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDatePojo {
    private Long id;
    private String t_user;
    private String t_date;
    private String u_date;
    private Long num;

}
