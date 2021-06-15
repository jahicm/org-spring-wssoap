package org.spring.wssoap.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName = "CollectionService")
public interface CollectionService {

	@WebMethod()
	@WebResult(name = "namesList")
	public List<String> getReversed(@WebParam(name = "ListRequest") List<String> namesList);

	@WebMethod()
	@WebResult(name = "namesSet")
	public Set<String> getUpperCase(@WebParam(name = "SetRequest") Set<String> namesSet);

	@WebMethod()
	@WebResult(name = "namesMap")
	public Map<Integer, String> getUpperCaseMap(@WebParam(name = "MapRequest") Map<Integer, String> namesMap);
}
