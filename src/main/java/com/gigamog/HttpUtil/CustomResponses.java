package com.gigamog.HttpUtil;

import java.util.ArrayList;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.gigamog.HttpUtil.pojo.ErrorResponse;
import com.gigamog.HttpUtil.pojo.JsonBase;
import com.gigamog.HttpUtil.pojo.SimpleResponse;

public class CustomResponses {

	static boolean debugMode = true;
	
	
	public static Response succesfulResponse() {
		return Response.ok().build();
	}
	
	
	
	public static Response succesfulResponse(JsonBase response){
		return Response.ok()
				.entity(response).build();
	}
	
	public static Response succesfulResponse(ArrayList<JsonBase> response){
		return Response.ok()
				.entity(response).build();
	}
	

	
	public static Response deprecatedSuccesfulResponse(JsonBase response, String endpoint){
		return Response.ok()
				.header("Warning", "Deprecated Endpoint use " + endpoint)
				.entity(response).build();
	}
	
	public static Response deprecatedSuccesfulResponse(ArrayList<JsonBase> response, String endpoint){
		return Response.ok()
				.header("Warning", "Deprecated Endpoint use " + endpoint)
				.entity(response).build();
	}
	
	
	
	public static Response serverErrorResponse() {
		return serverErrorResponse("server error");
	}
	public static Response serverErrorResponse(String response){
		SimpleResponse s = new SimpleResponse();
		ErrorResponse er = new ErrorResponse();
		er.setDetail(response);
		er.setStatus(500);
		s.setError(er);
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.header("message", response)
				.entity(s).build();
	}
	
	
	
	public static Response sqlErrorResponse(int code, String message) {
		SimpleResponse s = new SimpleResponse();
		ErrorResponse er = new ErrorResponse();
		er.setDetail(message);
		er.setStatus(500);
		s.setError(er);
		s.setResponseMessage("SQL ERROR");
		return Response.status(Status.INTERNAL_SERVER_ERROR).header("message", message)
				.entity(s).build();
	}
	
	
	
	
	public static Response conflictingResourceResponse() {
		return conflictingResourceResponse("Request could not be completed due to a conflicting existing resource.");
	}
	public static Response conflictingResourceResponse(String response) {
		SimpleResponse s = new SimpleResponse();
		ErrorResponse er = new ErrorResponse();
		er.setDetail(response);
		er.setStatus(409);
		s.setError(er);
		return Response.status(Status.CONFLICT).header("message", response)
				.entity(s).build();
	}
	
	
	public static Response incorrectMethodResponse() {
		return incorrectMethodResponse("Incorrect request method.");
	}
	public static Response incorrectMethodResponse(String response) {
		SimpleResponse s = new SimpleResponse();
		ErrorResponse er = new ErrorResponse();
		er.setDetail(response);
		er.setStatus(405);
		s.setError(er);
		return Response.status(Status.NOT_FOUND).header("message", response)
				.entity(s).build();
	}
	
	
	
	public static Response notFoundResponse() {
		return notFoundResponse("The requested resource was not found.");
	}
	public static Response notFoundResponse(String response) {
		SimpleResponse s = new SimpleResponse();
		ErrorResponse er = new ErrorResponse();
		er.setDetail(response);
		er.setStatus(404);
		s.setError(er);
		return Response.status(Status.NOT_FOUND).header("message", response)
				.entity(s).build();
	}
	
	
	public static Response unauthorizedResponse() {
		return unauthorizedResponse("Access denied for requested resource.");
	}
	public static Response unauthorizedResponse(String response){
		
		SimpleResponse s = new SimpleResponse();
		ErrorResponse er = new ErrorResponse();
		er.setDetail(response);
		er.setStatus(401);
		s.setError(er);
		return Response.status(Status.UNAUTHORIZED).header("message", response)
				.entity(s).build();
	}
	
	public static Response badRequestResponse() {
		return badRequestResponse("Bad request. Alter request and try again.");
	}
	public static Response badRequestResponse(String response){
		
		SimpleResponse s = new SimpleResponse();
		ErrorResponse er = new ErrorResponse();
		er.setDetail(response);
		er.setStatus(400);
		s.setError(er);
		return Response.status(Status.BAD_REQUEST).header("message", response)
				.entity(s).build();
	}
	
	
	
	/**
	 * Custom error code.. because yea.
	 * @param code
	 * @param response
	 * @return
	 */
	public static Response customResponse(int code, String response) {
		SimpleResponse s = new SimpleResponse();
		ErrorResponse er = new ErrorResponse();
		er.setDetail(response);
		er.setStatus(code);
		s.setError(er);
		return Response.status(code).header("message", response)
				.entity(response).build();
	}
	
	
	
	
	public static Response getGenericResponse(int response_code, JsonBase entity) {
		switch(response_code) {
		case 200:
			return succesfulResponse(entity);
		case 400:
			return badRequestResponse();
		case 401:
			return unauthorizedResponse();
		case 404:
			return notFoundResponse();
		case 409:
			return conflictingResourceResponse();
		case 500:
			return serverErrorResponse();
		default:
			return serverErrorResponse();
		}
	}
	
	public static Response getGenericResponse(int response_code, String response_message, JsonBase entity) {
		switch(response_code) {
		case 200:
			return succesfulResponse(entity);
		case 400:
			return badRequestResponse(response_message);
		case 401:
			return unauthorizedResponse(response_message);
		case 404:
			return notFoundResponse(response_message);
		case 409:
			return conflictingResourceResponse(response_message);
		case 500:
			return serverErrorResponse(response_message);
		default:
			return serverErrorResponse();
		}
		
	}
	
	
	
	
	
	/*
	 * debug responses
	 */
	
	public static Response storedProcedureError(String procName) {
		if (debugMode) {
			SimpleResponse s = new SimpleResponse();
			ErrorResponse er = new ErrorResponse();
			er.setDetail("Stored procedure '" + procName + "' failed to execute. (Check server logs)");
			er.setStatus(500);
			s.setError(er);
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(s).build();
		}
		else 
			return serverErrorResponse();
	}
	
	public static Response moodleEndpointError(String endpointName) {
		if (debugMode) {
			SimpleResponse s = new SimpleResponse();
			ErrorResponse er = new ErrorResponse();
			er.setDetail("Moodle endpoint '" + endpointName + "' failed. (Check server logs)");
			er.setStatus(500);
			s.setError(er);
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(s).build();
		}
		else 
			return serverErrorResponse();
	}
}
