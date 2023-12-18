package org.spring.wssoap.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class CollectionServiceImpl implements CollectionService {

	@Override
	public List<String> getReversed(List<String> namesList) {

		List<String> reversedList = new ArrayList<String>();
		for (String name : namesList) {
			StringBuffer strBuffer = new StringBuffer(name);

			String reversedName = strBuffer.reverse().toString();
			reversedList.add(reversedName);
		}
		return reversedList;
	}

	@Override
	public Set<String> getUpperCase(Set<String> namesSet) {

		Set<String> upperCased = new HashSet<>();
		for (String name : namesSet) {
			upperCased.add(name.toUpperCase());
		}
		return upperCased;
	}

	@Override
	public Map<Integer, String> getUpperCaseMap(Map<Integer, String> namesMap) {
		Set<Integer> keys = namesMap.keySet();
		Map<Integer, String> valuesMap = new HashMap<>();
		for (Integer key : keys) {
			String value = namesMap.get(key);
			valuesMap.put(key, value.toUpperCase());
		}
		return valuesMap;

	}

}
