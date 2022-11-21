package com.zemoso.greencommute.rest;

import com.zemoso.greencommute.exception.CityNotFoundException;
import com.zemoso.greencommute.exception.JobNotFoundException;
import com.zemoso.greencommute.exception.SkillsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class JobExceptionHandler {

    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<JobErrorResponse> handleJobNotFoundException(JobNotFoundException ex){
        JobErrorResponse errorResponse=new JobErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<JobErrorResponse> handleCityNotFoundException(CityNotFoundException ex){
        JobErrorResponse errorResponse=new JobErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(SkillsNotFoundException.class)
    public ResponseEntity<JobErrorResponse> handleSkillsNotFoundException(SkillsNotFoundException ex){
        JobErrorResponse errorResponse=new JobErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<JobErrorResponse> handleGlobalException(Exception ex){
        JobErrorResponse errorResponse=new JobErrorResponse(HttpStatus.BAD_REQUEST.value(),ex.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

}
