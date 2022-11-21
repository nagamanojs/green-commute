package com.zemoso.greencommute.rest;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class JobErrorResponseTest {
    @Test
    public void JobErrorResponse_objectCreation(){
        JobErrorResponse jobErrorResponse=new JobErrorResponse(400,"hello",112236);
        assertEquals("hello",jobErrorResponse.getMessage());


    }
    @Test
    public void JobErrorResponse_objectCreation_withDefault(){
        JobErrorResponse jobErrorResponse=new JobErrorResponse();
        assertEquals(null,jobErrorResponse.getMessage());

    }



}
