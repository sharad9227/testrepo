package com.example.demo.service;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ResponseClass implements ExceptionMapper<ExceptionClass>
{
    @Override
    public Response toResponse(ExceptionClass exception)
    {
        return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();
    }

    public Response toResponseNotAcceptable(ExceptionClass exception)
    {
        return Response.status(Status.UNAUTHORIZED).entity(exception.getMessage()).build();
    }



}