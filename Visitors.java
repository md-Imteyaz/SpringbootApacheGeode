package com.SpringbootApacheGeode.model;

import javax.persistence.Id;

import org.springframework.data.gemfire.mapping.annotation.Indexed;
import org.springframework.data.gemfire.mapping.annotation.Region;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Region("Visitors")
@RequiredArgsConstructor(staticName="newVisitors" )
public class Visitors {
	@Id
	@NonNull
   private long id;
	@NonNull @Indexed
	private String name;
}
