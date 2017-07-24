package com.rt.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientPost {

	public static void main(String[] args) {

		try {

			Client service_sent = Client.create();
			WebResource wr = service_sent.resource("http://localhost:8083/RESTfulExample/rest/json/metallica/post");
			String input = "{\"singer\":\"Grey Clutch\",\"title\":\"White Beard\"}";
			ClientResponse response = wr.type("application/json").post(ClientResponse.class, input);
			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}
			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
