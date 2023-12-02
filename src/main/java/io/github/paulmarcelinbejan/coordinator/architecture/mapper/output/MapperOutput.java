package io.github.paulmarcelinbejan.coordinator.architecture.mapper.output;

public interface MapperOutput<DOMAIN, RESPONSE> {

	RESPONSE toResponse(DOMAIN domain);
	
}
