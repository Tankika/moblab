package com.example.zizi.lab3.mock.interceptors;

import android.net.Uri;

import com.example.zizi.lab3.network.NetworkConfig;
import com.example.zizi.lab3.repository.MemoryRepository;
import com.example.zizi.lab3.utils.GsonHelper;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.zizi.lab3.mock.interceptors.MockHelper.makeResponse;

public class CardsMock {
	public static Response process(Request request) {
		Uri uri = Uri.parse(request.url().toString());

		String responseString;
		int responseCode;
		Headers headers = request.headers();


		if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "Todos") && request.method().equals("POST")) {
			responseString = "";
			responseCode = 200;
		}else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "Todos") && request.method().equals("Get")) {
			MemoryRepository memoryRepository = new MemoryRepository();
			memoryRepository.open(null);
			responseString = GsonHelper.getGson().toJson(memoryRepository.getCards());
			responseCode = 200;
		} else {
			responseString = "ERROR";
			responseCode = 503;
		}

		return makeResponse(request, headers, responseCode, responseString);
	}
}
