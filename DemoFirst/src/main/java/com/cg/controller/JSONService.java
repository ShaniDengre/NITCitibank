package com.cg.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class JSONService {

	//Get type request
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackInJSON() {
		Track track = new Track();
		track.setTitle("SHANI DENGRE");
		track.setSinger(" shalu dengre");
		return track;
	}

	//Post type request
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Track createTrackInJSON(Track track) {
		String result = "Track saved : " + track;
		return track;
		// return Response.status(200).entity(track).build();

	}


}
