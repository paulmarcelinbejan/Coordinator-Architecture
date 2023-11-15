package com.paulmarcelinbejan.architecture.sniper.mapper.output;

public interface MapperOutput<DOMAIN, RESPONSE> {

	RESPONSE toResponse(DOMAIN domain);
	
}
