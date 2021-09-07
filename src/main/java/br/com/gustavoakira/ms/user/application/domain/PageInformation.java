package br.com.gustavoakira.ms.user.application.domain;

import lombok.Data;

@Data
public class PageInformation {
    private Integer pageSize;
    private Integer actualPage;
}
