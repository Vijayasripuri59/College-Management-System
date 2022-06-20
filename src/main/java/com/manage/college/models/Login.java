package com.manage.college.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name="login")
	public class Login {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		@Column(name="username")
		private String username;
		@Column(name="password")
		private String password;
		
		
		 public Login() {
		    }
		
		public Login(long id, String username, String password) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
		}

		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}	

	}

