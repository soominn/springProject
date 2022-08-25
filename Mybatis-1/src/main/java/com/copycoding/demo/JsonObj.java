package com.copycoding.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class JsonObj {
	private int page;
	private int records;
	private int total;
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
}
