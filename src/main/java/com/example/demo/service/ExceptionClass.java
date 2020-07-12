package com.example.demo.service;


import java.io.Serializable;

public class ExceptionClass extends Exception implements Serializable
    {
        //reference :https://howtodoinjava.com/resteasy/resteasy-exceptionmapper-example/
        private static final long serialVersionUID = 1L;
        public ExceptionClass() {
            super();
        }
        public ExceptionClass(String msg)   {
            super(msg);
        }
        public ExceptionClass(String msg, Exception e)  {
            super(msg, e);
        }
    }




