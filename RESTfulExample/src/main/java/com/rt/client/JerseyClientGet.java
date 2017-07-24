package com.rt.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientGet {

	public static void main(String[] args) {
		try {
			
			Client service_use = Client.create();
			WebResource bulkpush = service_use.resource("http://localhost:8083/RESTfulExample/rest/json/metallica/get");
			ClientResponse response = bulkpush.accept("application/json").get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("HTTP Error Code is: " + response.getStatus());
			}
			String output = response.getEntity(String.class);
			System.out.println("Server says \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}