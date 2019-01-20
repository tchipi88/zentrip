package com.ganeo.appli.zentrip.dto.retrofit;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tchipnangngansopa on 10/09/2017.
 */

public class Page<T> implements Serializable {
    private boolean last;
    private boolean first;
    private List<T> content;
    private Integer totalElements;
    private Integer totalPages;
    private Integer size;
    private Integer number;
    private Integer numberOfElements;

    public Page() {
    }

    public Page(int page, int limit, List<T> contents) {
        setSize(limit);
        setNumber(page);
        setContent(contents);
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(Integer numberOfElements) {
        this.numberOfElements = numberOfElements;
    }
}
