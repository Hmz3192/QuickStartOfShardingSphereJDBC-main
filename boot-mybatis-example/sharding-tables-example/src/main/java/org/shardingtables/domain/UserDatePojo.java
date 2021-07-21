package org.shardingtables.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDatePojo {
    private Long id;
    private String str_user;
    private String str_date;
    private String beg_date;
    private String end_date;
    private Long str_num;

}
