package com.alianza.alianzaapi.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteDTO {
	
		private String id;
		private String name;
		private String phone;
		private String email;
		private Date starDate;
		private Date endDate;
		private static final Logger logger = Logger.getLogger(ClienteDTO.class.getName());

		
		@JsonProperty("id")
		public String getId() {
			return id;
		}

		@JsonProperty("id")
		public void setId(String id) {
			this.id = id;
		}
		
		@JsonProperty("name")
		public String getName() {
			return name;
		}

		@JsonProperty("name")
		public void setName(String name) {
			this.name = name;
		}
		
		@JsonProperty("phone")
		public String getPhone() {
			return phone;
		}

		@JsonProperty("phone")
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
		@JsonProperty("email")
		public String getEmail() {
			return email;
		}

		@JsonProperty("email")
		public void setEmail(String email) {
			this.email = email;
		}
		
		@JsonProperty("starDate")
		public Date getStarDate() {
			return starDate;
		}
		
		@JsonProperty("starDate")
		public void setStarDate(Date starDate) {
			this.starDate = starDate;
		}
		
		@JsonProperty("endDate")
		public Date getEndDate() {
			return endDate;
		}
		
		@JsonProperty("endDate")
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		

}
