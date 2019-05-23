package net.codetojoy.survey.model;

import java.io.Serializable;

public class Response implements Serializable {
    private static final long serialVersionUID = 1L;

    private final long id;

    public Response(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
