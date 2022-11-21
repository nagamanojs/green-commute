package com.zemoso.greencommute.rest;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class JobErrorResponse {
   private  int status;
   private String message;
   private  long timeStamp;

   public String getMessage() {
      return message;
   }
}
