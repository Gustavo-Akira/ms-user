package br.com.gustavoakira.ms.user.application.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageInformation {
    private Integer pageSize;
    private Integer actualPage;
}
