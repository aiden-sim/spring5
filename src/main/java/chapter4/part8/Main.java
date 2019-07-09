package chapter4.part8;

import chapter4.part7.domain.Members;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		base();
		placeholders();
		objectMapping();
	}

	private static void base() {
		final String uri = "http://localhost:8080/members.json";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		System.out.println(result);
	}

	// 매개변수화한 URL에서 데이터 가져오기
	private static void placeholders() {
		final String uri = "http://localhost:8080/member/{memberId}";
		Map<String, String> params = new HashMap<>();
		params.put("memberId", "1");

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class, params);
		System.out.println(result);
	}

	// 데이터를 매핑된 객체로 가져오기
	private static void objectMapping() {
		final String uri = "http://localhost:8080/members.xml";
		RestTemplate restTemplate = new RestTemplate();
		Members result = restTemplate.getForObject(uri, Members.class);
		System.out.println(result);
	}
}
