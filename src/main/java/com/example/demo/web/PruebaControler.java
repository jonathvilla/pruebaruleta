package com.example.demo.web;


import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class PruebaControler {
	private final RestTemplate restTemplate = new RestTemplate();
	@PostMapping("/ruleta/RULETA/v1")
	public ResponseEntity<String> postruleta() {
		
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(APPLICATION_JSON));
		
		String body = " {\n"
				+ "    \"gpUser\": \"indie\",\n"
				+ "    \"system\": \"web\",\n"
				+ "    \"msgName\": \"bet\",\n"
				+ "    \"sysOperator\": \"opera\",\n"
				+ "    \"player\": \"pepito\",\n"
				+ "    \"token\": \"D-E-F\",\n"
				+ "    \"game\": \"RULETA\",\n"
				+ "    \"msgDescrip\":\n"
				+ "        { \n"
				+ "          \"deno\": 10,\n"
				+ "          \"bets\": \n"
				+ "             [\n"
				+ "              {\n"
				+ "              \"id\": 0,\n"
				+ "              \"amount\": 10,\n"
				+ "              \"value\": \"1\",\n"
				+ "              \"type\": \"Pleno\"\n"
				+ "            },\n"
				+ "            {\n"
				+ "              \"id\": 1,\n"
				+ "              \"amount\": 10,\n"
				+ "              \"value\": \"1_4\",\n"
				+ "              \"type\": \"Medio\"\n"
				+ "            },\n"
				+ "            {\n"
				+ "              \"id\": 2,\n"
				+ "              \"amount\": 10,\n"
				+ "              \"value\": \"1_2_3\",\n"
				+ "              \"type\": \"Linea\"\n"
				+ "            }\n"
				+ "\n"
				+ "            ]\n"
				+ "\n"
				+ "        }\n"
				+ "  }";
		
		HttpEntity<String> bodyAndHeaders = new HttpEntity<>(body, headers);
		String bodyRespond = "";

		for (int i = 0; i <10; i++) {
			final ResponseEntity<String> peticionLiga = restTemplate.exchange("http://172.16.1.132:8080/ruleta/RULETA/v1", HttpMethod.POST,
					bodyAndHeaders, String.class);
			bodyRespond = bodyRespond.concat(peticionLiga.getBody());
			
			System.out.println(peticionLiga.getBody());
			
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(bodyRespond);
			
	}
	

}
